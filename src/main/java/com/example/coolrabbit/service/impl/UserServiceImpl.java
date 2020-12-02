package com.example.coolrabbit.service.impl;

import com.example.coolrabbit.dao.UserMapper;
import com.example.coolrabbit.entity.User;
import com.example.coolrabbit.exceptions.BaseException;
import com.example.coolrabbit.response.CommonEnum;
import com.example.coolrabbit.service.UserService;
import com.example.coolrabbit.utils.MD5Util;
import com.example.coolrabbit.vo.LoginVo;
import com.example.coolrabbit.vo.RegisterVo;
import com.example.coolrabbit.vo.UserVo;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterVo registerVo) {
        if(userMapper.selectByEmail(registerVo.getEmail())!=null){
            throw new BaseException(CommonEnum.ACCOUNT_EXIST);
        }
        User user=new User();
        user.setEmail(registerVo.getEmail());
        user.setName(registerVo.getName());
        user.setPassword(MD5Util.getMD5_32_lower(registerVo.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public UserVo login(LoginVo loginVo) {
        User user=userMapper.selectByEmailAndPassword(loginVo.getEmail(),MD5Util.getMD5_32_lower(loginVo.getPassword()));
        if(user==null){
            throw new BaseException(CommonEnum.ACCOUNT_WRONG);
        }
        UserVo userVo=new UserVo();
        userVo.setEmail(user.getEmail());
        userVo.setName(user.getName());
        return userVo;
    }
}
