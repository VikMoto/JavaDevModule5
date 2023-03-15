package module7HW;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws URISyntaxException, IOException, InterruptedException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();

        String inputExpression = "Enter HTTP status code:";
        System.out.println(inputExpression);
        Scanner scanner = new Scanner(System.in);

        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
        String nextLine = scanner.nextLine();

        while (!nextLine.equals("exit")){
            if (Integer.parseInt(nextLine) < 100 || Integer.parseInt(nextLine) > 600 ) {
                System.out.println("Please enter valid number: ");
                nextLine = scanner.nextLine();
            } else {
                String statusImage = statusChecker.getStatusImage(Integer.parseInt(nextLine));
                System.out.println("statusImage = " + statusImage);

                imageDownloader.downloadStatusImage(Integer.parseInt(nextLine));

                System.out.println("inputExpression = " + inputExpression);
                nextLine = scanner.nextLine();
            }
        }
    }


}
