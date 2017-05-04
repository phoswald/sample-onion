package phoswald.service;

import java.util.Objects;

import phoswald.domain.Overview;
import phoswald.domain.TwitterRepository;

public class TwitterService {

    private final TwitterRepository repository;

    public TwitterService(TwitterRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public void overview() {
        new Overview().dump(repository);
    }

    public void tweet(String userId, String text) {
        repository.getUser(userId).
                orElseThrow(() -> new IllegalArgumentException("ERROR: userId=" + userId + " does not exist.")).
                tweet(text, repository);
    }
}
