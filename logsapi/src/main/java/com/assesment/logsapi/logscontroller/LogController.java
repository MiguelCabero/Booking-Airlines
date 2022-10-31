package com.assesment.logsapi.logscontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<LogRegist> addLog(
			@Valid @RequestBody LogRegist logRegist) {
		return logService.addLog(logRegist);
	}

}
