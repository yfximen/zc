package com.example.apac.rpcdata.bean;

import java.util.List;

/**
 * Created by lchtime4 on 2018/6/28.
 */

public class GaddrBean {

    /**
     * result : {"sid":"1122a5771bce93e200c36f7cd9dfd0e5d8ea3a","index":"","code":"10","info":"显示用户的收件地址列表"}
     * user_address : [{"ua_id":"31","ua_ub_id":"38","ua_sf":"MSN无所谓","ua_cs":"中","ua_qx":"OP拿","ua_address":"你莫","ua_sjr":"名额","ua_phone":"3136464667","ua_zip":"","ua_status":"1","ud_nickname":"rpc_6456"},{"ua_id":"35","ua_ub_id":"38","ua_sf":"明星33","ua_cs":"大法师","ua_qx":"测密","ua_address":"add","ua_sjr":"陈翔","ua_phone":"65445665445","ua_zip":"","ua_status":"0","ud_nickname":"rpc_6456"}]
     */

    private ResultBean result;
    private List<UserAddressBean> user_address;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<UserAddressBean> getUser_address() {
        return user_address;
    }

    public void setUser_address(List<UserAddressBean> user_address) {
        this.user_address = user_address;
    }

    public static class ResultBean {
        /**
         * sid : 1122a5771bce93e200c36f7cd9dfd0e5d8ea3a
         * index :
         * code : 10
         * info : 显示用户的收件地址列表
         */

        private String sid;
        private String index;
        private String code;
        private String info;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public static class UserAddressBean {
        /**
         * ua_id : 31
         * ua_ub_id : 38
         * ua_sf : MSN无所谓
         * ua_cs : 中
         * ua_qx : OP拿
         * ua_address : 你莫
         * ua_sjr : 名额
         * ua_phone : 3136464667
         * ua_zip :
         * ua_status : 1
         * ud_nickname : rpc_6456
         */

        private String ua_id;
        private String ua_ub_id;
        private String ua_sf;
        private String ua_cs;
        private String ua_qx;
        private String ua_address;
        private String ua_sjr;
        private String ua_phone;
        private String ua_zip;
        private String ua_status;
        private String ud_nickname;

        public String getUa_id() {
            return ua_id;
        }

        public void setUa_id(String ua_id) {
            this.ua_id = ua_id;
        }

        public String getUa_ub_id() {
            return ua_ub_id;
        }

        public void setUa_ub_id(String ua_ub_id) {
            this.ua_ub_id = ua_ub_id;
        }

        public String getUa_sf() {
            return ua_sf;
        }

        public void setUa_sf(String ua_sf) {
            this.ua_sf = ua_sf;
        }

        public String getUa_cs() {
            return ua_cs;
        }

        public void setUa_cs(String ua_cs) {
            this.ua_cs = ua_cs;
        }

        public String getUa_qx() {
            return ua_qx;
        }

        public void setUa_qx(String ua_qx) {
            this.ua_qx = ua_qx;
        }

        public String getUa_address() {
            return ua_address;
        }

        public void setUa_address(String ua_address) {
            this.ua_address = ua_address;
        }

        public String getUa_sjr() {
            return ua_sjr;
        }

        public void setUa_sjr(String ua_sjr) {
            this.ua_sjr = ua_sjr;
        }

        public String getUa_phone() {
            return ua_phone;
        }

        public void setUa_phone(String ua_phone) {
            this.ua_phone = ua_phone;
        }

        public String getUa_zip() {
            return ua_zip;
        }

        public void setUa_zip(String ua_zip) {
            this.ua_zip = ua_zip;
        }

        public String getUa_status() {
            return ua_status;
        }

        public void setUa_status(String ua_status) {
            this.ua_status = ua_status;
        }

        public String getUd_nickname() {
            return ud_nickname;
        }

        public void setUd_nickname(String ud_nickname) {
            this.ud_nickname = ud_nickname;
        }
    }
}
