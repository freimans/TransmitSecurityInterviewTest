package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PowerOperatorExpression extends BinaryOperatorExpression{

    public PowerOperatorExpression() {
        super(BinaryOperatorsEnum.POWER);
    }

    public PowerOperatorExpression(Expression leftOperand, Expression rightOperand) {
        super(BinaryOperatorsEnum.POWER, leftOperand, rightOperand);
        if(!(rightOperand instanceof NumberExpression))
            throw new NotImplementedException();
    }

    @Override
    public Expression derivative() {
        // (u^n)' = n * u^(n-1)
        try {
            PowerOperatorExpression powerDerivative = new PowerOperatorExpression(getLeftOperand(), new NumberExpression((int)getRightOperand().evaluate() - 1));
            return new MultiplyOperatorExpression(getRightOperand(), powerDerivative);
        } catch (UnassignedValueException e) { return null; }
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return Math.pow(getLeftOperand().evaluate(),getRightOperand().evaluate());
    }
}
