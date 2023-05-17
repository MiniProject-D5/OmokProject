package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JPanel {

    Container board;
    // GUI에 표현되는 이미지들을 저장하기 위한 배열
    ImageIcon[] images;
    // JButton을 상속받은 Cell클래스가 GUI에 추가
    // 해당 Cell인스턴스의 참조를 얻기위해 GUI에 위치한 순서대로 저장된 이차원배열
    Cell[][] cells;
    // 자신의 턴인지 확인하기 위한 boolean변수
    // 서버가 완성되면 서버의 메세지에 따라 변경되어야할듯...?
    boolean isTurn;

    MainWindow window;
    ActionListener boardClickListener;

    GameWindow(MainWindow window) {
        this.window = window;
        window.setTitle("오목판");
        cells = new Cell[15][15];
        getImages();
        System.out.println(images[0].getIconHeight());
        System.out.println(images[0].getIconWidth());
        isTurn = true;
        // 오목판이 클릭되었을때 실행되는 ActionListener
        // 서버와 연결되면 수정되어야함
        boardClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cell egg = (Cell)e.getSource();
                if (egg.state != 0) {
                    return;
                }
                if (isTurn) {
                    isTurn = false;
                    egg.state = 1;
                }
                else {
                    isTurn = true;
                    egg.state = 2;
                }
                egg.setIcon(getImageByInt(egg.row, egg.col));
            }
        };


        board = window.getContentPane();
        board.setLayout(new GridLayout(16,16));
        for (int i=0; i<15; i++) {
            for (int j=0; j<15; j++) {
                cells[i][j] = new Cell(i, j, getImageByInt(i, j));
                cells[i][j].addActionListener(boardClickListener);
                cells[i][j].setBorderPainted(false);
                board.add(cells[i][j]);
            }
        }
    }


    // 이미지파일을 사용하기 위해 images배열에 저장
    private void getImages() {
        String imageUrl = "Client/Resource";
        images = new ImageIcon[27];
        try {
            images[0] = new ImageIcon(imageUrl + "/top-left.png");
            images[1] = new ImageIcon(imageUrl + "/top-center.png");
            images[2] = new ImageIcon(imageUrl + "/top-right.png");
            images[3] = new ImageIcon(imageUrl + "/center-left.png");
            images[4] = new ImageIcon(imageUrl + "/center-center.png");
            images[5] = new ImageIcon(imageUrl + "/center-right.png");
            images[6] = new ImageIcon(imageUrl + "/bottom-left.png");
            images[7] = new ImageIcon(imageUrl + "/bottom-center.png");
            images[8] = new ImageIcon(imageUrl + "/bottom-right.png");

            images[9] = new ImageIcon(imageUrl + "/top-left-black.png");
            images[10] = new ImageIcon(imageUrl + "/top-center-black.png");
            images[11] = new ImageIcon(imageUrl + "/top-right-black.png");
            images[12] = new ImageIcon(imageUrl + "/center-left-black.png");
            images[13] = new ImageIcon(imageUrl + "/center-center-black.png");
            images[14] = new ImageIcon(imageUrl + "/center-right-black.png");
            images[15] = new ImageIcon(imageUrl + "/bottom-left-black.png");
            images[16] = new ImageIcon(imageUrl + "/bottom-center-black.png");
            images[17] = new ImageIcon(imageUrl + "/bottom-right-black.png");

            images[18] = new ImageIcon(imageUrl + "/top-left-white.png");
            images[19] = new ImageIcon(imageUrl + "/top-center-white.png");
            images[20] = new ImageIcon(imageUrl + "/top-right-white.png");
            images[21] = new ImageIcon(imageUrl + "/center-left-white.png");
            images[22] = new ImageIcon(imageUrl + "/center-center-white.png");
            images[23] = new ImageIcon(imageUrl + "/center-right-white.png");
            images[24] = new ImageIcon(imageUrl + "/bottom-left-white.png");
            images[25] = new ImageIcon(imageUrl + "/bottom-center-white.png");
            images[26] = new ImageIcon(imageUrl + "/bottom-right-white.png");

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0; i<27; i++) {
            if (images[i] == null) {
                System.out.println(i+"번째 이미지 없음");
            }
        }
    }

    // row, col위치에 있는 GoEgg의 state를 이용하여 해당위치의 이미지를 결정
    private ImageIcon getImageByInt(int row, int col) {
        int index;
        if (row == 0) {
            if (col == 0) {
                index = 0;
            }
            else if (col == 14) {
                index = 2;
            }
            else {
                index = 1;
            }
        }
        else if (row == 14) {
            if (col == 0) {
                index = 6;
            }
            else if (col == 14) {
                index = 8;
            }
            else {
                index = 7;
            }
        }
        else {
            if (col == 0) {
                index = 3;
            }
            else if (col == 14) {
                index = 5;
            }
            else {
                index = 4;
            }
        }
        Cell egg = cells[row][col];
        return images[(egg == null ? 0 : egg.state) * 9 + index];
    }

}
