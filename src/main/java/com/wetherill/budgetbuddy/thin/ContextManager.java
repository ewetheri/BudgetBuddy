package com.wetherill.budgetbuddy.thin;

import com.wetherill.budgetbuddy.BudgetBuddyConfig;

import java.util.*;

public class ContextManager {

    private final static ContextManager instance = new ContextManager();

    private Timer contextTimer;
    private Set<String> activeContexts;

    private ContextManager() {
        contextTimer = new Timer("Contexts");
        activeContexts = new HashSet<>();
    }

    public static ContextManager getInstance() {
        return instance;
    }

    public String getNewContext() {
        String contextId = UUID.randomUUID().toString();
        activeContexts.add(contextId);

        contextTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                activeContexts.remove(contextId);
            }
        }, BudgetBuddyConfig.getInstance().getContextTimeoutMilliseconds());

        return contextId;
    }

    private boolean check(String contextId) {
        return activeContexts.contains(contextId);
    }

}
