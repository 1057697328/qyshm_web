package net.lightwing.qyshm_web.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * q_news
 * @author 
 */
public class QNews implements Serializable {
    /**
     * 新闻编号
     */
    private Integer nid;

    /**
     * 新闻标题
     */
    private String ntitle;

    /**
     * 封面图片
     */
    private String coverimg;

    /**
     * 发布时间
     */
    private Date createtime;

    /**
     * 作者
     */
    private String author;

    /**
     * 新闻详情
     */
    private String ndetail;

    private static final long serialVersionUID = 1L;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNdetail() {
        return ndetail;
    }

    public void setNdetail(String ndetail) {
        this.ndetail = ndetail;
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
        QNews other = (QNews) that;
        return (this.getNid() == null ? other.getNid() == null : this.getNid().equals(other.getNid()))
            && (this.getNtitle() == null ? other.getNtitle() == null : this.getNtitle().equals(other.getNtitle()))
            && (this.getCoverimg() == null ? other.getCoverimg() == null : this.getCoverimg().equals(other.getCoverimg()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getNdetail() == null ? other.getNdetail() == null : this.getNdetail().equals(other.getNdetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNid() == null) ? 0 : getNid().hashCode());
        result = prime * result + ((getNtitle() == null) ? 0 : getNtitle().hashCode());
        result = prime * result + ((getCoverimg() == null) ? 0 : getCoverimg().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getNdetail() == null) ? 0 : getNdetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nid=").append(nid);
        sb.append(", ntitle=").append(ntitle);
        sb.append(", coverimg=").append(coverimg);
        sb.append(", createtime=").append(createtime);
        sb.append(", author=").append(author);
        sb.append(", ndetail=").append(ndetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}