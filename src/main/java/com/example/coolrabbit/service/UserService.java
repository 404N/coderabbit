package com.example.coolrabbit.service;

import com.example.coolrabbit.entity.User;
import com.example.coolrabbit.vo.LoginVo;
import com.example.coolrabbit.vo.RegisterVo;
import com.example.coolrabbit.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 注册接口
     * @param registerVo
     */
    void register(RegisterVo registerVo);

    /**
     * 登录接口
     * @param loginVo
     */
    UserVo login(LoginVo loginVo);


    /**
     * 设置昵称
     * @param name
     */
    void setNickName(String name);


    /**
     *
     * @param username
     * @return
     */
    User findByUserName(String username);
}
