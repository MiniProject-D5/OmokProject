package Client;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class MainWindow extends JFrame {

    String windowName;
    LoginWindow login;
    SignupWindow signup;
    WaitWindow wait;
    GameWindow game;
    String message;


    MainWindow() {
        setLayout(new FlowLayout());
        change("login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void change(String name) {
        windowName = name;
        getContentPane().removeAll();
        if (name.equals("login")) {
            login = new LoginWindow(this);
            login.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            add(login);
            pack();
        }
        if (name.equals("signup")) {
            signup = new SignupWindow(this);
            signup.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            add(signup);
            pack();
        }
        if (name.equals("wait")) {
            wait = new WaitWindow(this);
            wait.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
            add(wait);
            pack();
        }
        if (name.equals("game")) {
            game = new GameWindow(this);
            setSize(800, 800);
            setResizable(false);
            add(game);
        }
    }

    public String client_socket(String str) throws IOException {
        Socket s = null;
        DataInputStream dis;
        System.out.println("[클라이언트 연결됨]");
        try {
            s = new Socket("localhost",8000);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            bw.write(str+"\n");
            bw.flush();
            dis = new DataInputStream(s.getInputStream());
            message = dis.readUTF();
            System.out.println("inputMessage : " + message);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                s.close(); //클라이언트 소켓 종료
            } catch (Exception e) {
                System.out.println("Server 채팅 중 오류 발생..............");
            }
        }
        return message;
    }

}
