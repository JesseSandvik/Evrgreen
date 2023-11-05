package com.blckroot.evrgreen.models;

public class Option implements OptionContract {
    private final String longName;
    private final String shortName;
    private final String synopsis;
    private String label;
    private Object value;

    public Option(String longName, String synopsis) {
        this.longName = longName;
        this.shortName = null;
        this.synopsis = synopsis;
    }

    public Option(String longName, String shortName, String synopsis) {
        this.longName = longName;
        this.shortName = shortName;
        this.synopsis = synopsis;
    }

    @Override
    public String getLongName() {
        return longName;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
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
