package com.bohan.manalive.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String password;

    @Column(nullable = true)
    private String social;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column(nullable = true)
    private String nickname;

    @Column(nullable = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = true)
    String enable;

    @Builder
    public User(String name, String email, String picture, Role role, String social, String enable) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.social = social;
        this.enable = enable;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
