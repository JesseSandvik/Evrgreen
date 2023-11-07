package com.blckroot.evrgreen.models.positionalParameter;

interface PositionalParameterContract {
    String getLabel();
    String getSynopsis();
    Object getValue();
    void setValue(Object value);
}
