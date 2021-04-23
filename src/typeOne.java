import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class typeOne extends JFrame{
    private drawingPanel dp;
    private short [][] pixels;
    int fileType,width,height;
    typeOne(){
        readFile(); // pixels arrayimiz dolmuş olacak drawingPanel çalışmadan önce.
        dp=new drawingPanel();
        
       
        
        this.setContentPane(dp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
    }
    void readFile(){
         try {
            Scanner inFile=new Scanner(new File("baboon.txt"));
            fileType=inFile.nextInt();
            width=inFile.nextInt();
             height=inFile.nextInt();
            //System.out.printf("type:%d\n width:%d\n height:%d",fileType,width,height);
            
            
            pixels=new short[width][height];
            
            for(int row=0;row<height;row++){
                for(int col=0;col<width;col++){
                    pixels [row][col]=inFile.nextShort();
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(typeOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // inner class
    class drawingPanel extends JPanel{
        
      @Override
      public void paintComponent(Graphics g){
         for(int row=0;row<height;row++){
                for(int col=0;col<width;col++){
                    g.setColor(new Color(pixels[row][col],pixels[row][col],pixels[row][col]));
                   g.fillRect(col, row, 1, 1);
                }
            }
      }
    }
    
    public static void main(String[] args) {
        new typeOne();
    }
}
