import Enums.VariableEnum;
import ExceptionPackage.InvalidVariableException;
import ExceptionPackage.UnassignedValueException;
import ExpressionPackage.Expression;
import Utils.ExpressionParser;

public class main {
    public static void main(String[] args) throws InvalidVariableException, UnassignedValueException {
        // Enter your function here
        Expression exp = ExpressionParser.parseExpression("x^2+5*x+6+y");
        // Assign value to variable
        exp.assignVarValue(VariableEnum.X, 3);
        exp.assignVarValue(VariableEnum.Y, 6);
        System.out.println(exp.evaluate());
        Expression derExp = exp.derivative();
        System.out.println(derExp);
        System.out.println(derExp.evaluate());
    }
}
