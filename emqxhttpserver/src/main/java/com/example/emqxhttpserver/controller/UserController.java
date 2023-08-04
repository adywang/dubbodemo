package com.example.emqxhttpserver.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

@RestController
public class UserController {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserInfo {
        private String userName;
        private String password;
        private String id;

    }

    @PostMapping("/user/info")
    public UserInfo userInfo(HttpServletRequest request,@RequestBody UserInfo userInfo) throws IOException {

        return userInfo;
    }
}
