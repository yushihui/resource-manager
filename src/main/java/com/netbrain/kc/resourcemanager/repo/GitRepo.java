package com.netbrain.kc.resourcemanager.repo;


import com.netbrain.kc.resourcemanager.release.RepoRelease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "repo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitRepo {
    @Column(name = "id")
    private String id;
    private String name;
    private String owner;
    private Date created;
    private Date updated;
    private String description;
    private RepoState state;
    private RepoType type;

    @OneToMany(
            mappedBy = "repo",
            cascade = CascadeType.ALL
    )
    private List<RepoRelease> repoReleases = new ArrayList<>();

}
