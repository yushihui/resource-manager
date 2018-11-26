package com.netbrain.kc.resourcemanager.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @since 1.0
 */
@Repository
public interface GitRepoRepository extends JpaRepository<GitRepo, String> {

}
