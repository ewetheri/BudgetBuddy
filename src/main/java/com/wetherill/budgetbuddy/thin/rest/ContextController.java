package com.wetherill.budgetbuddy.thin.rest;

import com.wetherill.budgetbuddy.thin.ContextManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContextController {

    @PostMapping("/context")
    public Context context(@RequestParam String username, @RequestParam String password) {
        return new Context(ContextManager.getInstance().getNewContext());
    }

}