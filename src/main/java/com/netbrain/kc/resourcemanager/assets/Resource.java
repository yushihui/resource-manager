package com.netbrain.kc.resourcemanager.assets;


import com.netbrain.kc.resourcemanager.repo.GitRepo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "resource")
@Data
@NoArgsConstructor
public class Resource {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repo_id", nullable = false)
    private GitRepo repo;
    private String ieVersion;
    private ResourceType type;

    /***
     * the full name = {repo}/{branch}/{resourceType}/{name}
     */
    private String fullName;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

}
