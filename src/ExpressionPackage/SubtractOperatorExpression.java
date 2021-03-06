package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class SubtractOperatorExpression extends BinaryOperatorExpression{

    public SubtractOperatorExpression() {
        super(BinaryOperatorsEnum.SUBTRACT);
    }

    public SubtractOperatorExpression(Expression leftOperand, Expression rightOperand) {
        super(BinaryOperatorsEnum.SUBTRACT, leftOperand, rightOperand);
    }

    @Override
    public Expression derivative() {
        return new SubtractOperatorExpression(getLeftOperand().derivative(), getRightOperand().derivative());
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return getLeftOperand().evaluate() - getRightOperand().evaluate();
    }
}
