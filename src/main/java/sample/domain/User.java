package sample.domain;

import java.util.Objects;

public class User {

    private final String id;
    private String name;

    public User(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public User(String id, String name) {
        this(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "@" + id + " is " + name;
    }

    public String getId() {
        return id;
    }

    public void tweet(String text, TwitterRepository repository /* TODO: how can domain object access adapters? */) {
        Tweet tweet = new Tweet(this, text);
        repository.addTweet(tweet);
    }
}
