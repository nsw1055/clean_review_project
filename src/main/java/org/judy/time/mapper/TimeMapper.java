package org.judy.time.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	
	public String getTime();
	
	@Insert("insert into tbl_sample1 (col1) values ( #{str} )")
	void insert1(String str);
	
	@Insert("insert into tbl_sample2 (col2) values ( #{str} )")
	void insert2(String str);
	
}
