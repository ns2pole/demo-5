package com.example.servingwebcontent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "contact_addresses")
public class ContactAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //信じられないがここをuser_idにするとspringbootが止まる。repositoryが止まるらしい。unbelivable!!こんなことがあっていいのか。
    //user_idなのかuserIdなのかなんて、どっちでもいいだろ!!頼むから気にしなくていいようにしてくれ!(2023/01/16 1:50)
    private int userId;
    private String phone;
    private String email;
}