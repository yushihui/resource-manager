package com.netbrain.kc.resourcemanager.deltachange;

import com.netbrain.kc.resourcemanager.assets.ResourceEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "delta_change")
@Data
@NoArgsConstructor
public class DeltaChange {
    private String repo;
    //current version
    private String head;
    private String base;
    private ChangeAction action;
    private ResourceEnum resourceType;
    private String resourceLocation;
    private String resourceId;
    private Date date;

}
