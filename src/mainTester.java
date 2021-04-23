
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class mainTester extends JFrame{
    public SimplePhotosop photosop;
   
    public mainTester(SimplePhotosop photo){
         this.photosop=photo;
    }
    public void executeStrategy(){
        photosop.openFile();
    }

    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan=new Scanner(System.in);
        System.out.println("please enter type of image :");
        int type=scan.nextInt();
        switch(type){
            case 1:
                type1 t1=new type1();
                t1.openFile();
                break;
            case 2:
                type2 t2=new type2();
                t2.openFile();
                break;
            case 3:
                type3 t3=new type3();
                t3.openFile();
                break;
            case 5:
                type5 t5=new type5();
                t5.openFile();
                break;
            case 6:
                type6 t6=new type6();
                t6.openFile();
                break;
        }
       
        
        
    }
    
    
}

interface SimplePhotosop{
   public void openFile();
}
class type1 extends JPanel implements SimplePhotosop{
    static short[][] pixels;
    static int width, height;
    @Override
    public void openFile() {
        try {
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(type1.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jFrame = new JFrame();
        type1 main = new type1();
        jFrame.add(main);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(512, 512);
        jFrame.setVisible(true);
    } 
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
class  type2 extends JPanel implements SimplePhotosop {
    static short [][] pixels;
    static int height,width,fileType;
    @Override
    public void openFile() {
        try {
         Scanner   inFile = new Scanner(new File("baboon.txt"));
         fileType = inFile.nextInt();
         width=inFile.nextInt();
         height=inFile.nextInt();
         pixels=new short[width][height];
            
            for(int row=0;row<height;row++){
                for(int col=0;col<width;col++){
                    pixels [row][col]=inFile.nextShort();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(type2.class.getName()).log(Level.SEVERE, null, ex);
        }    
        JFrame jFrame = new JFrame();
        type2 main = new type2();
        jFrame.add(main);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(512, 512);
        jFrame.setVisible(true);
    } 
        
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

 

class type3 extends JPanel implements SimplePhotosop{
    static short[][] pixelsR;
    static short[][] pixelsG;
    static short[][] pixelsB;
    static int width, height;
    @Override
    public void openFile() {
        try {
            Scanner inFile = new Scanner(new File("colorText.txt"));
            int fileType = inFile.nextInt(); 
            width = inFile.nextInt(); 
            height = inFile.nextInt(); 
            System.out.printf("File Type: %d, width: %d, height: %d\n", fileType, width, height);
            pixelsR = new short[200][800];
            pixelsG = new short[200][800];
            pixelsB = new short[200][800];
            
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    pixelsR[row][col] = inFile.nextShort();
                    pixelsG[row][col] = inFile.nextShort();
                    pixelsB[row][col] = inFile.nextShort();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(type3.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jFrame = new JFrame();
        type3 main = new type3();
        jFrame.add(main);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(512, 512);
        jFrame.setVisible(true);
    } 
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

class type5 extends JPanel implements SimplePhotosop{
    static int[] imageByte;
     
    static  int width;
    static  int height;
    static  int range;
    @Override
    public void openFile() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("type5.advprog"));
            int fileType = fis.read();
            width = 0;
            height = 0;
            range = 0;
            int readByte = fis.read();
            for (int i = 0; i < 3;i++){
                String readValue = "";
                while(Character.isWhitespace(readByte)) {
                    readByte = fis.read();
                }
                while(!Character.isWhitespace(readByte)) {
                    readValue = readValue + (readByte-'0');
                    readByte = fis.read();
                }
                if(i==0) {
                    width = Integer.parseInt(readValue);
                }
                else if(i==1){
                    height = Integer.parseInt(readValue);
                }else {
                    range = Integer.parseInt(readValue);
                }
            }
            System.out.println(fileType-48);
            System.out.println("W:"+width+" H:"+height+" Range:"+range);
            imageByte = new int[width*height];
            int k = 0;
            int b = fis.read();
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    imageByte[i*width+j]=fis.read();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(type5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(type5.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(type5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFrame jFrame = new JFrame();
        type5 main = new type5();
        jFrame.add(main);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(512, 512);
        jFrame.setVisible(true);
    }  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                g.setColor(new Color(imageByte[y*width+x],imageByte[y*width+x],imageByte[y*width+x]));
                g.fillRect(x, y, 1, 1);
            }
        }
    }
    
}
 class type6 extends JPanel implements SimplePhotosop{
    static  int[] imageByte;
    static  int[] imageByte2;
    static  int[] imageByte3;
    static  int width;
    static  int height;
    static  int range;
    @Override
    public void openFile() {
        
        try {
            FileInputStream fis = new FileInputStream(new File("type6.advprog"));
            int fileType = fis.read();
            width = 0;
            height = 0;
            range = 0;
            int readByte = fis.read();
            for (int i = 0; i < 3;i++){

                String readValue = "";
                while(Character.isWhitespace(readByte)) {
                    readByte = fis.read();
                }
                while(!Character.isWhitespace(readByte)) {
                    readValue = readValue + (readByte-'0');
                    readByte = fis.read();

                }

                if(i==0) {
                    width = Integer.parseInt(readValue);
                }
                else if(i==1){
                    height = Integer.parseInt(readValue);
                }else {
                    range = Integer.parseInt(readValue);
                }
            }
            System.out.println(fileType-48);
            System.out.println("W:"+width+" H:"+height+" Range:"+range);
            imageByte = new int[width*height];
            imageByte2 = new int[width*height];
            imageByte3= new int[width*height];
            int k = 0;
            int b = fis.read();
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    imageByte[i*width+j]=fis.read();
                    imageByte2[i*width+j]=fis.read();
                    imageByte3[i*width+j]=fis.read();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(type6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(type6.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        JFrame jFrame = new JFrame();
        type6 main = new type6();
        jFrame.add(main);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setSize(512, 512);
        jFrame.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x=0;x<width;x++) {
            for(int y=0;y<height;y++) {
                g.setColor(new Color(imageByte[y*width+x],imageByte2[y*width+x],imageByte3[y*width+x]));
                g.fillRect(x, y, 1, 1);

            }
        }
    }
}

