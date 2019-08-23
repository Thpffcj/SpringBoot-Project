package cn.edu.nju.ch2;

/**
 * Created by thpffcj on 2019/8/23.
 */
public class ServerBoot {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }
}
