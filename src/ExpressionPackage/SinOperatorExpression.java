package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.SingleOperatorsEnum;
import ExceptionPackage.UnassignedValueException;

public class SinOperatorExpression extends SingleOperatorExpression{

    public SinOperatorExpression() {
        super(SingleOperatorsEnum.SIN);
    }

    public SinOperatorExpression(Expression operand) {
        super(SingleOperatorsEnum.SIN, operand);
    }

    @Override
    public Expression derivative() {
        // sin(u)' = u' * cos(u)
        return new MultiplyOperatorExpression(getOperand().derivative(), new CosOperatorExpression(getOperand()));
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return Math.sin(getOperand().evaluate());
    }
}
