package pl.milypol.magazinestatus.seciurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.milypol.magazinestatus.entity.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.milypol.magazinestatus.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.milypol.magazinestatus.entity.User getUser() {return user;}
}
