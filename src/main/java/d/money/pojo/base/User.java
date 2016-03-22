package d.money.pojo.base;

import java.util.Date;

public class User {
    private Integer id;

    private String password;

    private String name;

    private String identityCard;

    private String jsrId;

    private String jdrId;

    private String nhCard;

    private String tel;

    private String address;

    private String code;

    private String sex;

    private Date hkTime;

    private String adminCode;

    private String comment;

    private Date zcTime;

    private String approveFlag;

    private Date approveDate;

    private Integer userMoney;

    private String proxyFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getJsrId() {
        return jsrId;
    }

    public void setJsrId(String jsrId) {
        this.jsrId = jsrId == null ? null : jsrId.trim();
    }

    public String getJdrId() {
        return jdrId;
    }

    public void setJdrId(String jdrId) {
        this.jdrId = jdrId == null ? null : jdrId.trim();
    }

    public String getNhCard() {
        return nhCard;
    }

    public void setNhCard(String nhCard) {
        this.nhCard = nhCard == null ? null : nhCard.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getHkTime() {
        return hkTime;
    }

    public void setHkTime(Date hkTime) {
        this.hkTime = hkTime;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getZcTime() {
        return zcTime;
    }

    public void setZcTime(Date zcTime) {
        this.zcTime = zcTime;
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

    public String getProxyFlag() {
        return proxyFlag;
    }

    public void setProxyFlag(String proxyFlag) {
        this.proxyFlag = proxyFlag == null ? null : proxyFlag.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIdentityCard() == null ? other.getIdentityCard() == null : this.getIdentityCard().equals(other.getIdentityCard()))
            && (this.getJsrId() == null ? other.getJsrId() == null : this.getJsrId().equals(other.getJsrId()))
            && (this.getJdrId() == null ? other.getJdrId() == null : this.getJdrId().equals(other.getJdrId()))
            && (this.getNhCard() == null ? other.getNhCard() == null : this.getNhCard().equals(other.getNhCard()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getHkTime() == null ? other.getHkTime() == null : this.getHkTime().equals(other.getHkTime()))
            && (this.getAdminCode() == null ? other.getAdminCode() == null : this.getAdminCode().equals(other.getAdminCode()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getZcTime() == null ? other.getZcTime() == null : this.getZcTime().equals(other.getZcTime()))
            && (this.getApproveFlag() == null ? other.getApproveFlag() == null : this.getApproveFlag().equals(other.getApproveFlag()))
            && (this.getApproveDate() == null ? other.getApproveDate() == null : this.getApproveDate().equals(other.getApproveDate()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getProxyFlag() == null ? other.getProxyFlag() == null : this.getProxyFlag().equals(other.getProxyFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIdentityCard() == null) ? 0 : getIdentityCard().hashCode());
        result = prime * result + ((getJsrId() == null) ? 0 : getJsrId().hashCode());
        result = prime * result + ((getJdrId() == null) ? 0 : getJdrId().hashCode());
        result = prime * result + ((getNhCard() == null) ? 0 : getNhCard().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getHkTime() == null) ? 0 : getHkTime().hashCode());
        result = prime * result + ((getAdminCode() == null) ? 0 : getAdminCode().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getZcTime() == null) ? 0 : getZcTime().hashCode());
        result = prime * result + ((getApproveFlag() == null) ? 0 : getApproveFlag().hashCode());
        result = prime * result + ((getApproveDate() == null) ? 0 : getApproveDate().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getProxyFlag() == null) ? 0 : getProxyFlag().hashCode());
        return result;
    }
}