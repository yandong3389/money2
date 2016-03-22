package d.money.pojo.base;

import java.util.Date;

public class MoneyHistory {
    private Integer pkid;

    private Integer id;

    private Integer awardMoney;

    private Integer linkUserId;

    private Integer type;

    private Date createDate;

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAwardMoney() {
        return awardMoney;
    }

    public void setAwardMoney(Integer awardMoney) {
        this.awardMoney = awardMoney;
    }

    public Integer getLinkUserId() {
        return linkUserId;
    }

    public void setLinkUserId(Integer linkUserId) {
        this.linkUserId = linkUserId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        MoneyHistory other = (MoneyHistory) that;
        return (this.getPkid() == null ? other.getPkid() == null : this.getPkid().equals(other.getPkid()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAwardMoney() == null ? other.getAwardMoney() == null : this.getAwardMoney().equals(other.getAwardMoney()))
            && (this.getLinkUserId() == null ? other.getLinkUserId() == null : this.getLinkUserId().equals(other.getLinkUserId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkid() == null) ? 0 : getPkid().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAwardMoney() == null) ? 0 : getAwardMoney().hashCode());
        result = prime * result + ((getLinkUserId() == null) ? 0 : getLinkUserId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }
}