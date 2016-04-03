package d.money.pojo;

import java.io.Serializable;

import d.money.pojo.base.User;

public class UserProxyInfoView extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String applyProxyFlag;

    private Integer userClientCount;
    private Integer userShengProxyCount;
    private Integer userShiProxyCount;
    private Integer userXianProxyCount;

    public String getApplyProxyFlag() {
        return applyProxyFlag;
    }

    public void setApplyProxyFlag(String applyProxyFlag) {
        this.applyProxyFlag = applyProxyFlag;
    }

    public Integer getUserClientCount() {
        return userClientCount;
    }

    public void setUserClientCount(Integer userClientCount) {
        this.userClientCount = userClientCount;
    }

    public Integer getUserShengProxyCount() {
        return userShengProxyCount;
    }

    public void setUserShengProxyCount(Integer userShengProxyCount) {
        this.userShengProxyCount = userShengProxyCount;
    }

    public Integer getUserShiProxyCount() {
        return userShiProxyCount;
    }

    public void setUserShiProxyCount(Integer userShiProxyCount) {
        this.userShiProxyCount = userShiProxyCount;
    }

    public Integer getUserXianProxyCount() {
        return userXianProxyCount;
    }

    public void setUserXianProxyCount(Integer userXianProxyCount) {
        this.userXianProxyCount = userXianProxyCount;
    }

}