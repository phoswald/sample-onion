package sample.domain;

public class Overview {

    public void dump(TwitterRepository repository /* TODO: how can domain object access adapters? */) {
        System.out.println("--- Users ---");
        for(User user : repository.findUsers(null)) {
            System.out.println(" - " + user);
        }
        System.out.println("--- Tweets ---");
        for(Tweet tweet : repository.findTweets(null)) {
            System.out.println(" - " + tweet);
        }
        System.out.println("---");
    }
}
