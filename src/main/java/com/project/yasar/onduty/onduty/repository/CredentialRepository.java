package com.project.yasar.onduty.onduty.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.yasar.onduty.onduty.domain.Credential;

@Repository("credentialRepository")
public interface CredentialRepository extends CrudRepository<Credential,Long> {

    Credential findByUsername(String username);
}
