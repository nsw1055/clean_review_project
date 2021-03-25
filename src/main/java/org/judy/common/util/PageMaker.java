package org.judy.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PageMaker {

	private int start,end;
	private boolean prev,next;
	private PageDTO pageDTO;
	private int total;
	
	public PageMaker(PageDTO pageDTO , int total) {
		this.pageDTO = pageDTO;
		this.total = total;
		
		int page = pageDTO.getPage();
		int perSheet = pageDTO.getPerSheet();
		
		int realEnd = (int)Math.ceil(total / (double)perSheet);
		int tempEnd = (int)Math.ceil( page / 10.0) * 10;
		
		end = realEnd < tempEnd ? realEnd : tempEnd;
		
		start = tempEnd - 9;
		
		prev = this.start > 1;
		
		next = end < realEnd;
		
	}
	
}
