package com.blckroot.evrgreen.models;

public class PositionalParameter implements PositionalParameterContract {
    private final String label;
    private final String description;
    private Object value;

    public PositionalParameter(String label, String description) {
        this.label = label;
        this.description = description;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}
