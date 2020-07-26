package com.wetherill.budgetbuddy.thin;

import com.wetherill.budgetbuddy.BudgetBuddyConfig;

import java.util.*;

public class ContextManager {

    private final static ContextManager instance = new ContextManager();

    private Timer contextTimer;
    private Map<String, String> activeContexts;

    private ContextManager() {
        contextTimer = new Timer("Contexts");
        activeContexts = new HashMap<>();
    }

    public static ContextManager getInstance() {
        return instance;
    }

    public String getNewContext(String username) {
        String contextId = UUID.randomUUID().toString();
        activeContexts.put(username, contextId);

        contextTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                activeContexts.remove(username);
            }
        }, BudgetBuddyConfig.getInstance().getContextTimeoutMilliseconds());

        return contextId;

        //TODO: currently, this put will replace an old context with a new one--but it won't remove the scheduled
        // event to remove the context by that username. If someone logs in twice in quick succession, there's
        // potential for their context to expire early.
        // Needs to be tweaked, w/ the scheduled event removed on a rewrite of a username's context.
    }

    public boolean checkContext(String contextId) {
        return activeContexts.containsValue(contextId);
    }

    public boolean checkUsername(String username) {
        return activeContexts.containsKey(username);
    }

}
