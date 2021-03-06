package ExpressionPackage;

import Enums.VariableEnum;
import ExceptionPackage.UnassignedValueException;

public interface Expression {

    /**
     * Calculate the derivative of the expression
     * @return The derivative of the expression
     */
    public Expression derivative();

    /**
     * Evaluates the value of the expression with the value of given variable value
     * @return The value of the expression with the given variables value. Throws ExceptionPackage.UnassignedValueException if variable value not assigned
     * @throws UnassignedValueException
     */
    public double evaluate() throws UnassignedValueException;

    /**
     * Assigns value to variable
     * @param var Variable to assign value to
     * @param value The value to assign to variable
     */
    public void assignVarValue(VariableEnum var, int value);

}
