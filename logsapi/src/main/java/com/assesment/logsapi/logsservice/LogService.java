package com.assesment.logsapi.logsservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assesment.logsapi.logsmodel.LogRegist;
import com.assesment.logsapi.logsrepository.LogRepository;

@Component
public class LogService {

	@Autowired
	private LogRepository logRepository;

	public ResponseEntity<LogRegist> addLog(LogRegist log) {
		final LogRegist savedLog = logRepository.save(log);
		final URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLog.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
