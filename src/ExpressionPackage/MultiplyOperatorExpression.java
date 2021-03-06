package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class MultiplyOperatorExpression extends BinaryOperatorExpression{

    public MultiplyOperatorExpression() {
        super(BinaryOperatorsEnum.MULTIPLY);
    }

    public MultiplyOperatorExpression(Expression leftOperand, Expression rightOperand) {
        super(BinaryOperatorsEnum.MULTIPLY, leftOperand, rightOperand);
    }

    @Override
    public Expression derivative() {
        // (u*v)' = u'*v + u*v'
        MultiplyOperatorExpression leftMultDerivative = new MultiplyOperatorExpression(getLeftOperand().derivative(), getRightOperand());
        MultiplyOperatorExpression rightMultDerivative = new MultiplyOperatorExpression(getLeftOperand(), getRightOperand().derivative());
        return new AddOperatorExpression(leftMultDerivative, rightMultDerivative);
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return getLeftOperand().evaluate() * getRightOperand().evaluate();
    }
}
