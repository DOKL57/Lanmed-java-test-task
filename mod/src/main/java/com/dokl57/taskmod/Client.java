package com.dokl57.taskmod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void start()
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 4001)) {
            } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    }
