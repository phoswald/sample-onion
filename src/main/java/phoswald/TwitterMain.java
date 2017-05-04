package phoswald;

import phoswald.domain.TwitterRepository;
import phoswald.persistence.TwitterRepositoryImpl;
import phoswald.service.TwitterService;

public class TwitterMain {

    private final TwitterRepository repository = new TwitterRepositoryImpl();
    private final TwitterService service = new TwitterService(repository);

    public static void main(String[] args) {
        new TwitterMain().run();
    }

    private void run() {
        service.overview();
        service.tweet("philip", "hello, world from #java");
    }
}
