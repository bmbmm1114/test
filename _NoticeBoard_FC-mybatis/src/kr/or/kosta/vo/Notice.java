package kr.or.kosta.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice implements Serializable{
	private int no;
	private String prefix;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
	
	public Notice(){}
	//등록시
	public Notice(String prefix, String title, String content, Date writeDate) {
		super();
		this.prefix = prefix;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
	}
	
	//수정시 
	public Notice(int no, String prefix, String title, String content) {
		this.no = no;
		this.prefix = prefix;
		this.title = title;
		this.content = content;
	}
	
	
	public Notice(int no, String prefix, String title, String content, Date writeDate, int viewCount) {
		super();
		this.no = no;
		this.prefix = prefix;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	//[prefix] title 문자열 만들어 리턴처리하는 메소드.
	public String getWholeTitle(){
		return String.format("[%s] %s", this.prefix, this.title);
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "Notice [no=" + no + ", prefix=" + prefix + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", viewCount=" + viewCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + no;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + viewCount;
		result = prime * result + ((writeDate == null) ? 0 : writeDate.hashCode());
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
		Notice other = (Notice) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (no != other.no)
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (viewCount != other.viewCount)
			return false;
		if (writeDate == null) {
			if (other.writeDate != null)
				return false;
		} else if (!writeDate.equals(other.writeDate))
			return false;
		return true;
	}
	
	
	
}
