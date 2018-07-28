package com.sapling.shop.customer.customer;

import com.sapling.common.tools.common.StringUtil;
import com.sapling.common.tools.security.MD5Util;
import com.sapling.shop.biz.common.constants.Constants;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.shop.biz.common.exception.ShopBaseException;
import com.sapling.shop.biz.common.mybatis.mapper.CustomerMapper;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    /**
     * 查询数据库用户名是否已经存在
     *
     * @param userName
     * @return
     */
    public boolean ifUserNameExists(String userName) {
        if (StringUtil.isEmpty(userName, true)) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        return !(detail(userName) == null);
    }


    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    public Customer detail(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("用户id不能为空");
        }
        return customerMapper.selectByPrimaryKey(userId);
    }

    /**
     * 根据用户名查询用户详情
     *
     * @param userName
     * @return
     */
    public Customer detail(String userName) {
        if (StringUtil.isEmpty(userName, true)) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        return customerMapper.selectByUserName(userName);
    }

    public Customer addCustomer(String userName, String password) {
        //校验参数是否为空
        if (StringUtil.isEmpty(userName, true) ||
                StringUtil.isEmpty(password, true))
            throw new ShopBaseException(ReturnCode.ILLEGAL_ARGUMENT, "用户名或密码不能为空");
        //检验用户名是否被占用
        if (ifUserNameExists(userName))
            throw new ShopBaseException(ReturnCode.RECORD_ALREADY_EXISTS, "用户名已经被使用");
        String encodePassword = MD5Util.md5(userName + password);
        Customer customer = new Customer();
        customer.setName(userName);
        customer.setNickName(userName);
        customer.setPassword(password);
        customer.setStatus(Constants.CUSTOMER_STATUS_OK);
        customer.setGmtCreate(new Date());
        customer.setGmtModify(new Date());
        customerMapper.insert(customer);
        return customer;

    }
}
