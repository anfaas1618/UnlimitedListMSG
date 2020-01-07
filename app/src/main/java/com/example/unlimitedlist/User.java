package com.example.unlimitedlist;

public class User  {
  private   String UserName;
  private   String email;
   private String Uid;

    public User(String name, String email, String uid) {
        this.UserName = name;
        this.email = email;
        Uid = uid;
    }

    public String getName() {
        return UserName;
    }

    public void setName(String name) {
        this.UserName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
