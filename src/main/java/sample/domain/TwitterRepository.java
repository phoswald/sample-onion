package sample.domain;

import java.util.Collection;
import java.util.Optional;

public interface TwitterRepository {

    public Collection<User> findUsers(String query);

    public Collection<Tweet> findTweets(String query);

    public Optional<User> getUser(String id);

    public void addTweet(Tweet tweet);
}
