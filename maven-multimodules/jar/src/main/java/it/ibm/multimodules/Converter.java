package it.ibm.multimodules;

public class Converter {

    // tag::getFeetMethod[]
    public static int getFeet(int cm) {
        return (int) (cm / 30.48);
    }
    // end::getFeetMethod[]

    // tag::getInchesMethod[]
    public static int getInches(int cm){
        double feet = cm / 30.48;
        return (int) (cm / 2.54) - ((int) feet * 12);
    }
    // end::getInchesMethod[]

    public static int sum(int a, int b){
        return a + b;
    }

    public static int diff(int a, int b){
        return a - b;
    }

    public static int product(int a, int b){
        return a * b;
    }

    public static int quotient(int a, int b){
        return a / b;
    }
}
