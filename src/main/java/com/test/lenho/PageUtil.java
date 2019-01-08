//package com.test.lenho;
//
//import lombok.ToString;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: lenho
// * @Description：
// * @Date：2018/6/12 15:21
// */
//@ToString
//public class PageUtil<T> implements Serializable {
//
//    /**
//     * 当前页
//     */
//    private int currentPage = 1;
//
//    /**
//     * 每页大小
//     */
//    private int pageSize = 10;
//
//    /**
//     * 总页数
//     */
//    private int pageTotal;
//
//    /**
//     * 第一页
//     */
//    private int firstPage = 1;
//
//    /**
//     * 总条数
//     */
//    private int recordTotal = 0;
//
//    /**
//     * 前一页
//     */
//    private int previousPage;
//
//    /**
//     * 下一页
//     */
//    private int nextPage;
//
//    /**
//     * 最后一页
//     */
//    private int lastPage;
//
//    /**
//     * 总内容
//     */
//    private transient List<T> allContent;
//
//    /**
//     * 分页内容
//     */
//    private List<T> currentContent = new ArrayList<T>();
//
//    /**
//     * 设置当前页
//     * @param pageSize
//     */
//    public void setPageSize(int pageSize) {
//       this.pageSize = pageSize;
//    }
//
//    /**
//     * 设置总条数,默认为0 <br>
//     * @param recordTotal
//     */
//    public void setRecordTotal(int recordTotal) {
//        this.recordTotal = recordTotal;
//        otherAttr();
//    }
//
//    /**
//     * 当前页
//     * @param currentPage
//     */
//    public void setCurrentPage(int currentPage) {
//        this.currentPage = currentPage;
//    }
//
//    /**
//     * 设置总内容
//     * @param allContent
//     */
//    public void setAllContent(List<T> allContent) {
//        this.allContent = allContent;
//    }
//
//    private void otherAttr() {
//        //总页数
//        this.pageTotal = this.recordTotal % this.pageSize > 0 ? this.recordTotal / this.pageSize + 1 : this.recordTotal /this.pageSize;
//        this.firstPage = 1;
//        this.lastPage = this.pageTotal;
//        if(this.currentPage > 1) {
//            this.previousPage = this.currentPage - 1;
//        }else {
//            this.previousPage = this.currentPage;
//        }
//        if(this.currentPage < this.lastPage) {
//            this.nextPage = this.currentPage + 1;
//        }else {
//            this.nextPage = this.lastPage;
//        }
//    }
//
//    public int getCurrentPage() {
//        return currentPage;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public int getPageTotal() {
//        return pageTotal;
//    }
//
//    public int getFirstPage() {
//        return firstPage;
//    }
//
//    public int getRecordTotal() {
//        return recordTotal;
//    }
//
//    public int getPreviousPage() {
//        return previousPage;
//    }
//
//    public int getNextPage() {
//        return nextPage;
//    }
//
//    public int getLastPage() {
//        return lastPage;
//    }
//
//    public List<T> getCurrentContent() {
//        allContent.stream().skip((this.currentPage -1) * this.pageSize).limit(this.pageSize).forEach(e -> currentContent.add(e));
//        return currentContent;
//    }
//}
