package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupWindow extends JPanel {

    JPanel idArea, pwArea, btnArea;
    JLabel id, pw;
    JTextField idField, pwField;
    JButton signUpBtn, cancelBtn, checkBtn;
    MainWindow window;
    ActionListener signUpBtnListener;
    ActionListener cancelBtnListener;
    ActionListener checkBtnListener;

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

        checkBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 중복확인 버튼 눌렸을때
            }
        };

        idArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idArea.add(id = new JLabel("아이디"));
        idArea.add(idField = new JTextField(20));
        idArea.add(checkBtn = new JButton("중복확인"));
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
        btnArea.add(signUpBtn = new JButton("회원가입"));
        btnArea.add(cancelBtn = new JButton("취소"));
        signUpBtn.addActionListener(signUpBtnListener);
        cancelBtn.addActionListener(cancelBtnListener);
        this.add(btnArea);
    }
}
