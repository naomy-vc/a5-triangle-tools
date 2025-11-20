package triangle.abstractSyntaxTrees.commands;

import triangle.syntacticAnalyzer.SourcePosition;
import triangle.abstractSyntaxTrees.vnames.Vname;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;

public class DoubleCommand extends Command {

    public Vname vname;

    public DoubleCommand(Vname vname, SourcePosition position) {
        super(position);
        this.vname = vname;
    }

    @Override
    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> visitor, TArg arg) {
        return visitor.visitDoubleCommand(this,arg);
    }
    
}
