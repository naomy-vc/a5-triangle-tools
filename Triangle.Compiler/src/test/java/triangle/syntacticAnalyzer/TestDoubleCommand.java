package triangle.syntacticAnalyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import triangle.abstractSyntaxTrees.commands.Command;
import triangle.abstractSyntaxTrees.commands.DoubleCommand;
import triangle.abstractSyntaxTrees.commands.SequentialCommand;
import triangle.abstractSyntaxTrees.terminals.Identifier;
import triangle.abstractSyntaxTrees.vnames.SimpleVname;
import triangle.abstractSyntaxTrees.vnames.Vname;

public class TestDoubleCommand {

    @Test
    public void testContainsDoubleCommandInSimpleTree() {
        SourcePosition pos = new SourcePosition();
        Identifier id = new Identifier("a", pos);
        Vname v = new SimpleVname(id, pos);
        Command doubleCmd = new DoubleCommand(v, pos);
        Command root = new SequentialCommand(doubleCmd, null, pos);
        assertTrue(containsDoubleCommand(root));
    }

    private boolean containsDoubleCommand(Command command) {
        if (command == null) {
            return false;
        }
        if (command instanceof DoubleCommand) {
            return true;
        }
        if (command instanceof SequentialCommand) {
            SequentialCommand seq = (SequentialCommand) command;
            return containsDoubleCommand(seq.C1) || containsDoubleCommand(seq.C2);
        }
        return false;
    }
}

