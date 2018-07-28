package com.sapling.shop.customer.login;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.common.tools.security.MD5Util;
import com.sapling.shop.biz.common.mybatis.mapper.SysUserMapper;
import com.sapling.shop.biz.common.mybatis.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/13
 * @since v1.0
 */
@Service
public class LoginService {

    @Autowired
    SysUserMapper sysUserMapper;

    public boolean userCheck(String userName, String password) throws SaplingException {
        SysUser user = sysUserMapper.selectByUserName(userName);
        if (user == null) {
            SaplingException e = new SaplingException(ReturnCode.RECORD_NOT_EXISTS, "用户不存在或密码错误");
            throw e;
        }
        if (user.getPassword().equals(MD5Util.md5(password))) {
            return true;
        }
        return false;
    }
}
