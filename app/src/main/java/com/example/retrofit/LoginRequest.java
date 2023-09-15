package com.example.retrofit;

public class LoginRequest {
    String os;
    String version;
    String username;
    String password;
    String user_type;
    String os_version;
    String device_token;
    String device_id;
    String email;
    String password2;

    public LoginRequest(String email, String password2) {
        this.email = email;
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public LoginRequest(String os, String version, String username, String password, String user_type, String os_version, String device_token, String device_id) {
        this.os = os;
        this.version = version;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.os_version = os_version;
        this.device_token = device_token;
        this.device_id = device_id;
    }

    public LoginRequest() {
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

}
