package com.netbrain.kc.resourcemanager.cron;

import com.netbrain.kc.resourcemanager.gitclient.GitClient;
import com.netbrain.kc.resourcemanager.release.RepoRelease;
import com.netbrain.kc.resourcemanager.release.RepoReleaseService;
import com.netbrain.kc.resourcemanager.repo.GitRepoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CronJob {

    private final GitClient gitClient;
    private final GitRepoService gitRepoService;
    private final RepoReleaseService repoReleaseService;
    private static final Logger logger = LogManager.getLogger(CronJob.class);

    public CronJob(GitClient gitClient, GitRepoService gitRepoService, RepoReleaseService repoReleaseService) {
        this.gitClient = gitClient;
        this.gitRepoService = gitRepoService;
        this.repoReleaseService = repoReleaseService;
    }

    @Scheduled(fixedRate = 5000)
    public void fetchRepoRelease() {
        logger.info("fetch release job is running");
        gitRepoService.getRepos().forEach(gitRepo -> {
            List<RepoRelease> repoReleases = gitClient.fetchReleases(gitRepo.getOwner(), gitRepo.getName());
            repoReleases.forEach(repoRelease -> {
                repoRelease.setRepo(gitRepo);
            });
            repoReleaseService.saveAllReleases(repoReleases);
        });

    }
}