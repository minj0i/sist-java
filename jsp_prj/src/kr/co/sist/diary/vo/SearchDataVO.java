package kr.co.sist.diary.vo;

public class SearchDataVO {
	private String fieldName, keyword;

	public SearchDataVO() {
	}

	public SearchDataVO(String fieldName, String keyword) {
		this.fieldName = fieldName;
		this.keyword = keyword;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getKeyword() {
		return keyword;
	}
	
	
}//class
