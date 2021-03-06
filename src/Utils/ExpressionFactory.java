package Utils;

import Enums.BinaryOperatorsEnum;
import Enums.SingleOperatorsEnum;
import Enums.VariableEnum;
import ExceptionPackage.InvalidVariableException;
import ExpressionPackage.*;

public class ExpressionFactory {

    /**
     * Generate an expression out of a given string
     * @param expression String of an expression
     * @return Expression representing the given string
     * @throws InvalidVariableException if given string is not detected as an expression and didnt defined as a variable
     */
    public static Expression generateExpression(String expression) throws InvalidVariableException {
        if(expression.matches("[0-9]+"))
            return new NumberExpression(Integer.parseInt(expression));
        if(Utils.isValidVar(expression.toUpperCase()))
            return new VariableExpression(VariableEnum.valueOf(expression.toUpperCase()));
        if(Utils.isValidBinaryOperator(expression))
            return generateBinaryOperatorExpression(expression);
        if(Utils.isValidSingleOperator(expression))
            return generateSingleOperatorExpression(expression);
        throw new InvalidVariableException(expression + " is not a valid defined variable");
    }

    /**
     * Generates a SingleOperatorExpression from a given string
     * @param expression Strign to generate singleOperationExpression from
     * @return SingleOperationExpression representing the given string
     */
    private static SingleOperatorExpression generateSingleOperatorExpression(String expression) {
        if(expression.equals(SingleOperatorsEnum.SIN.toString()))
            return new SinOperatorExpression();
        if(expression.equals(SingleOperatorsEnum.COS.toString()))
            return new CosOperatorExpression();
        return null;
    }

    /**
     * Generates a BinaryOperatorExpression from a given string
     * @param expression String to generate BinaryOperatorExpression from
     * @return BinaryOperatorExpression representing the given string
     */
    private static BinaryOperatorExpression generateBinaryOperatorExpression(String expression) {
        if(expression.equals(BinaryOperatorsEnum.ADD.toString()))
            return new AddOperatorExpression();
        if(expression.equals(BinaryOperatorsEnum.SUBTRACT.toString()))
            return new SubtractOperatorExpression();
        if(expression.equals(BinaryOperatorsEnum.MULTIPLY.toString()))
            return new MultiplyOperatorExpression();
        if(expression.equals(BinaryOperatorsEnum.DIVIDE.toString()))
            return new DivideOperatorExpression();
        if(expression.equals(BinaryOperatorsEnum.POWER.toString()))
            return new PowerOperatorExpression();
        return null;
    }



}
