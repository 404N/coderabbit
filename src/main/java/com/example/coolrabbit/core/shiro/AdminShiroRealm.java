package com.example.coolrabbit.core.shiro;

import com.example.coolrabbit.core.redis.RedisSessionDAO;
import com.example.coolrabbit.entity.Admin;
import com.example.coolrabbit.entity.Label;
import com.example.coolrabbit.service.AdminService;
import com.example.coolrabbit.service.LabelService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.*;

/**
 * 后台身份校验核心类
 *
 * @author geekcattle
 */
public class AdminShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Lazy
    private AdminService adminService;

    @Autowired
    @Lazy
    private LabelService labelService;

    @Autowired
    @Lazy
    private RedisSessionDAO redisSessionDAO;


    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (logger.isDebugEnabled()) {
            logger.info("后台登录：AdminShiroRealm.doGetAuthenticationInfo()");
        }
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        Admin userInfo = adminService.findByUserName(username);
        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        String lock = "0";

        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                userInfo,
                //密码
                userInfo.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                userInfo.getUserName()
        );

        return authenticationInfo;
    }


    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 踢出用户
     *
     * @param userId        用户id
     * @param isRemoveSession 是否移除session态，移除会强制该用户重新登录
     */
    public void kickOutUser(String userId, boolean isRemoveSession) {
        Set<Session> sessionSet = getSessionByUserId(userId);
        if (CollectionUtils.isEmpty(sessionSet)) {
            return;
        }
        kickOutUser(sessionSet,isRemoveSession);
    }

    /**
     * 踢出所有用户
     *
     * @param isRemoveSession 是否移除session态，移除会强制该用户重新登录
     */
    public void kickOutAllUser(boolean isRemoveSession) {
        Collection<Session> sessionSet = redisSessionDAO.getActiveSessions();
        kickOutUser((Set<Session>) sessionSet,isRemoveSession);
    }

    /**
     * 踢出用户
     *
     * @param sessionSet session合集
     * @param isRemoveSession 是否移除session态，移除会强制该用户重新登录
     */
    public void kickOutUser(Set<Session> sessionSet, boolean isRemoveSession) {
        sessionSet.stream().forEach(session -> {
            Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                return;
            }

            //删除session
            if (isRemoveSession) {
                redisSessionDAO.delete(session);
            }
            //删除cache，在访问受限接口时会重新授权
            clearCachedAuthorizationInfo((SimplePrincipalCollection) attribute);
        });

    }

    /**
     * 获取用户对应的所有登录态
     *
     * @param userId 帐号
     * @return
     */
    private Set<Session> getSessionByUserId(String userId) {
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        Admin user;
        Object attribute;
        Set<Session> sessionSet = new HashSet<>();
        for (Session session : sessions) {
            attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            user = (Admin) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (user == null) {
                continue;
            }
            if (Objects.equals(user.getAdminId(), userId)) {
                sessionSet.add(session);
            }
        }
        return sessionSet;
    }
}
