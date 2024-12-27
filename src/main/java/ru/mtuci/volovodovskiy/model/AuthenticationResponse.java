package ru.mtuci.volovodovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String login;
    private String token;
}
