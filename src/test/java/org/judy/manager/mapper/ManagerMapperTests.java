package org.judy.manager.mapper;

import org.judy.common.CommonConfig;
import org.judy.common.util.PageDTO;
import org.judy.manager.config.ManagerConfig;
import org.judy.manager.domain.Manager;
import org.judy.store.config.StoreConfig;
import org.judy.time.config.TimeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class, ManagerConfig.class , TimeConfig.class , StoreConfig.class})
@Log4j
public class ManagerMapperTests {

	@Autowired
	private ManagerMapper mapper;
	
	
	@Test
	public void testGetMemberList() {
		log.info("12312312");
		PageDTO pageDTO = PageDTO.builder().page(1).perSheet(10).build();
		
		log.info(mapper.getManagerList(pageDTO));
	}
	
	@Test
	public void testSelectOne() {
		log.info(mapper.selectOne("테스트1"));
	}
	
	@Test
	public void testInsert() {
		log.info("insert.....");
		for (int i = 101; i <= 200; i++) {
			Manager manager = Manager.builder().mid("user"+i)
											.mpw("1234")
											.email("asdf@asdf.asd")
											.phone("01012345678")
											.logoImg("/resources/img/noimg.jpg")
											.enabled(true)
											.approval(true)
											.build();
											
		mapper.insertMan(manager);
		}		
	}
	
	@Test
	public void testTotal() {
		log.info(mapper.totalMan());
	}
}
