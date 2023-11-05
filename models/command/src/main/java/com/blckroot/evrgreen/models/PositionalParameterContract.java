package com.blckroot.evrgreen.models;

interface PositionalParameterContract {
    String getLabel();
    String getSynopsis();
    Object getValue();
    void setValue(Object value);
}
