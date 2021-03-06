import Enums.VariableEnum;
import ExceptionPackage.InvalidVariableException;
import ExceptionPackage.UnassignedValueException;
import ExpressionPackage.Expression;
import Utils.ExpressionParser;

public class main {
    public static void main(String[] args) throws InvalidVariableException, UnassignedValueException {
        Expression exp = ExpressionParser.parseExpression("-x^7+x^5-3*x^2-x/0");
        exp.assignVarValue(VariableEnum.X, 3);
        System.out.println(exp.evaluate());
        exp = exp.derivative();
        System.out.println(exp);
        System.out.println(exp.evaluate());
    }
}
