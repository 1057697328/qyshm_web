package net.lightwing.qyshm_web.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * q_team
 * @author 
 */
@Data
public class QTeam implements Serializable {
    /**
     * 团队人员ID
     */
    private Integer tid;

    /**
     * 团队类型ID
     */
    private Integer ttypeid;

    /**
     * 人员头像路径
     */
    private String theadimg;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 0:循环为团队技术人员
1:只在前台展示tdetail
     */
    private Integer status;

    /**
     * 人员介绍详情
     */
    private String tdetail;

    private QTeamtype qTeamtype;
    private static final long serialVersionUID = 1L;

}