package ExpressionPackage;

import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class NumberExpression implements Expression{

    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public Expression derivative() {
        return new NumberExpression(0);
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        return value;
    }

    @Override
    public void assignVarValue(VariableEnum var, int value) { }

    @Override
    public String toString() {
        return "" + value;
    }
}
