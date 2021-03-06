The static class ExpressionParser parses String of a function into an Expression object using an external code for infixToPrefix algorithm.

Function String requirements:
* No spaces between function elements
* In multiplication, the * sign must be written (3*x, no 3x)
* The program will be able to parse 2 variable function and evaluate it with the assigned values, but no derivative can be accomplished

Accepted function elements:
* Any natural number
* Any variable that is defined in the VariableEnum
* Any of the following operators: + , - , * , / , ^
* parenthesis: ) , (
    
Resources:
* infixToPrefix - https://www.geeksforgeeks.org/infix-to-prefix-conversion-using-two-stacks/