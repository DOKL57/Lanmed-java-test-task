package com.dokl57.taskmod;

import com.mojang.logging.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void start()
    {

        try (Socket socket = new Socket("localhost", 4001)) {
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while (true) {
                if(in.readLine()!="") {
                    LogUtils.getLogger().info("Server replied: " + in.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    }
