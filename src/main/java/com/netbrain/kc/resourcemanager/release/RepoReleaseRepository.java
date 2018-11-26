package com.netbrain.kc.resourcemanager.release;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoReleaseRepository extends JpaRepository<RepoRelease, String> {

}