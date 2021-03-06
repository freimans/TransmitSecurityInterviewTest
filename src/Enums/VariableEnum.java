package Enums;

public enum VariableEnum {
    X {
        @Override
        public String toString() {
            return "X";
        }
    },
    Y {
        @Override
        public String toString() {
            return "Y";
        }
    }
}
