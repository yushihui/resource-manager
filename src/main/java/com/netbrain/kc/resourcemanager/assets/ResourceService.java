package com.netbrain.kc.resourcemanager.assets;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {


    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
}
