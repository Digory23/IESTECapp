package com.example.iestecapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest
{

    private static final String LOGIN_REQUEST_URL = "http://192.168.1.2/IESTEC-DES7/api/Login.php";
    private Map<String,String> params;
    public LoginRequest(String ticket, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("tiquete",ticket);
    }
    @Override
    public Map<String, String> getParams(){return params;}

}
