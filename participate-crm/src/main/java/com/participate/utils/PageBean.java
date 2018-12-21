package com.participate.utils;

/**
 * 分页显示的标准类,基本操作,是先给予-当前页数一共的数据条数-每页显示的条数,
 * 然后在初始化该类,得到总共页数,和开始序号和结束序号,
 * 然后数据库分页用到开始序号和结束序号,得到数据集合后赋值给该类的list属性,
 */
public class PageBean {

    private int pageIndex;//当前页数
    private int pageSize;//每页数据条数
    private int count;//数据条数
    private int pageCount;//总页数
    private int start;//起始数据位置
    private int end;//结束

    public void init(){
        /*根count 和pageSize计算页数pageCount
         */
        int pageCount_x=(int)count/pageSize;
        if(count>=pageSize){
            this.pageCount=count%pageSize==0?pageCount_x:pageCount_x+1;
        }else{
            this.pageCount=1;
        }
        //判断页数和当前页数
        if(pageIndex>pageCount){
            pageIndex=pageCount;
        }
        if(pageIndex<1){
            pageIndex=1;
        }
        //根据当前页计算起始和结束条目
        this.start=(pageIndex-1)*pageSize;
        this.end=pageIndex*pageSize;
    }

    public PageBean(int pageIndex, int count, int pageSize) {
        super();
        this.pageIndex = pageIndex;
        this.count = count;
        this.pageSize = pageSize;
    }


    public PageBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "PageBean [count=" + count + ", end=" + end
                + ", pageCount=" + pageCount + ", pageIndex=" + pageIndex
                + ", pageSize=" + pageSize + ", start=" + start + "]";
    }
    public int getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
}
