package uz.shoxvlogs.shoxvlogs.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.shoxvlogs.shoxvlogs.intity.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class SecUser implements UserDetails {

    private String username;
    private String password;
    private Boolean enabled;
    private Set<GrantedAuthority> authorities;

    public SecUser(){}

    public SecUser(String username, Set<GrantedAuthority> authorities){
        this.username = username;
        this.authorities = authorities;
    }



    public SecUser(User user){
        this.username = user.getLogin();
        this.password = user.getParol();
        this.enabled = user.getAktiv();
        this.authorities = user
                .getLavozimlar()
                .stream()
                .map(l -> new SimpleGrantedAuthority(l.toString())
                        ).collect(Collectors.toSet());
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }



}
