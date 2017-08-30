package com.wedding.datamanager.services;

/**
 * Created by pipe on 8/28/17.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
