package com.netbrain.kc.resourcemanager.repo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

}
