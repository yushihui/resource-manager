package com.netbrain.kc.resourcemanager.gitclient;

public final class Consts {

    public static final String GIT_RELEASE_URL = "https://api.github.com/repos/{owner}/{repo}/releases";
    // GET /repos/:owner/:repo/contents/:path
    public static final String GIT_CONTENTS_URL = "https://api.github.com/repos/{owner}/{repo}/contents/{path}?ref={sha}";
    public static final String GIT_COMPARE_URL = "https://api.github.com/repos/{owner}/{repo}/compare/{base}...{head}";


    private Consts(){
        //never call this
        throw new AssertionError();
    }
}
