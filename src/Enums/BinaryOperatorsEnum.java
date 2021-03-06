package Enums;

import ExpressionPackage.AddOperatorExpression;
import ExpressionPackage.Expression;

public enum BinaryOperatorsEnum {
    ADD {
        @Override
        public String toString() {
            return "+";
        }
    },
    SUBTRACT {
        @Override
        public String toString() {
            return "-";
        }
    },
    MULTIPLY {
        @Override
        public String toString() {
            return "*";
        }
    },
    DIVIDE {
        @Override
        public String toString() {
            return "/";
        }
    },
    POWER {
        @Override
        public String toString() {
            return "^";
        }
    }
}
