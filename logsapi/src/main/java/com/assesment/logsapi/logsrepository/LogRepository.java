package com.assesment.logsapi.logsrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.logsapi.logsmodel.LogRegist;

@Component
public interface LogRepository
		extends JpaRepository<LogRegist, Integer> {

	LogRegist findByClientIpAndTimestampStart(String clientIp,
			String timestampStart);

}
