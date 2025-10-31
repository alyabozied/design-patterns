package com.abozied.Decorator;

public class SquareRootFunction extends FunctionDecorator {

    public SquareRootFunction(Function decoratedFunction) {
        super(decoratedFunction);
    }
    
    public String getDescription() {
        return "√(" + decoratedFunction.getDescription() +")";
    }

    public double execute(double input) {
        double result = decoratedFunction.execute(input);
        return Math.sqrt(result);
    }
}
