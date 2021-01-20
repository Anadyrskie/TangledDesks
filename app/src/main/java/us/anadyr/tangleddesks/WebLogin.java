package us.anadyr.tangleddesks;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WebLogin{

















    @RequiresApi(api = Build.VERSION_CODES.N)
        public String getKey() throws IOException {
            URL url = new URL("http://api.td.anadyr.us");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);

            Map<String,String> arguments = new HashMap<>();
            arguments.put("username=", "root");
            arguments.put("password=", "sjh76HSn!"); // This is a fake password obviously
            arguments.put("submit=", "login");
            StringJoiner sj = new StringJoiner("&");
            for(Map.Entry<String,String> entry : arguments.entrySet())
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                        + URLEncoder.encode(entry.getValue(), "UTF-8"));
            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            System.out.println(http.getResponseMessage());
            return http.getHeaderField(5);

        }
    }


/*public class WebLogin {
    private String makePostRequest(String url, List<String> header_fields, List<String> header_values) {

        String sessionCookie = "";

        HttpResponse response = null;
        HttpClient httpClient = new HttpClientBuilder();
        HttpPost httpPost = new HttpPost(url);

        //Post Data
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(header_fields.size());

        for (int i = 0; i < header_fields.size(); i++) {

            nameValuePair.add(new BasicNameValuePair(header_fields.get(i), header_values.get(i)));
        }
        //Encoding POST data
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            // log exception
            e.printStackTrace();
        }

        //making POST request.
        try {
            response = httpClient.execute(httpPost);
            // write response to log
            Log.d("Http Post Response:", response.toString());
        } catch (ClientProtocolException e) {
            // Log exception
            e.printStackTrace();
        } catch (IOException e) {
            // Log exception
            e.printStackTrace();
        }
        return sessionCookie;
    }*/