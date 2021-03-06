package Utils;

import Enums.BinaryOperatorsEnum;
import Enums.SingleOperatorsEnum;
import Enums.VariableEnum;

public class Utils {

    /**
     * Checks if a given string is a valid variable
     * @param str String to check
     * @return true if the given string is a valid variable false otherwise
     */
    public static boolean isValidVar(String str) {
        for (VariableEnum var : VariableEnum.values()) {
            if (var.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given string is a valid binary operator
     * @param str String to check
     * @return true if the given string is a valid binary operator false otherwise
     */
    public static boolean isValidBinaryOperator(String str) {
        for (BinaryOperatorsEnum var : BinaryOperatorsEnum.values()) {
            if (var.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given string is a valid single operator
     * @param str String to check
     * @return true if the given string is a valid single operator false otherwise
     */
    public static boolean isValidSingleOperator(String str) {
        for (SingleOperatorsEnum var : SingleOperatorsEnum.values()) {
            if (var.toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds numeric sequence hat start in a given index in a given string
     * @param str string to find numeric sequence in
     * @param firstNumberIndex index to find numeric sequence from
     * @return The numeric sequence found
     */
    public static String findLongestNumericSequenceFromIndex(String str, int firstNumberIndex) {
        String numericSequence = "";
        for(int i=firstNumberIndex; i<str.length(); i++) {
            String character = "" + str.charAt(i);
            if(character.matches("[0-9]"))
                numericSequence += character;
            else
                return numericSequence;
        }
        return numericSequence;
    }
}
