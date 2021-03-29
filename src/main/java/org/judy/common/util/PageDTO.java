package org.judy.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {

	@Default
	private Integer page = 1;
	@Default
	private Integer perSheet = 10;
	
	private String type;
	private String keyword;
	
	public int getSkip() {
		return (page - 1) * perSheet;
	}
	
	public String getJsType() {
		
		return type == null?"''":type;
	}
	public String getJsKeyword() {
		return keyword == null?"''":keyword;
	}
	
	public String[] getArr() {
		if(type == null || type.trim().length() == 0) {
			return null;
		}
		
		if(keyword == null) {
			return null;
		}
		
		return type.split("");
	}
	
}
