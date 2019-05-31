package top.yyf256.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class ConsumeLog implements Serializable {
    private String timeId;

    private Float consume1;

    private Float consume2;

    private Float consume3;

    private Float consume4;

    private Float consume5;

    private Float consume6;

    private String monthId;

    private Date time;

    private static final long serialVersionUID = 1L;

    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId == null ? null : timeId.trim();
    }

    public Float getConsume1() {
        return consume1;
    }

    public void setConsume1(Float consume1) {
        this.consume1 = consume1;
    }

    public Float getConsume2() {
        return consume2;
    }

    public void setConsume2(Float consume2) {
        this.consume2 = consume2;
    }

    public Float getConsume3() {
        return consume3;
    }

    public void setConsume3(Float consume3) {
        this.consume3 = consume3;
    }

    public Float getConsume4() {
        return consume4;
    }

    public void setConsume4(Float consume4) {
        this.consume4 = consume4;
    }

    public Float getConsume5() {
        return consume5;
    }

    public void setConsume5(Float consume5) {
        this.consume5 = consume5;
    }

    public Float getConsume6() {
        return consume6;
    }

    public void setConsume6(Float consume6) {
        this.consume6 = consume6;
    }

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId == null ? null : monthId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        ConsumeLog other = (ConsumeLog) that;
        return (this.getTimeId() == null ? other.getTimeId() == null : this.getTimeId().equals(other.getTimeId()))
            && (this.getConsume1() == null ? other.getConsume1() == null : this.getConsume1().equals(other.getConsume1()))
            && (this.getConsume2() == null ? other.getConsume2() == null : this.getConsume2().equals(other.getConsume2()))
            && (this.getConsume3() == null ? other.getConsume3() == null : this.getConsume3().equals(other.getConsume3()))
            && (this.getConsume4() == null ? other.getConsume4() == null : this.getConsume4().equals(other.getConsume4()))
            && (this.getConsume5() == null ? other.getConsume5() == null : this.getConsume5().equals(other.getConsume5()))
            && (this.getConsume6() == null ? other.getConsume6() == null : this.getConsume6().equals(other.getConsume6()))
            && (this.getMonthId() == null ? other.getMonthId() == null : this.getMonthId().equals(other.getMonthId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTimeId() == null) ? 0 : getTimeId().hashCode());
        result = prime * result + ((getConsume1() == null) ? 0 : getConsume1().hashCode());
        result = prime * result + ((getConsume2() == null) ? 0 : getConsume2().hashCode());
        result = prime * result + ((getConsume3() == null) ? 0 : getConsume3().hashCode());
        result = prime * result + ((getConsume4() == null) ? 0 : getConsume4().hashCode());
        result = prime * result + ((getConsume5() == null) ? 0 : getConsume5().hashCode());
        result = prime * result + ((getConsume6() == null) ? 0 : getConsume6().hashCode());
        result = prime * result + ((getMonthId() == null) ? 0 : getMonthId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", timeId=").append(timeId);
        sb.append(", consume1=").append(consume1);
        sb.append(", consume2=").append(consume2);
        sb.append(", consume3=").append(consume3);
        sb.append(", consume4=").append(consume4);
        sb.append(", consume5=").append(consume5);
        sb.append(", consume6=").append(consume6);
        sb.append(", monthId=").append(monthId);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}