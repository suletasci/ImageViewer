import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class typeThree extends JFrame {
    private DrawingPanel dp;
    private short[][] pixelsR;
    private short[][] pixelsG;
    private short[][] pixelsB;
    private int width, height;

    //Constructor for simple photoshop.
    typeThree() throws FileNotFoundException {

        readFile();
        dp = new DrawingPanel();

        this.setContentPane(dp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 250);
        this.setVisible(true);
    }

    void readFile() throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("colorText.txt"));
        int fileType = inFile.nextInt(); //2 olduğu için text file
        //stream binary base file için kullanılır.
        width = inFile.nextInt(); //2. satır
        height = inFile.nextInt(); //2. satır
        System.out.printf("File Type: %d, width: %d, height: %d\n", fileType, width, height);
        pixelsR = new short[200][800];
        pixelsG = new short[200][800];
        pixelsB = new short[200][800];


        //Her bir texteki numarayı row ve column a yazdırıyoruz.
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixelsR[row][col] = inFile.nextShort();
                pixelsG[row][col] = inFile.nextShort();
                pixelsB[row][col] = inFile.nextShort();

            }
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        new typeThree();
    }

    class DrawingPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    //Colors RGB
                    g.setColor(new Color(pixelsR[row][col],
                            pixelsG[row][col],
                            pixelsB[row][col]));
                    g.fillRect(col, row, 1, 1);
                }
            }
        }

    }
}
