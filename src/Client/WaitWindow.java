package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitWindow extends JPanel {
    JButton startBtn;
    static MainWindow window;

    static ActionListener startBtnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 매칭시작 버튼 눌렸을 때
            System.out.println("MatchStart Btn Clicked");
        }
    };

    WaitWindow(MainWindow window) {
        this.window = window;
        setLayout(new BorderLayout());

        startBtn = new JButton("매칭시작");
        startBtn.setFont(startBtn.getFont().deriveFont(Font.BOLD, 20.0F));
        startBtn.addActionListener(startBtnListener);
        add(startBtn, BorderLayout.CENTER);
    }
}
