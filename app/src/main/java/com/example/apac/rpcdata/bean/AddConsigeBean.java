package com.example.apac.rpcdata.bean;

/**
 * Created by lchtime4 on 2018/6/27.
 */

public class AddConsigeBean {

    /**
     * result : {"sid":"1823854d9fca60b4bd07f9bb92185d459ef5561","index":"","code":"10","info":"添加收货地址成功"}
     * address : {"ua_id":"1","ua_ub_id":"489","ua_sf":"北京","ua_cs":"朝阳区","ua_qx":"三里屯","ua_address":"SOHO嘉盛中心","ua_sjr":"lily","ua_phone":"12312312312","ua_zip":"100001","ua_status":"0","ud_nickname":"成斌！"}
     */

    private ResultBean result;
    private AddressBean address;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public static class ResultBean {
        /**
         * sid : 1823854d9fca60b4bd07f9bb92185d459ef5561
         * index :
         * code : 10
         * info : 添加收货地址成功
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

    public static class AddressBean {
        /**
         * ua_id : 1
         * ua_ub_id : 489
         * ua_sf : 北京
         * ua_cs : 朝阳区
         * ua_qx : 三里屯
         * ua_address : SOHO嘉盛中心
         * ua_sjr : lily
         * ua_phone : 12312312312
         * ua_zip : 100001
         * ua_status : 0
         * ud_nickname : 成斌！
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
