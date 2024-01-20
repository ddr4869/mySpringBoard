package tom.study.api.feign.dto;

import lombok.Getter;

@Getter
public class Contributor {
    String login;
    String id;
    String node_id;
    String avatar_url;
    String gravatar_id;
    String url;
    String html_url;
    String followers_url;
    String following_url;
    String gists_url;
    String starred_url;
    String subscriptions_url;
    String organizations_url;
    String repos_url;
    String events_url;

    String received_events_url;
    String type;
    String site_admin;
    String contributions;

//    {
//        "login": "dependabot[bot]",
//            "id": 49699333,
//            "node_id": "MDM6Qm90NDk2OTkzMzM=",
//            "avatar_url": "https://avatars.githubusercontent.com/in/29110?v=4",
//            "gravatar_id": "",
//            "url": "https://api.github.com/users/dependabot%5Bbot%5D",
//            "html_url": "https://github.com/apps/dependabot",
//            "followers_url": "https://api.github.com/users/dependabot%5Bbot%5D/followers",
//            "following_url": "https://api.github.com/users/dependabot%5Bbot%5D/following{/other_user}",
//            "gists_url": "https://api.github.com/users/dependabot%5Bbot%5D/gists{/gist_id}",
//            "starred_url": "https://api.github.com/users/dependabot%5Bbot%5D/starred{/owner}{/repo}",
//            "subscriptions_url": "https://api.github.com/users/dependabot%5Bbot%5D/subscriptions",
//            "organizations_url": "https://api.github.com/users/dependabot%5Bbot%5D/orgs",
//            "repos_url": "https://api.github.com/users/dependabot%5Bbot%5D/repos",
//            "events_url": "https://api.github.com/users/dependabot%5Bbot%5D/events{/privacy}",
//            "received_events_url": "https://api.github.com/users/dependabot%5Bbot%5D/received_events",
//            "type": "Bot",
//            "site_admin": false,
//            "contributions": 340
//    },
}