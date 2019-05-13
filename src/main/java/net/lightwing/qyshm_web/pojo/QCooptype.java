package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_cooptype
 * @author 
 */
public class QCooptype implements Serializable {
    private Integer ctypeid;

    private String ctypename;

    /**
     * 0为展示详情
1为不展示详情
     */
    private Integer showdetail;

    private static final long serialVersionUID = 1L;

    public Integer getCtypeid() {
        return ctypeid;
    }

    public void setCtypeid(Integer ctypeid) {
        this.ctypeid = ctypeid;
    }

    public String getCtypename() {
        return ctypename;
    }

    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }

    public Integer getShowdetail() {
        return showdetail;
    }

    public void setShowdetail(Integer showdetail) {
        this.showdetail = showdetail;
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
        QCooptype other = (QCooptype) that;
        return (this.getCtypeid() == null ? other.getCtypeid() == null : this.getCtypeid().equals(other.getCtypeid()))
            && (this.getCtypename() == null ? other.getCtypename() == null : this.getCtypename().equals(other.getCtypename()))
            && (this.getShowdetail() == null ? other.getShowdetail() == null : this.getShowdetail().equals(other.getShowdetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCtypeid() == null) ? 0 : getCtypeid().hashCode());
        result = prime * result + ((getCtypename() == null) ? 0 : getCtypename().hashCode());
        result = prime * result + ((getShowdetail() == null) ? 0 : getShowdetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ctypeid=").append(ctypeid);
        sb.append(", ctypename=").append(ctypename);
        sb.append(", showdetail=").append(showdetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}