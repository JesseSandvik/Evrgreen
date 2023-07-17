package com.evergreen.picocli.subcommand.plugin.handlers;

import com.evergreen.picocli.subcommand.plugin.SubcommandPlugin;

public class SubcommandPluginPropertiesFileHasDescription extends BaseHandler {
    private final SubcommandPlugin subcommandPlugin;
    public SubcommandPluginPropertiesFileHasDescription(SubcommandPlugin subcommandPlugin) {
        this.subcommandPlugin = subcommandPlugin;
    }
    @Override
    public boolean handle(SubcommandPlugin subcommandPlugin) {
        return false;
    }
}