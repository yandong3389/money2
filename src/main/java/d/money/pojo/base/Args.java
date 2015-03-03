package d.money.pojo.base;

public class Args {
    private Integer id;

    private Integer bonus;

    private Float tjBonusPercent;

    private Float pxBonusPercent;

    private Float zxBonusPercent;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Float getTjBonusPercent() {
        return tjBonusPercent;
    }

    public void setTjBonusPercent(Float tjBonusPercent) {
        this.tjBonusPercent = tjBonusPercent;
    }

    public Float getPxBonusPercent() {
        return pxBonusPercent;
    }

    public void setPxBonusPercent(Float pxBonusPercent) {
        this.pxBonusPercent = pxBonusPercent;
    }

    public Float getZxBonusPercent() {
        return zxBonusPercent;
    }

    public void setZxBonusPercent(Float zxBonusPercent) {
        this.zxBonusPercent = zxBonusPercent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
        Args other = (Args) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()))
            && (this.getTjBonusPercent() == null ? other.getTjBonusPercent() == null : this.getTjBonusPercent().equals(other.getTjBonusPercent()))
            && (this.getPxBonusPercent() == null ? other.getPxBonusPercent() == null : this.getPxBonusPercent().equals(other.getPxBonusPercent()))
            && (this.getZxBonusPercent() == null ? other.getZxBonusPercent() == null : this.getZxBonusPercent().equals(other.getZxBonusPercent()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        result = prime * result + ((getTjBonusPercent() == null) ? 0 : getTjBonusPercent().hashCode());
        result = prime * result + ((getPxBonusPercent() == null) ? 0 : getPxBonusPercent().hashCode());
        result = prime * result + ((getZxBonusPercent() == null) ? 0 : getZxBonusPercent().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }
}