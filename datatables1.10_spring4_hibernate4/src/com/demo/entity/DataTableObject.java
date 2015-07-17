/*
 * All rights Reserved, Designed By DINGYONG
 * Copyright: Copyright(C) 2015
 */
package com.demo.entity;

import java.util.List;

/**
 * @author DINGYONG
 *
 *         2015年7月11日
 */
public class DataTableObject {
	private int draw;// 重绘请求的次数
	private int start;// 开始记录数
	private int length;// 展示条数
	private int recordsTotal; // 总记录数
	private int recordsFiltered;// 过滤后的总记录数
	private List<?> data;// 数据源

	/**
	 * 
	 */
	public DataTableObject() {
		super();
	}

	/**
	 * @param draw
	 * @param start
	 * @param length
	 * @param recordsTotal
	 * @param recordsFiltered
	 * @param data
	 */
	public DataTableObject(int draw, int start, int length, int recordsTotal,
			int recordsFiltered, List<?> data) {
		super();
		this.draw = draw;
		this.start = start;
		this.length = length;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}

	/**
	 * @param draw
	 *            the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal
	 *            the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * @return the recordsFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordsFiltered
	 *            the recordsFiltered to set
	 */
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * @return the data
	 */
	public List<?> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<?> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataTableObject [draw=" + draw + ", start=" + start
				+ ", length=" + length + ", recordsTotal=" + recordsTotal
				+ ", recordsFiltered=" + recordsFiltered + ", data=" + data
				+ "]";
	}
}
