package com.netbrain.kc.resourcemanager.deltachange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeltaChangeReporsitory extends JpaRepository<DeltaChange, String> {

}