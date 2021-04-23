
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class typeTwo extends JFrame {
    private DrawingPanel dp;
    private short[][] pixels;
    private int width, height;

    typeTwo() throws FileNotFoundException {
        readFile();
        dp = new DrawingPanel();

        this.setContentPane(dp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(3000, 3000);
        this.setVisible(true);
    }

    void readFile() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("bitText.txt"));
        int fileType = inFile.nextInt();
        width = inFile.nextInt();
        height = inFile.nextInt();
        System.out.printf("File Type: %d, width: %d, height: %d\n", fileType, width, height);
        pixels = new short[5000][5000];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixels[row][col] = inFile.nextShort();
            }
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        new typeTwo();
    }
    class DrawingPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (pixels[row][col]==0) {
                        g.setColor(new Color(1, 1, 1));
                    }
                    else
                    {
                        g.setColor(new Color(255,255,255));
                    }
                    g.fillRect(col, row, 1, 1);
                }
            }
        }

    }
}
