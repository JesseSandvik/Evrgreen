package com.evergreen.picocli.subcommand.plugin.handlers;

import com.evergreen.picocli.subcommand.plugin.SubcommandPlugin;

public abstract class BaseHandler implements Handler {
    private Handler next;
    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }
    @Override
    public abstract boolean handle(SubcommandPlugin subcommandPlugin);
    protected boolean handleNext(SubcommandPlugin subcommandPlugin) {
        if (next == null) {
            return true;
        }
        return next.handle(subcommandPlugin);
    }
}
