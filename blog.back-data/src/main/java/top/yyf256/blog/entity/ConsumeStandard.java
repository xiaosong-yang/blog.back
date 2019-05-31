package top.yyf256.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class ConsumeStandard implements Serializable {
    private String timeId;

    private Float comsume1;

    private Float comsume2;

    private Float comsume3;

    private Float comsume4;

    private Float comsume5;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId == null ? null : timeId.trim();
    }

    public Float getComsume1() {
        return comsume1;
    }

    public void setComsume1(Float comsume1) {
        this.comsume1 = comsume1;
    }

    public Float getComsume2() {
        return comsume2;
    }

    public void setComsume2(Float comsume2) {
        this.comsume2 = comsume2;
    }

    public Float getComsume3() {
        return comsume3;
    }

    public void setComsume3(Float comsume3) {
        this.comsume3 = comsume3;
    }

    public Float getComsume4() {
        return comsume4;
    }

    public void setComsume4(Float comsume4) {
        this.comsume4 = comsume4;
    }

    public Float getComsume5() {
        return comsume5;
    }

    public void setComsume5(Float comsume5) {
        this.comsume5 = comsume5;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        ConsumeStandard other = (ConsumeStandard) that;
        return (this.getTimeId() == null ? other.getTimeId() == null : this.getTimeId().equals(other.getTimeId()))
            && (this.getComsume1() == null ? other.getComsume1() == null : this.getComsume1().equals(other.getComsume1()))
            && (this.getComsume2() == null ? other.getComsume2() == null : this.getComsume2().equals(other.getComsume2()))
            && (this.getComsume3() == null ? other.getComsume3() == null : this.getComsume3().equals(other.getComsume3()))
            && (this.getComsume4() == null ? other.getComsume4() == null : this.getComsume4().equals(other.getComsume4()))
            && (this.getComsume5() == null ? other.getComsume5() == null : this.getComsume5().equals(other.getComsume5()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTimeId() == null) ? 0 : getTimeId().hashCode());
        result = prime * result + ((getComsume1() == null) ? 0 : getComsume1().hashCode());
        result = prime * result + ((getComsume2() == null) ? 0 : getComsume2().hashCode());
        result = prime * result + ((getComsume3() == null) ? 0 : getComsume3().hashCode());
        result = prime * result + ((getComsume4() == null) ? 0 : getComsume4().hashCode());
        result = prime * result + ((getComsume5() == null) ? 0 : getComsume5().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timeId=").append(timeId);
        sb.append(", comsume1=").append(comsume1);
        sb.append(", comsume2=").append(comsume2);
        sb.append(", comsume3=").append(comsume3);
        sb.append(", comsume4=").append(comsume4);
        sb.append(", comsume5=").append(comsume5);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}