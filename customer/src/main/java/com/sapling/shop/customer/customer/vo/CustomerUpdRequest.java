package com.sapling.shop.customer.customer.vo;

import com.sapling.common.api.base.BaseRequest;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/7/17
 * @since v1.0
 */
public class CustomerUpdRequest extends BaseRequest<CustomerUpdRequest.CustomerUpdEntity> {

    public class CustomerUpdEntity{
        //用户id
        private Long userId;
        //用户名
        private String userName;
        //密码
        private String password;
        //昵称
        private String nickName;
        //电话
        private String phone;
        //电子邮箱
        private String email;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

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

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

}
