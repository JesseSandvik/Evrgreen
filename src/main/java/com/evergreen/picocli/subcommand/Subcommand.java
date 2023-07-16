package com.evergreen.picocli.subcommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subcommand {
    private String name;
    private String description;
    private List<String> parameters = new ArrayList<>();
    private Map<Character, String> options = new HashMap<>();
    public Subcommand(String name) {
        this.name = name;
    }
    public Subcommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Subcommand(String name, String description, List<String> parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }
    public Subcommand(String name, String description, List<String> parameters, Map<Character, String> options) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
        this.options = options;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getParameters() {
        return parameters;
    }
    public void setParameters(ArrayList<String> parameters) {
        this.parameters = parameters;
    }
    public Map<Character, String> getOptions() {
        return options;
    }
    public void setOptions(Map<Character, String> options) {
        this.options = options;
    }
}