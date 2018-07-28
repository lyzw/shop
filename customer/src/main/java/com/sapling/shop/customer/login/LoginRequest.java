package com.sapling.shop.customer.login;

import com.sapling.common.api.base.BaseRequest;
import com.sapling.common.tools.bean.BeanUtil;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/15
 * @since v1.0
 */
public class LoginRequest extends BaseRequest<LoginRequest.LoginRequstEntity> {



    public class LoginRequstEntity {

        @NotEmpty(message = "用户名不能为空")
        @NotBlank(message = "用户名不能为空")
        private String userName;

        @NotEmpty(message = "密码不能为空")
        @NotBlank(message = "密码不能为空")
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}

