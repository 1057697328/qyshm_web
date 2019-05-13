package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_team
 * @author 
 */
public class QTeam implements Serializable {
    /**
     * 团队人员ID
     */
    private Integer tid;

    /**
     * 团队类型ID
     */
    private Integer ttypeid;

    /**
     * 人员头像路径
     */
    private String theadimg;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 0:循环为团队技术人员
1:只在前台展示tdetail
     */
    private Integer status;

    /**
     * 人员介绍详情
     */
    private String tdetail;

    private static final long serialVersionUID = 1L;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTtypeid() {
        return ttypeid;
    }

    public void setTtypeid(Integer ttypeid) {
        this.ttypeid = ttypeid;
    }

    public String getTheadimg() {
        return theadimg;
    }

    public void setTheadimg(String theadimg) {
        this.theadimg = theadimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTdetail() {
        return tdetail;
    }

    public void setTdetail(String tdetail) {
        this.tdetail = tdetail;
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
        QTeam other = (QTeam) that;
        return (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getTtypeid() == null ? other.getTtypeid() == null : this.getTtypeid().equals(other.getTtypeid()))
            && (this.getTheadimg() == null ? other.getTheadimg() == null : this.getTheadimg().equals(other.getTheadimg()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTdetail() == null ? other.getTdetail() == null : this.getTdetail().equals(other.getTdetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getTtypeid() == null) ? 0 : getTtypeid().hashCode());
        result = prime * result + ((getTheadimg() == null) ? 0 : getTheadimg().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTdetail() == null) ? 0 : getTdetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", ttypeid=").append(ttypeid);
        sb.append(", theadimg=").append(theadimg);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", tdetail=").append(tdetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}