package ru.mtuci.volovodovskiy.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String login, email, password;
}
