package org.judy.time.service;

import org.judy.common.CommonConfig;
import org.judy.time.config.TimeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class , TimeConfig.class})
@Log4j
public class TimeServiceTests {

	@Autowired
	private TimeService service;
	
	@Test
	public void testService() {
		log.info(service.getTime());
	}
	
	@Test
	public void testTransaction() {
		
		String str = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세";
		
		log.info(service.insert(str));
	}
	
}
