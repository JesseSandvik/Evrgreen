package com.evergreen.command;

public class Option {
    private final String[] names;
    private final String description;
    private Class<?> type = Boolean.class;
    private String paramLabel;

    public Option(String[] names, String description) {
        this.names = names;
        this.description = description;
    }

    public String[] getNames() {
        return names;
    }

    public String getDescription() {
        return description;
    }

    public Class<?> getType() {
        return type;
    }

    public String getParamLabel() {
        return paramLabel;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public void setParamLabel(String paramLabel) {
        this.paramLabel = paramLabel;
    }
}
