package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * q_techdev
 * @author 
 */
public class QTechdev implements Serializable {
    /**
     * 技术研发编号
     */
    private Integer tid;

    /**
     * 技术研发标题
     */
    private String ttitle;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 技术研发详情
     */
    private String tdetail;

    private static final long serialVersionUID = 1L;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        QTechdev other = (QTechdev) that;
        return (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getTtitle() == null ? other.getTtitle() == null : this.getTtitle().equals(other.getTtitle()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getTdetail() == null ? other.getTdetail() == null : this.getTdetail().equals(other.getTdetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getTtitle() == null) ? 0 : getTtitle().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
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
        sb.append(", ttitle=").append(ttitle);
        sb.append(", createtime=").append(createtime);
        sb.append(", tdetail=").append(tdetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}