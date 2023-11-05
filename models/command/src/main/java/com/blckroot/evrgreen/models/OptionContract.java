package com.blckroot.evrgreen.models;

interface OptionContract {
    String getLongName();
    String getShortName();
    String getSynopsis();
    String getLabel();
    void setLabel(String label);
    Object getValue();
    void setValue(Object value);
}
