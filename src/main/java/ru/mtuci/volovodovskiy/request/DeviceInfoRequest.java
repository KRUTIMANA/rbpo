package ru.mtuci.volovodovskiy.request;

import lombok.Data;

@Data
public class DeviceInfoRequest {
    private String name, macAddress, activationCode;
}
