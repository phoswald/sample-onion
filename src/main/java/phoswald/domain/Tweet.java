package phoswald.domain;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Tweet {

    private static final AtomicLong nextId = new AtomicLong(System.currentTimeMillis());

    private final long id;
    private final String userId;
    private final String text;

    public Tweet(User user, String text) {
        this(nextId.getAndIncrement(), user.getId(), text);
    }

    public Tweet(long id, String userId, String text) {
        this.id = id;
        this.userId = Objects.requireNonNull(userId);
        this.text = Objects.requireNonNull(text);
    }

    @Override
    public String toString() {
        return "[" + id + "] @" + userId + " said '" + text + "'";
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }
}
