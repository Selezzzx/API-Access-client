package su.selezzz.storytools.procedures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    public static String getToken(String token) throws IOException {
        final URL url = new URL("https://selezzzdev.pythonanywhere.com/get2/" + token);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            final StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}