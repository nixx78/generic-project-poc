package lv.nixx.poc.common.security;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class AppUser {

    private String userId;
    private String userName;
    private String email;
    private Collection<String> roles;
    private String authSource;

}
