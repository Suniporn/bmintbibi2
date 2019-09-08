package com.example.bmintbibi.Model;

public class Auth {
    private static final String EMAIL = "bmint";
    private  static  final String PAAWORD = "123";

    private  String mEmail ;
    private  String mPassword ;

    public Auth(String email,String password){
        this.mEmail =email;
        this.mPassword=password;
    }
    public  boolean check() {
        if (mEmail.equals(EMAIL)&&mPassword.equals(PAAWORD))
        {
            return true;
        }
    else {
        return  false;
        }
    }

}
