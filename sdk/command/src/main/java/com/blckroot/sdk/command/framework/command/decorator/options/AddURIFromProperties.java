package com.blckroot.sdk.command.framework.command.decorator.options;

import com.blckroot.sdk.command.framework.command.FrameworkBaseCommand;
import com.blckroot.sdk.command.framework.command.decorator.FrameworkCommandDecorator;
import com.blckroot.sdk.command.model.Option;

public class AddURIFromProperties extends FrameworkCommandDecorator {

    public AddURIFromProperties(FrameworkBaseCommand frameworkCommand) {
        super(frameworkCommand);
    }

    @Override
    public Integer call() throws Exception {
        final String URI_PROPERTY_KEY="uri";
        Option option = new Option();
        option.setLongName("--uri-from-properties");
        option.setLabel("<uri>");
        option.setValue(super.getProperties().getProperty(URI_PROPERTY_KEY));
        super.addOption(option);

        System.out.println("[ SUCCESSFULLY ATTACHED HTTP URI ]");
        return super.call();
    }
}
