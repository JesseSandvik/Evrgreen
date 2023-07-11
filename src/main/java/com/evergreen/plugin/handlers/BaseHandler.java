package com.evergreen.plugin.handlers;

import com.evergreen.plugin.PluginContract;

public abstract class BaseHandler implements Handler {
    private Handler next;
    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(PluginContract plugin);

    protected boolean handleNext(PluginContract plugin) {
        if (next == null) {
            return true;
        }
        return next.handle(plugin);
    }
}
