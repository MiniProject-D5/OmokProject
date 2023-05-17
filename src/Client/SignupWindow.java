package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static DB.CrudSql.IdInsert;

public class SignupWindow extends JPanel {

    JPanel idArea, pwArea, btnArea;
    JLabel id, pw;
    JTextField idField;
    JPasswordField pwField;
    JButton signUpBtn, cancelBtn, checkBtn;
    MainWindow window;
    ActionListener signUpBtnListener;
    ActionListener cancelBtnListener;
    ActionListener checkBtnListener;
    String message;

    SignupWindow(MainWindow window) {
        this.window = window;
        setLayout(new GridLayout(3,0));
        signUpBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idField.getText().length() == 0 || pwField.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "ID와 PASSWORD를 모두 입력해주세요.");
                } else {
                    try {
                        IdInsert(idField.getText(), String.valueOf(pwField.getPassword()));
                    } catch (Exception ee) {
                        JOptionPane.showMessageDialog(new JFrame(), "회원가입 실패");
                    } finally {
                        window.change("login");
                    }
                    System.out.println("Signup Btn Clicked");
                }
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

                try {
                    message = window.client_socket("SignUp checkBtn " +idField.getText());
                    if(message.equals("Success")){
                        JOptionPane.showMessageDialog(new JFrame(), "ID 사용 가능 합니다.");
                        signUpBtn.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(new JFrame(), "ID가 중복되었습니다.");
                        signUpBtn.setEnabled(false);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("checkBtn Btn Clicked");
            }
        };

        idArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idArea.add(id = new JLabel("아이디"));
        idArea.add(idField = new JTextField(20));
        idArea.add(checkBtn = new JButton("중복확인"));
        id.setPreferredSize(new Dimension(80,16));
        id.setHorizontalAlignment(0);
        id.setVerticalTextPosition(0);
        idField.setSize(200, 100);
        this.add(idArea);

        pwArea = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pwArea.add(pw = new JLabel("비밀번호"));
        pwArea.add(pwField = new JPasswordField(20));
        pw.setPreferredSize(new Dimension(80,16));
        pw.setHorizontalAlignment(0);
        pw.setVerticalTextPosition(0);
        pwField.setSize(200, 100);
        this.add(pwArea);

        btnArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnArea.add(signUpBtn = new JButton("회원가입"));
        btnArea.add(cancelBtn = new JButton("취소"));
        signUpBtn.setEnabled(false);
        checkBtn.addActionListener(checkBtnListener);
        signUpBtn.addActionListener(signUpBtnListener);
        cancelBtn.addActionListener(cancelBtnListener);
        this.add(btnArea);
    }
}
