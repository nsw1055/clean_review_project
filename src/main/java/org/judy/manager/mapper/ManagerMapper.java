package org.judy.manager.mapper;

import java.util.List;

import org.judy.common.util.PageDTO;
import org.judy.manager.domain.Manager;

public interface ManagerMapper {

	public List<Manager> getManagerList(PageDTO pageDTO);
	
	public Manager selectOne(String mid);
	
	public void insertMan(Manager manager);
	
	public int totalMan(PageDTO pageDTO);
	
}
