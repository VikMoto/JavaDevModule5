package module7HW;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            // Create URL object
            URL url = new URL(checker.getStatusImage(code));

            // Open input stream from URL
            InputStream inputStream = url.openStream();

            // Create output stream to save image
            OutputStream outputStream = new FileOutputStream("cat.jpg");

            // Copy bytes from input stream to output stream
            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            // Close streams
            inputStream.close();
            outputStream.close();

            System.out.println("Image downloaded successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
