package com.example.springhello;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam String lang) {
        String message = greetingService.sayHelloWithLang(lang);
        return ResponseEntity.ok(message);
    }
}

