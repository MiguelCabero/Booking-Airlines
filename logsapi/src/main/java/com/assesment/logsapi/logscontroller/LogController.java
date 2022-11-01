package com.assesment.logsapi.logscontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.logsapi.logsmodel.LogRegist;
import com.assesment.logsapi.logsservice.LogService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class LogController {

	@Autowired
	private LogService logService;

	@PostMapping(path = "/api/logs")
	public ResponseEntity<LogRegist> addLog(@Valid @RequestBody LogRegist logRegist) {
		return logService.addLog(logRegist);
	}

	@GetMapping(path = "/api/logs/{ip}/{timestamp}")
	ResponseEntity<LogRegist> getByIpAndTimeStamp(@PathVariable("ip") String ip,
			@PathVariable("timestamp") String timeStamp) {

		final LogRegist retrievedLogRegist = logService.getByIpAndTimeStamp(ip, timeStamp);

		if (retrievedLogRegist == null) {
			return new ResponseEntity<LogRegist>(retrievedLogRegist, HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<LogRegist>(retrievedLogRegist, HttpStatus.OK);

	}

	@GetMapping(path = "/api/logs/{id}")
	ResponseEntity<Optional<LogRegist>> getByIpAndTimeStamp(@PathVariable("id") Integer id) {
		final LogRegist retrievedLogRegist = logService.getById(id).get();

		System.out.println(id);
		System.out.println(retrievedLogRegist);

		return new ResponseEntity<Optional<LogRegist>>(logService.getById(id), HttpStatus.OK);

	}

	@PutMapping(path = "/api/logs/{ip}/{timestamp}")
	ResponseEntity<LogRegist> updateTimeStampEnd(@PathVariable("ip") String ip,
			@PathVariable("timestamp") String timestampStart, String timestampEnd) {
		return logService.updateLog(ip, timestampStart, timestampEnd);
	}
}
