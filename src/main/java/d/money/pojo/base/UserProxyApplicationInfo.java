package d.money.pojo.base;

import java.util.Date;

public class UserProxyApplicationInfo {
    private Integer id;

    private Integer userId;

    private String upProxyFlag;

    private Date createDate;

    private String approveFlag;

    private Date approveDate;

    private Integer userMoney;

    private Integer userClientCount;

    private Integer userShengProxyCount;

    private Integer userShiProxyCount;

    private Integer userXianProxyCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUpProxyFlag() {
        return upProxyFlag;
    }

    public void setUpProxyFlag(String upProxyFlag) {
        this.upProxyFlag = upProxyFlag == null ? null : upProxyFlag.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(String approveFlag) {
        this.approveFlag = approveFlag == null ? null : approveFlag.trim();
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserProxyApplicationInfo other = (UserProxyApplicationInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUpProxyFlag() == null ? other.getUpProxyFlag() == null : this.getUpProxyFlag().equals(other.getUpProxyFlag()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getApproveFlag() == null ? other.getApproveFlag() == null : this.getApproveFlag().equals(other.getApproveFlag()))
            && (this.getApproveDate() == null ? other.getApproveDate() == null : this.getApproveDate().equals(other.getApproveDate()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getUserClientCount() == null ? other.getUserClientCount() == null : this.getUserClientCount().equals(other.getUserClientCount()))
            && (this.getUserShengProxyCount() == null ? other.getUserShengProxyCount() == null : this.getUserShengProxyCount().equals(other.getUserShengProxyCount()))
            && (this.getUserShiProxyCount() == null ? other.getUserShiProxyCount() == null : this.getUserShiProxyCount().equals(other.getUserShiProxyCount()))
            && (this.getUserXianProxyCount() == null ? other.getUserXianProxyCount() == null : this.getUserXianProxyCount().equals(other.getUserXianProxyCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUpProxyFlag() == null) ? 0 : getUpProxyFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getApproveFlag() == null) ? 0 : getApproveFlag().hashCode());
        result = prime * result + ((getApproveDate() == null) ? 0 : getApproveDate().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getUserClientCount() == null) ? 0 : getUserClientCount().hashCode());
        result = prime * result + ((getUserShengProxyCount() == null) ? 0 : getUserShengProxyCount().hashCode());
        result = prime * result + ((getUserShiProxyCount() == null) ? 0 : getUserShiProxyCount().hashCode());
        result = prime * result + ((getUserXianProxyCount() == null) ? 0 : getUserXianProxyCount().hashCode());
        return result;
    }
}