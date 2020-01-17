package com.mainMethod;

/**
 * @author yu.wenhua
 * @desc
 * @date 2020/1/16 20:17
 */
public class mainclass {
    public static void main(String[] args) {
        Send send = new Send();
        try {
            send.sendMsgToMQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
