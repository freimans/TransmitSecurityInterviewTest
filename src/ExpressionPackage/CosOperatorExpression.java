package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.SingleOperatorsEnum;
import ExceptionPackage.UnassignedValueException;

public class CosOperatorExpression extends SingleOperatorExpression{

    public CosOperatorExpression() {
        super(SingleOperatorsEnum.COS);
    }

    public CosOperatorExpression(Expression operand) {
        super(SingleOperatorsEnum.COS, operand);
    }

    @Override
    public Expression derivative() {
        // cos(u)' = u' * (0-sin(u))
        SubtractOperatorExpression rightDerivativeSide = new SubtractOperatorExpression(new NumberExpression(0), new SinOperatorExpression(getOperand()));
        return new MultiplyOperatorExpression(getOperand().derivative(), rightDerivativeSide);
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return Math.cos(getOperand().evaluate());
    }

}
