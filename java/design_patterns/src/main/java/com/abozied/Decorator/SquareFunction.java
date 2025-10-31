package com.abozied.Decorator;

public class SquareFunction extends FunctionDecorator{
    public SquareFunction(Function decoratedFunction) {
        super(decoratedFunction);
    }

    @Override
    public String getDescription() {
        return "(" + decoratedFunction.getDescription() + ")²";
    }

    @Override
    public double execute(double input) {
        double result = decoratedFunction.execute(input);
        return result * result;
    }

}
