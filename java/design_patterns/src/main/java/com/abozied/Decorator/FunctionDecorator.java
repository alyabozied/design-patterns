package com.abozied.Decorator;

public abstract class FunctionDecorator extends Function {
    protected Function decoratedFunction;

    public FunctionDecorator(Function decoratedFunction) {
        this.decoratedFunction = decoratedFunction;
    }

    @Override
    public String getDescription() {
        return decoratedFunction.getDescription();
    }

    @Override
    public double execute(double input) {
        return decoratedFunction.execute(input);
    }

}
