package com.gofdemo.adapterpattern_object;

public class UserServiceAdapter implements TargetUserService {
    public UserServiceAdapter(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Override
    public String findById() {
        return userService.findById().toString();
    }

    @Override
    public String findList() {
        return userService.findList().toString();
    }
}
