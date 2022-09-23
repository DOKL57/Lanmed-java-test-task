package com.dokl57.taskmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void start()
    {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Socket socket = new Socket("localhost", 4001)) {
                    BufferedReader in
                            = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
                    while (true) {
                        if(in.readLine()!="") {
                            String reply = in.readLine();
                            LogUtils.getLogger().info("Server replied: " + reply);
                            if(Minecraft.getInstance().player!=null){
                                Minecraft.getInstance().player.sendSystemMessage(Component.literal(reply));
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }

    }
