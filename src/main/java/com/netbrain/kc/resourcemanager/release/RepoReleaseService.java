package com.netbrain.kc.resourcemanager.release;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepoReleaseService {

    private final RepoReleaseRepository repoReleaseRepository;

    public RepoReleaseService(RepoReleaseRepository repoReleaseRepository) {
        this.repoReleaseRepository = repoReleaseRepository;
    }

    public List<RepoRelease> saveAllReleases(Iterable<RepoRelease> repoReleases) {
        return repoReleaseRepository.saveAll(repoReleases);
    }
}
