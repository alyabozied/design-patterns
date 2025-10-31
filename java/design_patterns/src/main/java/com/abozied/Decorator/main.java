package com.abozied.Decorator;

public class main {
    public static void main(String[] args) {
        Function function = new SquareFunction(new SquareFunction(new Function() {
        }));
        System.out.println("Function: " + function.getDescription());
        double input = 2;
        double result = function.execute(input);
        System.out.println("f(" + input + ") = " + result);
    }
}
