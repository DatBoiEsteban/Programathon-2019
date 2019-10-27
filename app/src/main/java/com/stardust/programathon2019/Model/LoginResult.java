package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class LoginResult {
    String access_token;
    int expires_in;
    String token_type;
    String refresh_token;
    String scope;
    UserInfo userInfo;

    @SuppressWarnings("unchecked")
    @JsonProperty("LoginData")

    private void unpackLoginData(Map<String,Object> LoginData) {
        this.access_token = (String)LoginData.get("access_token");
        this.expires_in = (Integer)LoginData.get("expires_in");
        this.token_type = (String)LoginData.get("token_type");
        this.refresh_token = (String)LoginData.get("refresh_token");
        this.scope = (String)LoginData.get("scope");

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("UserInfo")
    private void unpackUserInfo(Map<String,Object> UserInfo) {
          String givenName  = (String)UserInfo.get("givenName");
        String email  = (String)UserInfo.get("email");
        int uid  = (Integer)UserInfo.get("uid");
        String role  = (String)UserInfo.get("role");

        this.userInfo = new UserInfo(uid,givenName,email,role);

    }


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
