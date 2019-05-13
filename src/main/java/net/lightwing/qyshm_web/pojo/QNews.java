package net.lightwing.qyshm_web.pojo;


public class QNews {

  private long nid;
  private String ntitle;
  private String coverimg;
  private String ndetail;
  private java.sql.Timestamp createtime;
  private String author;


  public long getNid() {
    return nid;
  }

  public void setNid(long nid) {
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


  public String getNdetail() {
    return ndetail;
  }

  public void setNdetail(String ndetail) {
    this.ndetail = ndetail;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}
