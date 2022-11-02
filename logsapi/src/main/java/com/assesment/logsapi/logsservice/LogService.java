package com.assesment.logsapi.logsservice;

import java.net.URI;
import java.util.Optional;

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
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLog.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public LogRegist getByIpAndTimeStamp(String ip, String timestamp) {
		return logRepository.findByClientIpAndTimestampStart(ip, timestamp);

	}

	public Optional<LogRegist> getById(Integer id) {

		return logRepository.findById(id);
	}

	public ResponseEntity<LogRegist> updateLog(String ip, String timestapmStart, String timestampEnd) {
		LogRegist retrievedLogRegist = logRepository.findByClientIpAndTimestampStart(ip, timestapmStart);
		retrievedLogRegist.setTimestampEnd(timestampEnd);

		logRepository.save(retrievedLogRegist);

		return ResponseEntity.ok().build();
	}

}
