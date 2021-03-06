package ExpressionPackage;

import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public class VariableExpression implements Expression{

    private VariableEnum var;
    private Integer value;

    public VariableExpression(VariableEnum var) {
        this.var = var;
        this.value = null;
    }

    @Override
    public Expression derivative() {
        return new NumberExpression(1);
    }

    @Override
    public double evaluate() throws UnassignedValueException {
        if(value != null)
            return this.value.intValue();
        throw  new UnassignedValueException(this.var + " value never been assigned");
    }

    @Override
    public void assignVarValue(VariableEnum var, int value) {
        if(this.var == var)
            this.value = value;
    }

    @Override
    public String toString() {
        return this.var.toString();
    }
}
