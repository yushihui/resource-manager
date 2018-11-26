package com.netbrain.kc.resourcemanager.deltachange;

import org.springframework.stereotype.Service;

@Service
public class DeltaChangeService {

    private final DeltaChangeReporsitory deltaChangeReporsitory;

    public DeltaChangeService(DeltaChangeReporsitory deltaChangeReporsitory) {
        this.deltaChangeReporsitory = deltaChangeReporsitory;
    }
}
