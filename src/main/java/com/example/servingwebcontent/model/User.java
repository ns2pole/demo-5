package com.example.servingwebcontent.model;

import lombok.Getter;
import javax.persistence.*;
import java.util.Collection;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String name;
    private String role;
    private int division_id;

    public String getUsername() {
        return this.name;
    }

    public int getDivisionId(){ return this.division_id;}

    public boolean isAccountNonExpired() {
        return true;
    }
    
    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }


}