package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_product
 * @author 
 */
public class QProduct implements Serializable {
    /**
     * 产品编号
     */
    private Integer pid;

    /**
     * 产品封面图路径
     */
    private String qcoverimg;

    /**
     * 产品详情
     */
    private String qdetail;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getQcoverimg() {
        return qcoverimg;
    }

    public void setQcoverimg(String qcoverimg) {
        this.qcoverimg = qcoverimg;
    }

    public String getQdetail() {
        return qdetail;
    }

    public void setQdetail(String qdetail) {
        this.qdetail = qdetail;
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
        QProduct other = (QProduct) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getQcoverimg() == null ? other.getQcoverimg() == null : this.getQcoverimg().equals(other.getQcoverimg()))
            && (this.getQdetail() == null ? other.getQdetail() == null : this.getQdetail().equals(other.getQdetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getQcoverimg() == null) ? 0 : getQcoverimg().hashCode());
        result = prime * result + ((getQdetail() == null) ? 0 : getQdetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", qcoverimg=").append(qcoverimg);
        sb.append(", qdetail=").append(qdetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}