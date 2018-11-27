package com.netbrain.kc.resourcemanager.repo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repos")
public class GitRepoController {
    private final GitRepoService gitRepoService;

    public GitRepoController(GitRepoService gitRepoService) {
        this.gitRepoService = gitRepoService;
    }

    @GetMapping()
    public List<GitRepo> getRepos() {
        return gitRepoService.getRepos();
    }

    @PostMapping
    public GitRepo save(@RequestBody GitRepo repo) {
        return gitRepoService.saveRepo(repo);
    }

    @GetMapping("/{id}")
    public GitRepo getUserByScreenName(@PathVariable String id) {
        return gitRepoService.getRepo(id);
    }
}
