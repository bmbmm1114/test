package kr.or.kosta.vo;

import java.io.Serializable;

public class Code implements Serializable{
	private String codeId;
	private String codeName;
	private String codeDesc;
	private String codeCategory;
	public Code(String codeId, String codeName, String codeDesc, String codeCategory) {
		this.codeId = codeId;
		this.codeName = codeName;
		this.codeDesc = codeDesc;
		this.codeCategory = codeCategory;
	}
	public Code() {
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	public String getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}
	@Override
	public String toString() {
		return "Code [codeId=" + codeId + ", codeName=" + codeName + ", codeDesc=" + codeDesc + ", codeCategory="
				+ codeCategory + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCategory == null) ? 0 : codeCategory.hashCode());
		result = prime * result + ((codeDesc == null) ? 0 : codeDesc.hashCode());
		result = prime * result + ((codeId == null) ? 0 : codeId.hashCode());
		result = prime * result + ((codeName == null) ? 0 : codeName.hashCode());
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
		Code other = (Code) obj;
		if (codeCategory == null) {
			if (other.codeCategory != null)
				return false;
		} else if (!codeCategory.equals(other.codeCategory))
			return false;
		if (codeDesc == null) {
			if (other.codeDesc != null)
				return false;
		} else if (!codeDesc.equals(other.codeDesc))
			return false;
		if (codeId == null) {
			if (other.codeId != null)
				return false;
		} else if (!codeId.equals(other.codeId))
			return false;
		if (codeName == null) {
			if (other.codeName != null)
				return false;
		} else if (!codeName.equals(other.codeName))
			return false;
		return true;
	}
	
	
}
