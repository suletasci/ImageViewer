


import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class typeSix extends JPanel {
    private static int[] imageByte;
     private static int[] imageByte2;
        private static int[] imageByte3;
     
    private static int width;
    private static int height;
    private static int range;

    public static void main(String[] args) {
	 
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
            System.out.println(fileType);
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


        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame jFrame = new JFrame();
        typeSix main = new typeSix();
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
