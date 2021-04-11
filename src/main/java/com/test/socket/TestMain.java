package com.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author langyonghe
 * @date 2021/3/26 15:59
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        SocketConfiguration socketConfiguration = new SocketConfiguration();
        Socket socket = SocketUtils.createSocket(InetSocketAddress.createUnresolved("localhost", 9091), socketConfiguration);
        InputStream is = socket.getInputStream();
        InputStreamReader isr =new InputStreamReader(is,"utf-8");
        BufferedReader br =new BufferedReader(isr);
        try {
            while ((br.read())!=-1) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
