package com.netbrain.kc.resourcemanager.release;

import org.springframework.stereotype.Service;

@Service
public class RepoReleaseService {

    private final RepoReleaseRepository repoReleaseRepository;

    public RepoReleaseService(RepoReleaseRepository repoReleaseRepository) {
        this.repoReleaseRepository = repoReleaseRepository;
    }
}
