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

	public ResponseEntity<Credential> getCredentials(
			Credential credential) {
		final Credential credential1 = credentialRepository
				.findByEmailAndPassword(credential.getEmail(),
						credential.getPassword());
		System.out.println(credential);

		if (credential1 == null) {
			return new ResponseEntity<Credential>(credential1,
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Credential>(credential1,
				HttpStatus.OK);
	}

}
