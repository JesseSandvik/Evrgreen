package com.blckroot.evrgreen.models;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    void COMMAND_MODEL__name() {
        String expected = "test";
        Command command = new Command(expected);

        String actual = command.getName();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__version() {
        String expected = "1.0.0";
        Command command = new Command("test");
        command.setVersion(expected);

        String actual = command.getVersion();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__synopsis() {
        String expected = "Test command synopsis";
        Command command = new Command("test");
        command.setSynopsis(expected);

        String actual = command.getSynopsis();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__description() {
        String expected = "Test command full description.";
        Command command = new Command("test");
        command.setDescription(expected);

        String actual = command.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__positional_parameters_default() {
        Command command = new Command("test");
        List<PositionalParameter> actual = command.getPositionalParameters();
        assertTrue(actual.isEmpty());
    }

    @Test
    void COMMAND_MODEL__positional_parameters_add__label() {
        String expected = "label";
        PositionalParameter positionalParameter = new PositionalParameter(expected, "");

        Command command = new Command("test");
        command.addPositionalParameter(positionalParameter);

        String actual = command.getPositionalParameters().get(0).getLabel();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__positional_parameters_add__synopsis() {
        String expected = "synopsis";
        PositionalParameter positionalParameter = new PositionalParameter("label", expected);

        Command command = new Command("test");
        command.addPositionalParameter(positionalParameter);

        String actual = command.getPositionalParameters().get(0).getSynopsis();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__positional_parameters_add__value__string() {
        String expected = "value";
        PositionalParameter positionalParameter = new PositionalParameter("label", "synopsis");
        positionalParameter.setValue(expected);

        Command command = new Command("test");
        command.addPositionalParameter(positionalParameter);

        Object actual = command.getPositionalParameters().get(0).getValue();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__positional_parameters_add__value__boolean() {
        boolean expected = true;
        PositionalParameter positionalParameter = new PositionalParameter("label", "synopsis");
        positionalParameter.setValue(expected);

        Command command = new Command("test");
        command.addPositionalParameter(positionalParameter);

        Object actual = command.getPositionalParameters().get(0).getValue();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_default() {
        Command command = new Command("test");
        List<Option> actual = command.getOptions();
        assertTrue(actual.isEmpty());
    }

    @Test
    void COMMAND_MODEL__options_add__long_name() {
        String expected = "--long";
        Option option = new Option(expected, "");

        Command command = new Command("test");
        command.addOption(option);

        String actual = command.getOptions().get(0).getLongName();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_add__short_name() {
        String expected = "-short";
        Option option = new Option("--long", expected, "");

        Command command = new Command("test");
        command.addOption(option);

        String actual = command.getOptions().get(0).getShortName();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_add__synopsis() {
        String expected = "synopsis";
        Option option = new Option("--long", "-short", expected);

        Command command = new Command("test");
        command.addOption(option);

        String actual = command.getOptions().get(0).getSynopsis();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_add__label() {
        String expected = "label";
        Option option = new Option("--long", "-short", "synopsis");
        option.setLabel(expected);

        Command command = new Command("test");
        command.addOption(option);

        String actual = command.getOptions().get(0).getLabel();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_add__value__string() {
        String expected = "value";
        Option option = new Option("--long", "-short", "synopsis");
        option.setValue(expected);

        Command command = new Command("test");
        command.addOption(option);

        Object actual = command.getOptions().get(0).getValue();
        assertEquals(expected, actual);
    }

    @Test
    void COMMAND_MODEL__options_add__value__boolean() {
        boolean expected = true;
        Option option = new Option("--long", "-short", "synopsis");
        option.setValue(expected);

        Command command = new Command("test");
        command.addOption(option);

        Object actual = command.getOptions().get(0).getValue();
        assertEquals(expected, actual);
    }
}
