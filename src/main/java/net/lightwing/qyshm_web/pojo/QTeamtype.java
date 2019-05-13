package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_teamtype
 * @author 
 */
public class QTeamtype implements Serializable {
    /**
     * 团队类型编号
     */
    private Integer ttypeid;

    /**
     * 团队类型名称
     */
    private String ttypename;

    private static final long serialVersionUID = 1L;

    public Integer getTtypeid() {
        return ttypeid;
    }

    public void setTtypeid(Integer ttypeid) {
        this.ttypeid = ttypeid;
    }

    public String getTtypename() {
        return ttypename;
    }

    public void setTtypename(String ttypename) {
        this.ttypename = ttypename;
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
        QTeamtype other = (QTeamtype) that;
        return (this.getTtypeid() == null ? other.getTtypeid() == null : this.getTtypeid().equals(other.getTtypeid()))
            && (this.getTtypename() == null ? other.getTtypename() == null : this.getTtypename().equals(other.getTtypename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTtypeid() == null) ? 0 : getTtypeid().hashCode());
        result = prime * result + ((getTtypename() == null) ? 0 : getTtypename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ttypeid=").append(ttypeid);
        sb.append(", ttypename=").append(ttypename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}