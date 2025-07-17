package com.example.springhello;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="greetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lang_code", unique = true, nullable = false)
    private String langCode;

    @Column(nullable = false)
    private String message;
}
