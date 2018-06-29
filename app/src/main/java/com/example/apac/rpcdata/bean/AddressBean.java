package com.example.apac.rpcdata.bean;

/**
 * Created by lchtime4 on 2018/6/27.
 */

public class AddressBean {

    private String ua_sf;
    private String ua_cs;
    private String ua_qx;
    private String ua_address;
    private String ua_sjr;
    private String ua_phone;
    private String ua_zip;

    public AddressBean(String ua_sf, String ua_cs, String ua_qx, String ua_address, String ua_sjr, String ua_phone, String ua_zip) {
        this.ua_sf = ua_sf;
        this.ua_cs = ua_cs;
        this.ua_qx = ua_qx;
        this.ua_address = ua_address;
        this.ua_sjr = ua_sjr;
        this.ua_phone = ua_phone;
        this.ua_zip = ua_zip;
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

    @Override
    public String toString() {
        return "AddressBean{" +
                "ua_sf='" + ua_sf + '\'' +
                ", ua_cs='" + ua_cs + '\'' +
                ", ua_qx='" + ua_qx + '\'' +
                ", ua_address='" + ua_address + '\'' +
                ", ua_sjr='" + ua_sjr + '\'' +
                ", ua_phone='" + ua_phone + '\'' +
                ", ua_zip='" + ua_zip + '\'' +
                '}';
    }
}
