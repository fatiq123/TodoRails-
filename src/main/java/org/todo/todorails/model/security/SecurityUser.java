package org.todo.todorails.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.todo.todorails.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    // TODO 6: update the SecurityUser model
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(
                user.getRoles().split(",")
        ).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

}
