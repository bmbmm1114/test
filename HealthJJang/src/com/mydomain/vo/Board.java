package com.mydomain.vo;

import java.util.Date;

public class Board {
	private int board_no;
	private String board_header; 
	private String board_name;
	private String board_content;
	private Date board_date;
	private int board_count;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_header() {
		return board_header;
	}
	public void setBoard_header(String board_header) {
		this.board_header = board_header;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	
	public Board(int board_no, String board_header, String board_name, String board_content, Date board_date,
			int board_count) {
		super();
		this.board_no = board_no;
		this.board_header = board_header;
		this.board_name = board_name;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_count = board_count;
	}
	
	public Board(){}
	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_header=" + board_header + ", board_name=" + board_name
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_count=" + board_count
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_content == null) ? 0 : board_content.hashCode());
		result = prime * result + board_count;
		result = prime * result + ((board_date == null) ? 0 : board_date.hashCode());
		result = prime * result + ((board_header == null) ? 0 : board_header.hashCode());
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + board_no;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (board_content == null) {
			if (other.board_content != null)
				return false;
		} else if (!board_content.equals(other.board_content))
			return false;
		if (board_count != other.board_count)
			return false;
		if (board_date == null) {
			if (other.board_date != null)
				return false;
		} else if (!board_date.equals(other.board_date))
			return false;
		if (board_header == null) {
			if (other.board_header != null)
				return false;
		} else if (!board_header.equals(other.board_header))
			return false;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (board_no != other.board_no)
			return false;
		return true;
	}
	
	
	
	
	
}
