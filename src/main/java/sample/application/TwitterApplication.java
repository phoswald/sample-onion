package sample.application;

import java.util.Objects;

import sample.domain.Overview;
import sample.domain.Tweet;
import sample.domain.TwitterRepository;
import sample.domain.User;

public class TwitterApplication {

    private final TwitterRepository repository;

    public TwitterApplication(TwitterRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public void overview() {
        System.out.println(new Overview().build(repository.findUsers(null), repository.findTweets(null)));
    }

    public void tweet(String userId, String text) {
        User user = repository.getUser(userId).orElseThrow(() -> new IllegalArgumentException("userId=" + userId));
        Tweet tweet = user.tweet(text);
        repository.addTweet(tweet);
    }
}
