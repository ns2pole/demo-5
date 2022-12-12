package com.example.servingwebcontent.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String password;
    private String name;

    private String role;

    private int division_id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public int getDivisionId() { return division_id;}

    public void setDivisionId(int divisionId) { this.division_id = divisionId; }

    //idでユーザのインスタンスを取得
//    public static User getUserBy(id) {
//        re
//    }
//
//    //同じ部署に所属するユーザーの全Idを取得する
//    public ArrayList<Integer> getUserIdsSameDivision() {
//
//        return
//    }
//
//    //今ログインしているユーザーのインスタンスを作る
//    User user = User.getUserBy(login_user_id);
//    //同じ部署の全ユーザーIDを取得
//    ArrayList<Integer> ids = user.getUserIdsSameDivision();
}