package ru.mtuci.volovodovskiy.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login, password;
}
