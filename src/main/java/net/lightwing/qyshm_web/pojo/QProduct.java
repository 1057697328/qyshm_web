package net.lightwing.qyshm_web.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * q_product
 * @author 
 */
@Data
public class QProduct implements Serializable {
    /**
     * 产品编号
     */
    private Integer pid;

    private String pname;

    /**
     * 产品封面图路径
     */
    private String qcoverimg;

    /**
     * 产品详情
     */
    private String qdetail;

    private static final long serialVersionUID = 1L;

}