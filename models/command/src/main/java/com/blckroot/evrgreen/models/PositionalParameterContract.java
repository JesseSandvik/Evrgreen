package com.blckroot.evrgreen.models;

interface PositionalParameterContract {
    String getLabel();
    String getDescription();
    Object getValue();
    void setValue(Object value);
}
