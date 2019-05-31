package top.yyf256.blog.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Integer versionId;

    private String tips;

    private String logoUrl;

    private String photoUrl;

    private String qqUrl;

    private String wechatUrl;

    private String email;

    private static final long serialVersionUID = 1L;

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getQqUrl() {
        return qqUrl;
    }

    public void setQqUrl(String qqUrl) {
        this.qqUrl = qqUrl == null ? null : qqUrl.trim();
    }

    public String getWechatUrl() {
        return wechatUrl;
    }

    public void setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl == null ? null : wechatUrl.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
        UserInfo other = (UserInfo) that;
        return (this.getVersionId() == null ? other.getVersionId() == null : this.getVersionId().equals(other.getVersionId()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()))
            && (this.getLogoUrl() == null ? other.getLogoUrl() == null : this.getLogoUrl().equals(other.getLogoUrl()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getQqUrl() == null ? other.getQqUrl() == null : this.getQqUrl().equals(other.getQqUrl()))
            && (this.getWechatUrl() == null ? other.getWechatUrl() == null : this.getWechatUrl().equals(other.getWechatUrl()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVersionId() == null) ? 0 : getVersionId().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        result = prime * result + ((getLogoUrl() == null) ? 0 : getLogoUrl().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getQqUrl() == null) ? 0 : getQqUrl().hashCode());
        result = prime * result + ((getWechatUrl() == null) ? 0 : getWechatUrl().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", versionId=").append(versionId);
        sb.append(", tips=").append(tips);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", qqUrl=").append(qqUrl);
        sb.append(", wechatUrl=").append(wechatUrl);
        sb.append(", email=").append(email);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}