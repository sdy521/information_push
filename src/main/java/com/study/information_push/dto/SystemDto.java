package com.study.information_push.dto;

/**
 * 系统参数实体类
 * @author sdy
 * @date 2019/5/10 14:44
 */
public class SystemDto {
    /***
     * 总磁盘控件
     */
    private String total;
    /***
     * 已使用空间
     */
    private String used;
    /***
     * 使用率达
     */
    private String use_rate;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUse_rate() {
        return use_rate;
    }

    public void setUse_rate(String use_rate) {
        this.use_rate = use_rate;
    }
}
