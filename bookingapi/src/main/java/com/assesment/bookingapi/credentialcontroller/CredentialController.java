package com.assesment.bookingapi.credentialcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.bookingapi.credentialmodel.Credential;
import com.assesment.bookingapi.credentialservice.CredentialService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class CredentialController {

	@Autowired
	private CredentialService credentialService;

	@PostMapping(path = "/api/auth")
	public ResponseEntity<Credential> getCredential(
			@Valid @RequestBody Credential credential) {
		return credentialService.getCredentials(credential);
	}
}
