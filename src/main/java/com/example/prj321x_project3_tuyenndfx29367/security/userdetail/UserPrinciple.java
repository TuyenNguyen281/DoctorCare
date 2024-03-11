package com.example.prj321x_project3_tuyenndfx29367.security.userdetail;


import com.example.prj321x_project3_tuyenndfx29367.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrinciple implements UserDetails {

    private static final int serialVersionUID = 1;
    private int id;

    private String name;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> roles;


    public UserPrinciple(int id, String name, String email, String password, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName());
        grantedAuthorityList.add(authority);
        return new UserPrinciple(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                grantedAuthorityList);


    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
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
        return true;
    }

    @Override
    public String toString() {
        return "UserPrinciple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
