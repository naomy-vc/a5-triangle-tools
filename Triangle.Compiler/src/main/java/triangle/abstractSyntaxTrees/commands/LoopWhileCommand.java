package triangle.abstractSyntaxTrees.commands;

import triangle.syntacticAnalyzer.SourcePosition;
import triangle.abstractSyntaxTrees.expressions.Expression;
import triangle.abstractSyntaxTrees.visitors.CommandVisitor;

public class LoopWhileCommand extends Command {

    public Command C1;
    public Expression E;
    public Command C2;

    public LoopWhileCommand(Command c1AST, Expression eAST, Command c2AST, SourcePosition pos) {
        super(pos);
        this.C1 = c1AST;
        this.E = eAST;
        this.C2 = c2AST;
    }

    @Override
    public <TArg, TResult> TResult visit(CommandVisitor<TArg, TResult> v, TArg arg) {
        return v.visitLoopWhileCommand(this, arg);
    }
}
