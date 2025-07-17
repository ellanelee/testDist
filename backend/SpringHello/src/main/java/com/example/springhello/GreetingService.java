package com.example.springhello;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public String sayHelloWithLang(String langCode){
        return greetingRepository.findByLangCode(langCode).map(Greeting::getMessage).orElseThrow(() -> new NoSuchElementException("Greeting not found for language: " + langCode));
    }
}
