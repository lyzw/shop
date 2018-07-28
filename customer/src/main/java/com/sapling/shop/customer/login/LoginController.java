package com.sapling.shop.customer.login;

import com.sapling.common.exception.SaplingException;
import com.sapling.shop.biz.common.constants.ReturnCode;
import com.sapling.shop.biz.common.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("login")
    public BaseResponse login(@Valid @RequestBody LoginRequest loginRequest) throws SaplingException {
        if (loginService.userCheck(loginRequest.getData().getUserName(), loginRequest.getData().getPassword())) {
            String token = UUID.randomUUID().toString().replace("-", "");
            return BaseResponse.success(token);
        } else {
            return BaseResponse.fail(ReturnCode.RECORD_NOT_EXISTS, "用户名或密码错误");
        }
    }

//    @PostMapping("logout")
//    public BaseResponse logout(@)
}
