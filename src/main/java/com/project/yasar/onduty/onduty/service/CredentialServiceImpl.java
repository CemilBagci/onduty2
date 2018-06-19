package com.project.yasar.onduty.onduty.service;
import com.project.yasar.onduty.onduty.domain.Credential;
import com.project.yasar.onduty.onduty.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("credentialService")
public class CredentialServiceImpl {
    @Autowired
    private CredentialRepository credentialRepository;


    public Credential createCredential(Credential credential) {
        return credentialRepository.save(credential);
    }
}
