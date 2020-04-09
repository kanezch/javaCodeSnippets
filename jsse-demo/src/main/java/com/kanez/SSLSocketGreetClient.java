package com.kanez;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class SSLSocketGreetClient {

    public static void main(String[] args) throws Exception {
        try {
            SSLSocketFactory factory =
                (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket =
                (SSLSocket)factory.createSocket("127.0.0.1", 6666);

            socket.startHandshake();

//            PrintWriter out = new PrintWriter(
//                                  new BufferedWriter(
//                                  new OutputStreamWriter(
//                                  socket.getOutputStream())));

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
