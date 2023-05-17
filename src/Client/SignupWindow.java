package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupWindow extends JPanel {

    JPanel idArea, pwArea, btnArea;
    JLabel id, pw;
    JTextField idField, pwField;
    JButton signUpBtn, cancelBtn;
    MainWindow window;
    ActionListener signUpBtnListener;
    ActionListener cancelBtnListener;

    SignupWindow(MainWindow window) {
        this.window = window;
        setLayout(new GridLayout(3,0));
        signUpBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원가입 버튼이 눌렸을때
                System.out.println("Signup Btn Clicked");
            }
        };
        cancelBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 취소버튼이 눌렸을 때
                if (window == null) {
                    return;
                }
                window.change("login");
                System.out.println("Cancel Btn Clicked!");
            }
        };

        idArea = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        idArea.add(id = new JLabel("아이디"));
        idArea.add(idField = new JTextField(20));
        id.setSize(80, 100);
        idField.setSize(200, 100);
        this.add(idArea);

        pwArea = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pwArea.add(pw = new JLabel("비밀번호"));
        pwArea.add(pwField = new JTextField(20));
        pw.setSize(80, 100);
        pwField.setSize(200, 100);
        this.add(pwArea);

        btnArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnArea.add(signUpBtn = new JButton("회원가입"));
        btnArea.add(cancelBtn = new JButton("취소"));
        signUpBtn.addActionListener(signUpBtnListener);
        cancelBtn.addActionListener(cancelBtnListener);
        this.add(btnArea);
    }
}
