package net.lightwing.qyshm_web.commons.util;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 38942692@QQ.com
 * \* Date: 2018/4/20
 * \* Time: 16:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:分页实体类
 * \
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class PageInfo implements Serializable {

    private final static int PAGESIZE = 10; //默认显示的记录数
    private static final long serialVersionUID = -7890577003798186804L;

    private long total; // 总记录
    private List rows; //显示的记录
    @JsonIgnore
    private int from;
    @JsonIgnore
    private int size;
    private int nowpage; // 当前页
    private int pagesize; // 每页显示的记录数
    @JsonIgnore
    private Map<String, Object> condition; //查询条件
    @JsonIgnore
    private String sort = "create_time";// 排序字段
    @JsonIgnore
    private String order = "asc";// asc，desc mybatis Order 关键字

    private int totalPage; //总页数

    public int getTotalPage() {
        return ((int)total + pagesize - 1) / pagesize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public PageInfo() {}

    //构造方法
    public PageInfo(int nowpage, int pagesize) {
        //计算当前页
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        //计算开始的记录和结束的记录
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
    }

    // 构造方法
    public PageInfo(int nowpage, int pagesize, String sort, String order) {
        this(nowpage, pagesize) ;
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    @Override
    public String toString() {
        return "PageInfo{" +
                "total=" + total +
                ", rows=" + rows +
                ", from=" + from +
                ", size=" + size +
                ", nowpage=" + nowpage +
                ", pagesize=" + pagesize +
                ", condition=" + condition +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", totalPage=" + totalPage +
                '}';
    }
}

