package com.wetherill.budgetbuddy;

public class BudgetBuddyConfig {

    private final static BudgetBuddyConfig instance = new BudgetBuddyConfig();

    // Timeout contexts in 30 minutes
    private final int GET_CONTEXT_TIMEOUT_IN_MILLISECONDS = 1800000;

    private BudgetBuddyConfig() {}

    public static BudgetBuddyConfig getInstance() {
        return instance;
    }

    public int getContextTimeoutMilliseconds() {
        return GET_CONTEXT_TIMEOUT_IN_MILLISECONDS;
    }

}
