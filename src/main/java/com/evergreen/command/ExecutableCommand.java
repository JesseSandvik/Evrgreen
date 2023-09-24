package com.evergreen.command;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ExecutableCommand extends Command implements Callable<Integer> {
    private final Map<String, Object> valuesToPositionalParameterLabels = new LinkedHashMap<>();
    private final Map<String, Object> valuesToOptionsLongestName = new LinkedHashMap<>();

    public ExecutableCommand(String name) {
        super(name);
    }

    public ExecutableCommand(String name, String version) {
        super(name, version);
    }

    public Map<String, Object> getValuesToPositionalParameterLabels() {
        return valuesToPositionalParameterLabels;
    }

    public Map<String, Object> getValuesToOptionsLongestName() {
        return valuesToOptionsLongestName;
    }

    public void mapValueToPositionalParameterLabel(String positionalParameterLabel, Object value) {
        valuesToPositionalParameterLabels.put(positionalParameterLabel, value);
    }

    public void mapValueToOptionLongestName(String optionLongestName, Object value) {
        valuesToOptionsLongestName.put(optionLongestName, value);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
