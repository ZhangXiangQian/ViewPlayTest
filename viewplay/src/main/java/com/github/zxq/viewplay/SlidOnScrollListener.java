package com.github.zxq.viewplay;

/**
 * 滚动监听器
 * 
 * @author Administrator
 * 
 */
public interface SlidOnScrollListener {
	/**
	 * 滚动.
	 * 
	 * @param arg1
	 *            返回参数
	 */
	public void onScroll(int arg1);

	/**
	 * 滚动停止.
	 */
	public void onScrollStoped();

	/**
	 * 滚到了最左边.
	 */
	public void onScrollToLeft();

	/**
	 * 滚到了最右边.
	 */
	public void onScrollToRight();
}
