package com.example.coolrabbit.controller;

import com.example.coolrabbit.response.ResultBody;
import com.example.coolrabbit.response.ResultUtil;
import com.example.coolrabbit.service.UserService;
import com.example.coolrabbit.vo.LoginVo;
import com.example.coolrabbit.vo.RegisterVo;
import com.example.coolrabbit.vo.UserVo;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public ResultBody login(@RequestBody LoginVo loginVo) {
        UserVo userVo=userService.login(loginVo);
        return ResultUtil.success(userVo);
    }

    @PostMapping(path = "/register")
    public ResultBody register(@RequestBody RegisterVo registerVo) {
        userService.register(registerVo);
        return ResultUtil.success(null);
    }
}
