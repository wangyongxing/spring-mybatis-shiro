package com.wyx.common.page;

/**
 * 应用分页的对象
 * Created by wangyongxing on 16/3/31.
 */

import java.io.Serializable;


public class Page implements Serializable {

    private static final Integer DEFUALT_PAGE_SIZE = 30;

    private static final Integer DEFAULT_TOTAL_NUM = 0;
    /**
     * 分页中，页面大小，即每页显示多少的数据
     */
    private Integer numPerPage;

    private Integer pageNum = 1;

    private Integer totalNum = DEFAULT_TOTAL_NUM;

    private Integer startIndex;

    private Integer endIndex;

    private Integer totalPage;

    public Page(Integer numPerPage, Integer pageNum) {
        this.numPerPage = numPerPage;
        setPageNum(pageNum);
    }

    public Page(Integer numPerPage, Integer pageNum, Integer totalNum) {
        super();
        this.numPerPage = numPerPage;
        this.pageNum = pageNum;
        this.totalNum = totalNum;
    }

    public Page() {
        setNumPerPage(DEFUALT_PAGE_SIZE);
    }

    public Integer getTotalPageNum() {
        if (totalNum == 0) {
            return Integer.valueOf(0);
        }
        return totalNum / numPerPage + (totalNum % numPerPage == 0 ? 0 : 1);
    }

    /**
     * @return the numPerPage
     */
    public Integer getNumPerPage() {
        return numPerPage;
    }

    /**
     * @param numPerPage the numPerPage to set
     */
    public void setNumPerPage(Integer numPerPage) {
        if (numPerPage == null) {
            this.numPerPage = DEFUALT_PAGE_SIZE;
        } else {
            this.numPerPage = numPerPage;
        }
        caculatIndex();
    }

    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        if (pageNum == null) {
            this.pageNum = Integer.valueOf(1);
        } else {
            this.pageNum = pageNum;
        }
        caculatIndex();
    }

    /**
     * @return the totalNum
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * @param totalNum the totalNum to set
     */
    public void setTotalNum(Integer totalNum) {
        if (totalNum == null) {
            this.totalNum = DEFAULT_TOTAL_NUM;
            return;
        }
        this.totalNum = totalNum;
    }

    private void caculatIndex() {
        if (this.pageNum == null || this.pageNum <= 1) {
            this.pageNum = 1;
        }
        if (this.numPerPage == null || this.numPerPage <= 0) {
            this.numPerPage = DEFUALT_PAGE_SIZE;
        }
        this.startIndex = (this.pageNum - 1) * this.numPerPage;
        this.endIndex = this.numPerPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getTotalPage() {
        return 1 + this.getTotalNum() / this.getNumPerPage();
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isHasNextPage() {
        return (this.pageNum < this.getTotalPage()) ? true : false;
    }


}

