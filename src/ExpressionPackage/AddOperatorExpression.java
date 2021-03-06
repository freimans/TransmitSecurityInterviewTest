package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class AddOperatorExpression extends BinaryOperatorExpression {

    public AddOperatorExpression() {
        super(BinaryOperatorsEnum.ADD);
    }

    public AddOperatorExpression(Expression leftOperand, Expression rightOperand) {
        super(BinaryOperatorsEnum.ADD, leftOperand, rightOperand);
    }

    @Override
    public Expression derivative() {
        return new AddOperatorExpression(getLeftOperand().derivative(), getRightOperand().derivative());
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return getLeftOperand().evaluate() + getRightOperand().evaluate();
    }
}
