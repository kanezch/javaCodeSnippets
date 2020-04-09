package com.kanez;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

public class SSLSocketGreetServer {
    public static void main(String[] args) throws Exception{

        // set up key manager to do server authentication
        char[] passphrase = "passphrase".toCharArray();
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("/Users/kane/WorkDir/oraclejssesamples/sockets/server/testkeys"), passphrase);
        kmf.init(ks, passphrase);

        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(kmf.getKeyManagers(), null, null);

        ServerSocketFactory ssf = ctx.getServerSocketFactory();
        ServerSocket serverSocket = ssf.createServerSocket(6666);

        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)) {
            System.out.println("greeting");
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }
}
