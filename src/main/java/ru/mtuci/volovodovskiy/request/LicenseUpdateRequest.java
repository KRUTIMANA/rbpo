package ru.mtuci.volovodovskiy.request;

import lombok.Data;

@Data
public class LicenseUpdateRequest {
    private String password, codeActivation, durationAdd;
}
