package com.zhoujixing.shiro;

import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        SysUserEntity user = sysUserService.findByUserName(username);
        List<SysMenuEntity> menuEntities = sysUserService.findMenuByUserName(username);
        menuEntities.parallelStream().forEach(SysMenuEntity->{
            simpleAuthorizationInfo.addStringPermission(SysMenuEntity.getActions());
        });
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        if (username == null){
            throw new AuthenticationException("token无效");
        }
        SysUserEntity userEntity = sysUserService.findByUserName(username);
        if (userEntity == null){
            throw new  AuthenticationException("用户不存在！");
        }
        if (!JWTUtil.verify(token,username,userEntity.getLoginpass())){
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(token,token,"my_realm");
    }
}
