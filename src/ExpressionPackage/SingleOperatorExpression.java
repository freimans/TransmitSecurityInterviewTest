package ExpressionPackage;

import Enums.SingleOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public abstract class SingleOperatorExpression implements Expression{

    private SingleOperatorsEnum operator;
    private Expression operand;

    public SingleOperatorExpression(SingleOperatorsEnum operator) {
        this.operator = operator;
    }

    public SingleOperatorExpression(SingleOperatorsEnum operator, Expression operand) {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public abstract Expression derivative();

    @Override
    public abstract double evaluate() throws UnassignedValueException;

    @Override
    public void assignVarValue(VariableEnum var, int value) {
        this.operand.assignVarValue(var, value);
    }

    @Override
    public String toString() {
        if(operand != null)
            return this.operator.toString() + "(" + this.operand.toString() + ")";
        return this.operator.toString();
    }

    public SingleOperatorsEnum getOperator() {
        return operator;
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }
}
