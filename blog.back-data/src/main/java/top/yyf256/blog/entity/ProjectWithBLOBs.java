package top.yyf256.blog.entity;

import java.io.Serializable;

public class ProjectWithBLOBs extends Project implements Serializable {
    private String instruction;

    private String downloadUrl;

    private String faceUrl;

    private static final long serialVersionUID = 1L;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl == null ? null : faceUrl.trim();
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
        ProjectWithBLOBs other = (ProjectWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getBrowseCount() == null ? other.getBrowseCount() == null : this.getBrowseCount().equals(other.getBrowseCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getPraiseCount() == null ? other.getPraiseCount() == null : this.getPraiseCount().equals(other.getPraiseCount()))
            && (this.getInstruction() == null ? other.getInstruction() == null : this.getInstruction().equals(other.getInstruction()))
            && (this.getDownloadUrl() == null ? other.getDownloadUrl() == null : this.getDownloadUrl().equals(other.getDownloadUrl()))
            && (this.getFaceUrl() == null ? other.getFaceUrl() == null : this.getFaceUrl().equals(other.getFaceUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBrowseCount() == null) ? 0 : getBrowseCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getPraiseCount() == null) ? 0 : getPraiseCount().hashCode());
        result = prime * result + ((getInstruction() == null) ? 0 : getInstruction().hashCode());
        result = prime * result + ((getDownloadUrl() == null) ? 0 : getDownloadUrl().hashCode());
        result = prime * result + ((getFaceUrl() == null) ? 0 : getFaceUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", instruction=").append(instruction);
        sb.append(", downloadUrl=").append(downloadUrl);
        sb.append(", faceUrl=").append(faceUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}