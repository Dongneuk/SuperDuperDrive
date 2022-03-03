package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {

    private final CredentialMapper credentialMapper;

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }

    // get all credentials
    public List<Credentials> getAllCredentials(Integer userId) {
        return this.credentialMapper.getAllCredentials(userId);
    }

    // get credential by id
    public Credentials getCredentialsById(Integer credentialId) {
        return this.credentialMapper.getCredentialsById(credentialId);
    }

    // add new credential
    public void addCredentials(Credentials credentials) {
        this.credentialMapper.insertCredentials(credentials);
    }

    // edit credential
    public void updateCredentials(Credentials credentials) {
        this.credentialMapper.updateCredentials(credentials);
    }

    public void deleteCredentialByUserId(Integer credentialId) {
        this.credentialMapper.deleteCredentialsByUserId(credentialId);

    }







}
