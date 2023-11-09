package com.blckroot.evrgreen.models.positionalParameter;

public class PositionalParameter implements PositionalParameterContract {
    private final String label;
    private final String synopsis;
    private Object value;

    public PositionalParameter(String label, String synopsis) {
        this.label = label;
        this.synopsis = synopsis;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getSynopsis() {
        return synopsis;
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
