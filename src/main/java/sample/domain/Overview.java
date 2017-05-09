package sample.domain;

import java.util.Collection;

public class Overview {

    public String build(Collection<User> users, Collection<Tweet> tweets) {
        StringBuilder builder = new StringBuilder();
        builder.append("--- Users ---\n");
        for(User user : users) {
            builder.append(" - " + user + "\n");
        }
        builder.append("--- Tweets ---\n");
        for(Tweet tweet : tweets) {
            builder.append(" - " + tweet + "\n");
        }
        builder.append("---\n");
        return builder.toString();
    }
}
