package com.wetherill.budgetbuddy.thin;

import com.wetherill.budgetbuddy.core.login.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class ContextController {

    @PostMapping("/context")
    public ResponseEntity<String> addContext(@RequestParam User user) {
        if (authenticate(user)) {
            String context = ContextManager.getInstance().getNewContext(user.getUsername());
            URI location = URI.create("");
            return ResponseEntity.created(location).body(context);
        }

        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    private boolean authenticate(User user) {
        // TODO
        return true;
    }

    @GetMapping("/context")
    public boolean checkContext(@RequestParam String contextId) {
        return ContextManager.getInstance().checkContext(contextId);
    }

}