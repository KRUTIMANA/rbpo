package ru.mtuci.volovodovskiy.service;


import ru.mtuci.volovodovskiy.model.ApplicationUser;

public interface AutheneticationService {
    boolean authenticate(ApplicationUser user, String password);
}
