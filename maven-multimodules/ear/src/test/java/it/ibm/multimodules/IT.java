package it.ibm.multimodules;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IT {
    String port = System.getProperty("default.http.port");
    String war = "converter";
    String urlBase = format("http://localhost:%s/%s/",port,war);

    @Test
    // tag::testIndexPage[]
    public void textIndexPage() throws Exception{
        var url = this.urlBase;
        HttpURLConnection con = testRequestHelper(url, "GET");
        assertEquals(200, con.getResponseCode(), "Incorrect response code from " + url);
        assertTrue(testBufferHelper(con).contains("Informe a altura em centimetros"), "Incorrect response code from " + url);
    }
    // end::testIndexPage[]

    @Test
    // tag::testHeightsPage[]
    public void testHeightsPage() throws Exception {
        var url = format("%sheights.jsp?heightCm=10",this.urlBase);
        HttpURLConnection con = testRequestHelper(url, "POST");
        assertTrue(testBufferHelper(con).contains("3        inches")
                , "Incorrect response code from " + url);
    }
    // end::testHeightsPage[]

    private HttpURLConnection testRequestHelper(String url, String method)
            throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        return con;
    }

    private String testBufferHelper(HttpURLConnection con) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}