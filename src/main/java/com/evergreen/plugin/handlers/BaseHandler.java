package com.evergreen.plugin.handlers;

public abstract class BaseHandler implements Handler {
    private Handler next;
    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }
    public abstract boolean handle(String pluginName);
    protected boolean handleNext(String pluginName) {
        if (next == null) {
            return true;
        }
        return next.handle(pluginName);
    }
}