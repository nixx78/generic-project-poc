package lv.nixx.poc.common.security.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserFields {
    NAME("name"),
    EMAIL("email"),
    ROLES("roles"),
    AUTH_SOURCE("authSource");

    private final String name;

}
