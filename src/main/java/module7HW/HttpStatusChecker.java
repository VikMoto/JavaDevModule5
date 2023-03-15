package module7HW;

import java.io.IOException;
import java.net.*;
/**
 * Напиши класс HttpStatusChecker. Цей клас має мати один метод: *
 * String getStatusImage(int code). Він приймає код статусу, і повертає посилання
 * на картинку для цього коду. Якщо для відповідного коду картинки немає (сайт
 * https://http.cat повернув 404) - метод викидає Exception.
 * Наприклад, виклик getStatusImage(200) має повернути рядок
 * https://http.cat/200.jpg. А виклик getStatusImage(10000) має викинути
 * виключення, тому що сайт https://http.cat поверне код відповіді 404. *
 * Протестуй свою програму, викликаючи її з різними аргументами.
 * */
public class HttpStatusChecker {
    public String getStatusImage(int code) throws URISyntaxException, IOException {
        String urlMain = "https://http.cat";
        String result = "";
        URL url = new URL(urlMain + "/" + code + ".jpg");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("HEAD");
        int responseCode = urlConnection.getResponseCode();
        urlConnection.disconnect();
        System.out.println("responseCode = " + responseCode);

        if (responseCode == 200) {
            result = url.getPath();
        }else {
            throw new RuntimeException("Failed to get status image: HTTP error code " + responseCode);
        }



        return urlMain + result;
    }
}
