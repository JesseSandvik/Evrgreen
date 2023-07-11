package com.evergreen.plugin.handlers;

import com.evergreen.plugin.PluginContract;

public interface Handler {
    boolean handle(PluginContract plugin);
}
