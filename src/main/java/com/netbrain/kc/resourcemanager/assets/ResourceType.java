package com.netbrain.kc.resourcemanager.assets;

public enum ResourceType {
    DRIVER(0),
    PARSER(10),
    QAPP(20);

    private int priority;

    private ResourceType(int priority) {
        this.priority = priority;
    }
}
