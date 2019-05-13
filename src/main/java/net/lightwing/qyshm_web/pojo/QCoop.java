package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_coop
 * @author 
 */
public class QCoop implements Serializable {
    /**
     * 合作机构编号
     */
    private Integer cid;

    /**
     * 合作机构类型
     */
    private Integer ctypeid;

    /**
     * 合作机构名称
     */
    private String cname;

    /**
     * 合作机构英文名称
     */
    private String engname;

    /**
     * 封面图片路径
     */
    private String coverimg;

    /**
     * 点击后跳转链接
     */
    private String href;

    private static final long serialVersionUID = 1L;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCtypeid() {
        return ctypeid;
    }

    public void setCtypeid(Integer ctypeid) {
        this.ctypeid = ctypeid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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
        QCoop other = (QCoop) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getCtypeid() == null ? other.getCtypeid() == null : this.getCtypeid().equals(other.getCtypeid()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getEngname() == null ? other.getEngname() == null : this.getEngname().equals(other.getEngname()))
            && (this.getCoverimg() == null ? other.getCoverimg() == null : this.getCoverimg().equals(other.getCoverimg()))
            && (this.getHref() == null ? other.getHref() == null : this.getHref().equals(other.getHref()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getCtypeid() == null) ? 0 : getCtypeid().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getEngname() == null) ? 0 : getEngname().hashCode());
        result = prime * result + ((getCoverimg() == null) ? 0 : getCoverimg().hashCode());
        result = prime * result + ((getHref() == null) ? 0 : getHref().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", ctypeid=").append(ctypeid);
        sb.append(", cname=").append(cname);
        sb.append(", engname=").append(engname);
        sb.append(", coverimg=").append(coverimg);
        sb.append(", href=").append(href);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}