package com.assesment.bookingapi.credentialservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.assesment.bookingapi.credentialmodel.Credential;
import com.assesment.bookingapi.credentialrepository.CredentialRepository;

@Component
public class CredentialService {

	@Autowired
	CredentialRepository credentialRepository;

	public CredentialService(
			CredentialRepository credentialRepository) {
		super();
		this.credentialRepository = credentialRepository;
	}

	public ResponseEntity<Credential> getCredentials(String email,
			String password) {
		final Credential credential = credentialRepository
				.findByEmailAndPassWord(email, password);

		if (credential == null) {
			new ResponseEntity<Credential>(credential,
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Credential>(credential,
				HttpStatus.OK);
	}

}
