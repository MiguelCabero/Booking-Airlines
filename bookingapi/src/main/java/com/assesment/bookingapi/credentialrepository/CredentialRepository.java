package com.assesment.bookingapi.credentialrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.bookingapi.credentialmodel.Credential;

@Component
public interface CredentialRepository
		extends JpaRepository<Credential, Integer> {

	public Credential findByEmailAndPassWord(String email,
			String password);

}
