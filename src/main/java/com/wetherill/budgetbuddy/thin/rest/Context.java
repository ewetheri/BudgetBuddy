package com.wetherill.budgetbuddy.thin.rest;

public class Context {

    private final String contextId;

    public Context(String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return contextId;
    }

}
