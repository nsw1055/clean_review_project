package org.judy.time.service;

import org.judy.time.mapper.TimeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {

	private final TimeMapper mapper;
	
	@Override
	public String getTime() {
		
		return mapper.getTime();
	}

	@Transactional
	@Override
	public String insert(String str) {
		
		mapper.insert1(str);
		mapper.insert2(str);
		return null;
	}


}
