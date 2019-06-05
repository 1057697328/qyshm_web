package net.lightwing.qyshm_web.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * q_coop
 *
 * @author
 */
@Data
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

    private String ctedail;
    private QCooptype qCoopType;

    private static final long serialVersionUID = 1L;

}