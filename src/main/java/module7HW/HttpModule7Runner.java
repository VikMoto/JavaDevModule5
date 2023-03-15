package module7HW;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpModule7Runner {
    public static void main(String[] args) {
//        final HttpStatusChecker checker = new HttpStatusChecker();
//        final String statusImage;
//        try {
//            statusImage = checker.getStatusImage(302);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("statusImage = " + statusImage);

//        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
//        imageDownloader.downloadStatusImage(303);

        HttpImageStatusCli cli = new HttpImageStatusCli();
        try {
            cli.askStatus();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
