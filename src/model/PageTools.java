package model;

import java.util.List;

public class PageTools {
	/**
	 * 构造参数
	 * @param curPage  页面传来的当前页
	 * @param pageCount  页面显示的数据条数
	 * @param totalCount  数据库查询出的总数据条数
	 */
	public PageTools(Integer curPage,Integer pageCount,Integer totalCount){
		this.curPage=curPage;
		this.pageCount=(pageCount==null?this.pageCount:pageCount);
		this.totalPage=(totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1);
		this.prePage=(curPage==1?curPage:curPage-1);
		this.nextPage=(curPage==totalPage?totalPage:curPage+1);
		this.startIndex=(curPage-1)*this.pageCount+1;
		this.endIndex=curPage*this.pageCount;
	}
	/**
	 * 当前页
	 */
	private Integer curPage;
	/**
	 * 上一页
	 */
	private Integer prePage;
	/**
	 * 下一页
	 */
	private Integer nextPage;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/** 
	 * 总数据条数
	 */
	private Integer totalCount;
	/**
	 * 每页显示条数
	 */
	private Integer pageCount=5;
	/**
	 * 数据库查询出的数据
	 */
	private List data;
	/**
	 * 开始搜引
	 */
	private Integer startIndex;
	/**
	 * 结束搜引
	 */
	private Integer endIndex;

	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public static void main(String[] args) {
		PageTools name = new PageTools(2,5,15);
		System.out.print(name.getTotalPage());
		System.out.print(name.getCurPage());
		System.out.print(name.getPrePage());
		System.out.print(name.getNextPage());
		System.out.print(name.getStartIndex());
		System.out.print(name.getEndIndex());
	}
}
