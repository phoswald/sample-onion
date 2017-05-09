package sample;

import sample.application.TwitterApplication;
import sample.domain.TwitterRepository;
import sample.persistence.TwitterRepositoryImpl;

public class TwitterMain {

    private final TwitterRepository repository = new TwitterRepositoryImpl();
    private final TwitterApplication application = new TwitterApplication(repository);

    public static void main(String[] args) {
        new TwitterMain().run();
    }

    private void run() {
        application.overview();
        application.tweet("philip", "hello, world from #java");
    }
}
