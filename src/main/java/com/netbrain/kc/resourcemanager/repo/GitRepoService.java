package com.netbrain.kc.resourcemanager.repo;

import org.springframework.stereotype.Service;

@Service
public class GitRepoService {

    private final GitRepoRepository gitRepoRepository;

    public GitRepoService(GitRepoRepository gitRepoRepository) {
        this.gitRepoRepository = gitRepoRepository;
    }
}
