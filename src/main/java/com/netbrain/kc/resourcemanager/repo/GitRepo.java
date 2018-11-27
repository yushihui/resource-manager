package com.netbrain.kc.resourcemanager.repo;


import com.netbrain.kc.resourcemanager.release.RepoRelease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "repo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GitRepo implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    private String name;
    private String owner;
    private Date created;
    private Date updated;
    private String description;
    private RepoState state;
    private RepoType type;
     //TODO join customer table
    // private String customerId;

    @OneToMany(
            mappedBy = "repo",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    private List<RepoRelease> repoReleases = new ArrayList<>();

}
