package Utils;

import ExceptionPackage.InvalidVariableException;
import ExpressionPackage.BinaryOperatorExpression;
import ExpressionPackage.Expression;
import ExpressionPackage.SingleOperatorExpression;

import java.util.LinkedList;
import java.util.Queue;

public class ExpressionParser {

    /**
     * Parse function string into an expression object
     * @param expression expression to parse
     * @return Expression object representing the given string
     * @throws InvalidVariableException if not known variable is in given function string
     */
    public static Expression parseExpression(String expression) throws InvalidVariableException {
        String infixExpression = InfixToPrefixConv.infixToPrefix(expression);
        Queue<Expression> expressionStack = createExpressionQueue(infixExpression);
        return mergeExpressions(expressionStack);

    }

    /**
     * Merge all the expressions in a given linkedList into one expression
     * @param expressionStack Linked list containing all of the expressions
     * @return Merged expression
     */
    private static Expression mergeExpressions(Queue<Expression> expressionStack) {
        Expression nextExpression = expressionStack.remove();
        if(!isEmptyOperator(nextExpression))
            return nextExpression;
        Expression leftOperand = mergeExpressions(expressionStack);
        Expression rightOperand = mergeExpressions(expressionStack);
        ((BinaryOperatorExpression)nextExpression).setLeftOperand(leftOperand);
        ((BinaryOperatorExpression)nextExpression).setRightOperand(rightOperand);
        return nextExpression;
    }

    /**
     * Check if an expression is an operator without operands
     * @param exprElement Expression to check
     * @return true if the expression is an empty operator, else otherwise
     */
    private static boolean isEmptyOperator(Expression exprElement) {
        return ((exprElement instanceof BinaryOperatorExpression) && (((BinaryOperatorExpression)exprElement).getLeftOperand() == null) ||
                (exprElement instanceof SingleOperatorExpression) && (((SingleOperatorExpression)exprElement).getOperand() == null));
    }

    /**
     * Creates an expression queue from all the atom expressions in given string
     * @param infixExpression string to extract expressions from
     * @return Queue filled with all smallest expressions in the given string
     * @throws InvalidVariableException if undefined variable has detected
     */
    private static Queue<Expression> createExpressionQueue(String infixExpression) throws InvalidVariableException {
        Queue<Expression> res = new LinkedList<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            String element = "" + infixExpression.charAt(i);
            if (element.matches("[0-9]+")) {
                element = Utils.findLongestNumericSequenceFromIndex(infixExpression, i);
                i += element.length()-1;
            }
            if(infixExpression.charAt(i) != ',')
                res.add(ExpressionFactory.generateExpression(element));
        }
        return res;
    }
}
