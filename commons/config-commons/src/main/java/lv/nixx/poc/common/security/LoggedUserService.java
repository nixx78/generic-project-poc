package lv.nixx.poc.common.security;

import java.util.List;

public class LoggedUserService {

    private final AppUser user = AppUser.builder()
            .userId("UserId.Value")
            .userName("User, Name")
            .email("user@my.mail")
            .roles(List.of("ROLE_1", "ROLE_2"))
            .authSource("LDAP")
            .build();

    public AppUser getLoggedUser() {
        return user;
    }

    public String getLoggedUserName() {
        return user.getUserName();
    }

    public String getLoggerUserId() {
        return user.getUserId();
    }

}
