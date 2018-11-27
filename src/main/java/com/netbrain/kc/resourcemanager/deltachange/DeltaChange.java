package com.netbrain.kc.resourcemanager.deltachange;

import com.netbrain.kc.resourcemanager.assets.Resource;
import com.netbrain.kc.resourcemanager.release.RepoRelease;
import com.netbrain.kc.resourcemanager.repo.GitRepo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delta_change")
@Data
@NoArgsConstructor
public class DeltaChange {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repo_id", nullable = false)
    private GitRepo repo;
    //current version
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "head_release", nullable = false)
    private RepoRelease head;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "base_release", nullable = false)
    private RepoRelease base;
    private ChangeAction action;
    private String resourceLocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
