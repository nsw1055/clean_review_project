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
	
	public int getSkip() {
		return (page - 1) * perSheet;
	}
	
}
