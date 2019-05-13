package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;

/**
 * q_qrcode
 * @author 
 */
public class QQrcode implements Serializable {
    /**
     * 二维码编号
     */
    private Integer qid;

    /**
     * 二维码图片链接
     */
    private String imgpath;

    private static final long serialVersionUID = 1L;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
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
        QQrcode other = (QQrcode) that;
        return (this.getQid() == null ? other.getQid() == null : this.getQid().equals(other.getQid()))
            && (this.getImgpath() == null ? other.getImgpath() == null : this.getImgpath().equals(other.getImgpath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQid() == null) ? 0 : getQid().hashCode());
        result = prime * result + ((getImgpath() == null) ? 0 : getImgpath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qid=").append(qid);
        sb.append(", imgpath=").append(imgpath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}