package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_bottommenu
 * @author 
 */
public class QBottommenu implements Serializable {
    /**
     * 底部链接编号
     */
    private Integer bmid;

    /**
     * 底部链接标题
     */
    private String bmtitle;

    /**
     * 底部链接地址
     */
    private String bmhref;

    private static final long serialVersionUID = 1L;

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    public String getBmtitle() {
        return bmtitle;
    }

    public void setBmtitle(String bmtitle) {
        this.bmtitle = bmtitle;
    }

    public String getBmhref() {
        return bmhref;
    }

    public void setBmhref(String bmhref) {
        this.bmhref = bmhref;
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
        QBottommenu other = (QBottommenu) that;
        return (this.getBmid() == null ? other.getBmid() == null : this.getBmid().equals(other.getBmid()))
            && (this.getBmtitle() == null ? other.getBmtitle() == null : this.getBmtitle().equals(other.getBmtitle()))
            && (this.getBmhref() == null ? other.getBmhref() == null : this.getBmhref().equals(other.getBmhref()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBmid() == null) ? 0 : getBmid().hashCode());
        result = prime * result + ((getBmtitle() == null) ? 0 : getBmtitle().hashCode());
        result = prime * result + ((getBmhref() == null) ? 0 : getBmhref().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bmid=").append(bmid);
        sb.append(", bmtitle=").append(bmtitle);
        sb.append(", bmhref=").append(bmhref);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}