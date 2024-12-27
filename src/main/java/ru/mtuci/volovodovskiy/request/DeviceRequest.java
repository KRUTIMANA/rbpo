package ru.mtuci.volovodovskiy.request;

import lombok.Data;

@Data
public class DeviceRequest {
    private String activationCode, name, macAddress;
}
