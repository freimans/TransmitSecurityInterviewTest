package Enums;

public enum SingleOperatorsEnum {
    SIN {
        @Override
        public String toString() {
            return "sin";
        }
    },
    COS {
        @Override
        public String toString() {
            return "cos";
        }
    }
}
