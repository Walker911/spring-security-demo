package com.walker.security.service.impl;

import com.walker.security.model.Authority;
import com.walker.security.repository.AuthorityRepository;
import com.walker.security.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> listAuthority() {
        return authorityRepository.findAll();
    }
}
