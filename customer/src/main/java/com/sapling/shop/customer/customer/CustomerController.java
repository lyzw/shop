package com.sapling.shop.customer.customer;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import com.sapling.shop.biz.common.web.BaseResponse;
import com.sapling.shop.biz.common.web.CustLogedInBaseController;
import com.sapling.shop.customer.customer.vo.CustomerRegisterRequest;
import com.sapling.shop.customer.customer.vo.CustomerUpdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息控制器
 *
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
@RestController
@RequestMapping("customer")
public class CustomerController extends CustLogedInBaseController {

    @Autowired
    CustomerService customerService;

    @PutMapping
    public BaseResponse update(@RequestBody CustomerUpdRequest request) {
        return null;
    }

    /**
     * 用户注册
     *
     * @param registerRequest 注册信息
     * @return 注册后的信息
     * @throws SaplingException 异常信息
     */
    @PostMapping("register")
    public BaseResponse register(@RequestBody CustomerRegisterRequest registerRequest) throws SaplingException {
        String userName = registerRequest.getData().getUserName();
        if (customerService.ifUserNameExists(userName)) {
            throw new SaplingException(ReturnCode.RECORD_ALREADY_EXISTS, "用户名已经存在");
        }
        Customer customer = customerService.addCustomer(registerRequest.getData().getUserName(),registerRequest.getData().getPassword());
        return BaseResponse.success(customer);
    }


    /**
     * 根据用户id查询用户信息
     *
     * @param userId 用户id
     * @return 用户详情
     */
    @GetMapping(value = "{userId}")
    public BaseResponse detail(@PathVariable(name = "userId") Long userId) {
        return BaseResponse.success(customerService.detail(userId));
    }


    @GetMapping(value = "self")
    public BaseResponse getCustByToken(){
        return BaseResponse.success(getCustomer());
    }


    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return 用户详情
     */
    @GetMapping(value = "detail")
    public BaseResponse detailByUserName(String userName) {
        return BaseResponse.success(customerService.detail(userName));
    }


}
