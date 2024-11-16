package com.cleveronion.onionAuth;

import java.util.ArrayList;

public class LoginData {
    private static final ArrayList<String> loginData = new ArrayList<>();

    public static void addLoginData(String data) {
        if (!loginData.contains(data)) {
            loginData.add(data.toLowerCase());
        }
    }

    public static void removeLoginData(String data) {
        if (loginData.contains(data)) {
            loginData.remove(data.toLowerCase());
        }
    }

    public static boolean contains(String data) {
        return loginData.contains(data.toLowerCase());
    }


}
