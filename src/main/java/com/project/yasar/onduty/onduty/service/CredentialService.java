package com.project.yasar.onduty.onduty.service;
import com.project.yasar.onduty.onduty.domain.Credential;
import org.springframework.stereotype.Service;

@Service
public interface CredentialService {
    Credential createCredential(Credential credential);
}
