package com.netbrain.kc.resourcemanager.cron;

import com.netbrain.kc.resourcemanager.gitclient.GitClient;
import com.netbrain.kc.resourcemanager.repo.GitRepoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronJob {

    private final GitClient gitClient;
    private final GitRepoService gitRepoService;

    public CronJob(GitClient gitClient, GitRepoService gitRepoService) {
        this.gitClient = gitClient;
        this.gitRepoService = gitRepoService;
    }

    @Scheduled(fixedRate = 5000)
    public void fetchRepoRelease() {
        gitRepoService.getRepos().forEach(gitRepo -> {
            //gitClient.fetchReleases(gitRepo.getName())
        });

    }
}