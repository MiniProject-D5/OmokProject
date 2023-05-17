package Client;

import javax.swing.*;

public class Cell extends JButton {

    int row;
    int col;
    int state;

    public Cell(int row, int col, ImageIcon image) {
        super(image);
        this.row = row;
        this.col = col;
        this.state = 0;
    }
}
