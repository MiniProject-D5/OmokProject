package Client;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    String windowName;
    LoginWindow login;
    SignupWindow signup;
    WaitWindow wait;
    GameWindow game;

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
}
