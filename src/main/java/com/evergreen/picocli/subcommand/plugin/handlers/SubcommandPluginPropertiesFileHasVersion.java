package com.evergreen.picocli.subcommand.plugin.handlers;

import com.evergreen.picocli.subcommand.plugin.SubcommandPlugin;

public class SubcommandPluginPropertiesFileHasVersion extends BaseHandler {
    private final SubcommandPlugin subcommandPlugin;
    public SubcommandPluginPropertiesFileHasVersion(SubcommandPlugin subcommandPlugin) {
        this.subcommandPlugin = subcommandPlugin;
    }
    @Override
    public boolean handle(SubcommandPlugin subcommandPlugin) {
        return false;
    }
}
