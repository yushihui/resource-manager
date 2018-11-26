package com.netbrain.kc.resourcemanager.repo;


public enum RepoType {
    /***
     * This type repo is for hosting all resources maintained by NetBrain
     */
    BASE,

    /***
     * This type repo is kind of a patch for resources in base repo which is also maintained by NetBrain
     * for example a driver resource
     *
     */
    BASE_PATCH,

    /***
     * This type repo we may host all customized resource which are NOT in BASE repo
     * also maintained by NetBrain
     */
    CUSTOMIZE,


    /***
     * This type repo was created and maintained by Third party NOT NetBrain
     */
    EXTERNAL
}
