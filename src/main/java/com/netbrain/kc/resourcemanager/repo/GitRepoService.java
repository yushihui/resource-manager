package com.netbrain.kc.resourcemanager.repo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GitRepoService {

    private final GitRepoRepository gitRepoRepository;

    public GitRepoService(GitRepoRepository gitRepoRepository) {
        this.gitRepoRepository = gitRepoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public GitRepo saveRepo(GitRepo repo) {
        return gitRepoRepository.save(repo);
    }

    public List<GitRepo> getRepos(){
        return gitRepoRepository.findAll();
    }

    public GitRepo getRepo(String id){
        return gitRepoRepository.findById(id).orElse(null);
    }
}
