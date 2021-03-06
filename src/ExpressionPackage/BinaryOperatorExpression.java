package ExpressionPackage;

import Enums.BinaryOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public abstract class BinaryOperatorExpression implements Expression{

    private BinaryOperatorsEnum operator;
    private Expression leftOperand;
    private Expression rightOperand;

    public BinaryOperatorExpression(BinaryOperatorsEnum operator) {
        this.operator = operator;
    }

    public BinaryOperatorExpression(BinaryOperatorsEnum operator, Expression leftOperand, Expression rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public abstract Expression derivative();

    @Override
    public abstract double evaluate() throws UnassignedValueException;

    @Override
    public void assignVarValue(VariableEnum var, int value) {
        getLeftOperand().assignVarValue(var, value);
        getRightOperand().assignVarValue(var, value);
    }

    @Override
    public String toString() {
        if(leftOperand != null && rightOperand != null) {
            if(operator.toString().equals("*") ) {
                if (leftOperand.toString().equals("0") || rightOperand.toString().equals("0"))
                    return "0";
                if (leftOperand.toString().equals("1"))
                    return rightOperand.toString();
                if (rightOperand.toString().equals("1"))
                    return leftOperand.toString();
            }
            if(operator.toString().equals("+")) {
                if (leftOperand.toString().equals("0") && rightOperand.toString().equals("0"))
                    return "0";
                if (leftOperand.toString().equals("0"))
                    return rightOperand.toString();
                if (rightOperand.toString().equals("0"))
                    return leftOperand.toString();
            }

            if(operator.toString().equals("-"))
                if(rightOperand.toString().equals("0"))
                    return leftOperand.toString();
                if(leftOperand.toString().equals("0"))
                    return "-" + rightOperand;

            if(operator.toString().equals("/") && leftOperand.toString().equals("0"))
                return "0";

            if(operator.toString().equals("^")) {
                if (rightOperand.toString().equals("0"))
                    return "1";
                if (rightOperand.toString().equals("1"))
                    return leftOperand.toString();
            }

            return leftOperand.toString() + operator.toString() + rightOperand.toString();
        }
        else
            return operator.toString();
    }

    public BinaryOperatorsEnum getOperator() {
        return operator;
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }
}
