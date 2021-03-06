package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class DivideOperatorExpression extends BinaryOperatorExpression{

    public DivideOperatorExpression() {
        super(BinaryOperatorsEnum.DIVIDE);
    }

    public DivideOperatorExpression(Expression leftOperand, Expression rightOperand) {
        super(BinaryOperatorsEnum.DIVIDE, leftOperand, rightOperand);
        checkDivisionByZero(rightOperand);
    }

    @Override
    public Expression derivative() {
        // (u/v)' = (u'*v - u*v')/(v^2)
        MultiplyOperatorExpression leftMultDerivative = new MultiplyOperatorExpression(getLeftOperand().derivative(), getRightOperand());
        MultiplyOperatorExpression rightMultDerivative = new MultiplyOperatorExpression(getLeftOperand(), getRightOperand().derivative());
        SubtractOperatorExpression leftDerivativeSide = new SubtractOperatorExpression(leftMultDerivative, rightMultDerivative);
        PowerOperatorExpression rightDerivativeSide = new PowerOperatorExpression(getRightOperand(), new NumberExpression(2));
        return new DivideOperatorExpression(leftDerivativeSide, rightDerivativeSide);
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return getLeftOperand().evaluate() / getRightOperand().evaluate();
    }

    @Override
    public void setRightOperand(Expression rightOperand) {
        checkDivisionByZero(rightOperand);
        super.setRightOperand(rightOperand);
    }

    /**
     * Check division by zero, throws ArithmeticException if division by zero detected
     * @param rightOperand operand to check
     */
    private void checkDivisionByZero(Expression rightOperand) {
        try {
            if(rightOperand instanceof NumberExpression && rightOperand.evaluate() == 0)
                throw new ArithmeticException("Cannot divide by zero");
        } catch (UnassignedValueException e) {}
    }
}
