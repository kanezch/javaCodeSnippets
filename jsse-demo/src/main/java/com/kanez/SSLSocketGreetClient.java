package com.kanez;
import javax.net.ssl.*;
import java.io.*;
import java.security.cert.X509Certificate;

public class SSLSocketGreetClient {

    public static void main(String[] args) throws Exception {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext ctx = SSLContext.getInstance("SSL");
            ctx.init(null, null, null);


//            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocketFactory factory = ctx.getSocketFactory();

            SSLSocket socket = (SSLSocket)factory.createSocket("127.0.0.1", 6666);

            socket.startHandshake();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("hello server");
            if (out.checkError())
                System.out.println(
                        "SSLSocketClient:  java.io.PrintWriter error");

            /* read response */
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    socket.getInputStream()));

            String inputLine = in.readLine();
            System.out.println(inputLine);

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
