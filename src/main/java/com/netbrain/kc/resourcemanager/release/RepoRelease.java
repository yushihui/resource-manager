package com.netbrain.kc.resourcemanager.release;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netbrain.kc.resourcemanager.repo.GitRepo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

/***
 *
 */
@Entity
@Table(name = "repo_release")
@Data
@NoArgsConstructor
public class RepoRelease implements Serializable {

    // here the repo=owner+"/"+repo
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repo_id", nullable = false)
    private GitRepo repo;
    private final String name;
    private final String tag;
    private final String description;
    private final String releaseUrl;
    private final Date releaseAt;
    /****
     * release id from github
     */
    private final long id;
    private ReleaseState state;

    /****
     * make sure using branch to label the IE version
     */
    private final String ieVersion;

    /***
     * is this an initial release
     */
    private boolean isInitial;

    /***
     * A git release json example See {@linktourl https://developer.github.com/v3/repos/releases/#list-releases-for-a-repository}
     * <p>
     *      {
     *     "url": "https://api.github.com/repos/yushihui/gocli/releases/13931047",
     *     "assets_url": "https://api.github.com/repos/yushihui/gocli/releases/13931047/assets",
     *     "upload_url": "https://uploads.github.com/repos/yushihui/gocli/releases/13931047/assets{?name,label}",
     *     "html_url": "https://github.com/yushihui/gocli/releases/tag/v8.0",
     *     "id": 13931047,
     *     "node_id": "MDc6UmVsZWFzZTEzOTMxMDQ3",
     *     "tag_name": "v8.0",
     *     "target_commitish": "master",
     *     "name": "v8.0",
     *     "draft": false,
     *     "author": {
     *       "login": "yushihui",
     *       "id": 3274936,
     *       "node_id": "MDQ6VXNlcjMyNzQ5MzY=",
     *       "avatar_url": "https://avatars1.githubusercontent.com/u/3274936?v=4",
     *       "gravatar_id": "",
     *       "url": "https://api.github.com/users/yushihui",
     *       "html_url": "https://github.com/yushihui",
     *       "followers_url": "https://api.github.com/users/yushihui/followers",
     *       "following_url": "https://api.github.com/users/yushihui/following{/other_user}",
     *       "gists_url": "https://api.github.com/users/yushihui/gists{/gist_id}",
     *       "starred_url": "https://api.github.com/users/yushihui/starred{/owner}{/repo}",
     *       "subscriptions_url": "https://api.github.com/users/yushihui/subscriptions",
     *       "organizations_url": "https://api.github.com/users/yushihui/orgs",
     *       "repos_url": "https://api.github.com/users/yushihui/repos",
     *       "events_url": "https://api.github.com/users/yushihui/events{/privacy}",
     *       "received_events_url": "https://api.github.com/users/yushihui/received_events",
     *       "type": "User",
     *       "site_admin": false
     *     },
     *     "prerelease": false,
     *     "created_at": "2018-11-09T22:40:00Z",
     *     "published_at": "2018-11-09T23:04:43Z",
     *     "assets": [
     *
     *     ],
     *     "tarball_url": "https://api.github.com/repos/yushihui/gocli/tarball/v8.0",
     *     "zipball_url": "https://api.github.com/repos/yushihui/gocli/zipball/v8.0",
     *     "body": "v8.0 is coming"
     *   }
     * </p>
     *
     * @param name
     * @param body
     * @param releaseUrl
     * @param tag
     * @param id
     */
    @JsonCreator
    public RepoRelease(@JsonProperty("name") String name,
                       @JsonProperty("body") String body,
                       @JsonProperty("releaseUrl") String releaseUrl,
                       @JsonProperty("tag_name") String tag,
                       @JsonProperty("published_at") Date releaseAt,
                       @JsonProperty("id") long id,
                       @JsonProperty("target_commitish") String branch

    ) {
        this.name = name;
        this.tag = tag;
        this.description = body;
        this.releaseUrl = releaseUrl;
        this.id = id;
        this.releaseAt = releaseAt;
        //this.repo = getRepoFromUrl(releaseUrl);
        this.state = ReleaseState.NORMAL;
        this.ieVersion = branch;

    }

    /***
     *
     * @param releaseUrl for example https://api.github.com/repos/yushihui/gocli/releases/13931047
     * @return yushihui/gocli
     */

    private String getRepoFromUrl(String releaseUrl) {
        URI uri = null;
        try {
            uri = new URI(releaseUrl);
            String[] segments = uri.getPath().split("/");
            if (segments.length < 3) {
                return "";
            }
            return segments[1] + "/" + segments[2];
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }
}
