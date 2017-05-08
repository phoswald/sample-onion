package sample.persistence;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import sample.domain.Tweet;
import sample.domain.TwitterRepository;
import sample.domain.User;

public class TwitterRepositoryImpl implements TwitterRepository {

    private static final Charset CS = StandardCharsets.UTF_8;
    private static final Path PATH_USERS = Paths.get("users.txt");
    private static final Path PATH_TWEETS = Paths.get("tweets.txt");

    @Override
    public Collection<User> findUsers(String query) {
        try {
            return Files.lines(PATH_USERS, CS).
                filter(line -> !line.isEmpty()).
                map(line -> line.split("\\|")).
                map(tokens -> new User(tokens[0], tokens[1])).
                collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public Collection<Tweet> findTweets(String query) {
        try {
            return Files.lines(PATH_TWEETS, CS).
                    filter(line -> !line.isEmpty()).
                    map(line -> line.split("\\|")).
                    map(tokens -> new Tweet(Long.parseLong(tokens[0]), tokens[1], tokens[2])).
                    collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public Optional<User> getUser(String id) {
        return findUsers(null).stream().
                filter(user -> user.getId().equals(id)).
                findFirst();
    }

    @Override
    public void addTweet(Tweet tweet) {
        try(Writer writer = Files.newBufferedWriter(PATH_TWEETS, CS, StandardOpenOption.APPEND)) {
            writer.write(tweet.getId() + "|" + tweet.getUserId() + "|" + tweet.getText() + "\n");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
