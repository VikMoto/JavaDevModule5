package module7HW;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws URISyntaxException, IOException {
        String inputExpression = "Enter HTTP status code:\n";
        System.out.println("inputExpression = " + inputExpression);
        Scanner scanner = new Scanner(System.in);
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();
        String nextLine = scanner.nextLine();

        while (!nextLine.equals("exit")){
            if (Integer.parseInt(nextLine) < 100 || Integer.parseInt(nextLine) > 600 ) {
                System.out.println("Please enter valid number: ");
                nextLine = scanner.nextLine();
            } else {
                final String statusImage = statusChecker.getStatusImage(Integer.parseInt(nextLine));
                System.out.println("statusImage = " + statusImage);
                imageDownloader.downloadStatusImage(Integer.parseInt(nextLine));
                System.out.println("inputExpression = " + inputExpression);
                nextLine = scanner.nextLine();
            }
        }
    }
}
