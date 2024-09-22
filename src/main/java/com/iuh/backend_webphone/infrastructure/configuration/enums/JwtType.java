package com.iuh.backend_webphone.infrastructure.configuration.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum JwtType {
    ACCESS_TOKEN, REFRESH_TOKEN, RESET_TOKEN;
}
