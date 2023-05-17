package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JPanel{

    JPanel idArea, pwArea, btnArea;
    JLabel id, pw;
    JTextField idField, pwField;
    JButton loginBtn, signUpBtn;
    MainWindow window;
    ActionListener loginBtnListner;
    ActionListener signUpBtnListner;

    LoginWindow(MainWindow window) {
        this.window = window;
        setLayout(new GridLayout(3,0));
        loginBtnListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그인 버튼 눌렸을때
                System.out.println("login btn Clicked!");
            }
        };

        signUpBtnListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원가입 버튼 눌렷을 때
                if (window == null) {
                    return;
                }
                window.change("signup");
                System.out.println("signUp Btn Clicked!");
            }
        };


        idArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idArea.add(id = new JLabel("아이디"));
        idArea.add(idField = new JTextField(20));
        id.setPreferredSize(new Dimension(44,16));
        id.setHorizontalAlignment(0);
        id.setVerticalTextPosition(0);
        idField.setSize(200, 100);
        this.add(idArea);

        pwArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pwArea.add(pw = new JLabel("비밀번호"));
        pwArea.add(pwField = new JTextField(20));
        pw.setPreferredSize(new Dimension(44,16));
        pw.setHorizontalAlignment(0);
        pw.setVerticalTextPosition(0);
        pwField.setSize(200, 100);
        this.add(pwArea);

        btnArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnArea.add(loginBtn = new JButton("로그인"));
        btnArea.add(signUpBtn = new JButton("회원가입"));
        loginBtn.addActionListener(loginBtnListner);
        signUpBtn.addActionListener(signUpBtnListner);
        this.add(btnArea);
    }
}
