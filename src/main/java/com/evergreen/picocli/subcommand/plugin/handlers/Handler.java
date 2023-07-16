package com.evergreen.picocli.subcommand.plugin.handlers;

import com.evergreen.picocli.subcommand.plugin.SubcommandPlugin;

public interface Handler {
    boolean handle(SubcommandPlugin subcommandPlugin);
}
