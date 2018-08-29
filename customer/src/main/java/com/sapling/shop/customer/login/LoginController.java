package com.sapling.shop.customer.login;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.annotation.MethodMeasureAnnotation;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.shop.biz.common.mybatis.model.Customer;
import com.sapling.shop.biz.common.web.BaseResponse;
import com.sapling.shop.biz.common.web.CustLogedInBaseController;
import com.sapling.shop.biz.common.web.service.CustomerAuthorTokenSerivce;
import com.sapling.shop.customer.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/13
 * @since v1.0
 */
@RestController
public class LoginController extends CustLogedInBaseController {

    @Autowired
    CustomerService customerService;

    @Autowired
    LoginService loginService;

    @Autowired
    CustomerAuthorTokenSerivce customerAuthorTokenSerivce;


    @MethodMeasureAnnotation
    @PostMapping("login")
    public BaseResponse login(@Valid @RequestBody LoginRequest loginRequest) throws SaplingException {
        Customer customer = customerService.detail(loginRequest.getData().getUserName());
        if (loginService.userCheck(customer, loginRequest.getData().getUserName(), loginRequest.getData().getPassword())) {
            String token = UUID.randomUUID().toString().replace("-", "");
            customerAuthorTokenSerivce.setToken(token, customer);
            return BaseResponse.success(token);
        } else {
            return BaseResponse.fail(ReturnCode.RECORD_NOT_EXISTS, "用户名或密码错误");
        }
    }

    @RequestMapping("logout")
    public BaseResponse logout() {
        customerAuthorTokenSerivce.logoutToken(token());
        return BaseResponse.success(null);
    }
}
