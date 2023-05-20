import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EdgeDetection {
    //Main Method
    public static void main(String[] args) throws IOException {
        for(int i = 3; i < 4; i++){
            //Locate image to process (Must specify PATH here)
            String imagePath = "/Users/ethanpervere/Desktop/"+i+".jpg";
            BufferedImage img = ImageIO.read(new File(imagePath));
            //Notify User
            System.out.println("Image Found: " + imagePath);

            System.out.println("Detecting Edges ...");
            //Detect Edges
            detectEdges(img);
            //Notify User
            System.out.println("Writing the File ...");
            //Save the processed image (Must specify PATH here)
            ImageIO.write(img, "png", new File("/Users/ethanpervere/Desktop/"+i+".png"));
        }
    }
    //Detect Edges
    public static void detectEdges(BufferedImage img){
        Color newColor = Color.BLACK; //Choose the color of the edges
        Color black = Color.WHITE; //Choose background color
        //Loop through all pixels (Columun by columun)
        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){
                //Notify user of the current pixel be worked on
                System.out.println("Currently on pixel: (" + x + "," + y + ")");
                //Recieve the RGB values of the current pixel
                Color currentPixelColor = new Color(img.getRGB(x, y));
                if(x < img.getWidth() - 1){
                    //Recieve the RGB values of the adjacent pixel
                    Color nextPixelColor = new Color(img.getRGB(x+1, y));

                    int RED = currentPixelColor.getRed();
                    int BLUE = currentPixelColor.getBlue();
                    int GREEN = currentPixelColor.getGreen();

                    int RED2 = nextPixelColor.getRed();
                    int BLUE2 = nextPixelColor.getBlue();
                    int GREEN2 = nextPixelColor.getGreen();
                    //Check the difference between the RGB values recieved
                    if(RED2 - RED > 5){
                        if(BLUE2 - BLUE > 5){
                            if(GREEN2 - GREEN > 5){
                                //If values or more than 5 units apart, then mark the current pixel as an edge with the specifed color
                                img.setRGB(x, y, newColor.getRGB());
                            }
                        }
                    }
                }

                if(y < img.getHeight() - 1){
                    //Recieve the RGB values of the adjacent pixel
                    Color nextPixelColor = new Color(img.getRGB(x, y+1));

                    int RED = currentPixelColor.getRed();
                    int BLUE = currentPixelColor.getBlue();
                    int GREEN = currentPixelColor.getGreen();

                    int RED2 = nextPixelColor.getRed();
                    int BLUE2 = nextPixelColor.getBlue();
                    int GREEN2 = nextPixelColor.getGreen();
                    //Check the difference between the RGB values recieved
                    if(RED2 - RED > 5){
                        if(BLUE2 - BLUE > 5){
                            if(GREEN2 - GREEN > 5){
                                //If values or more than 5 units apart, then mark the current pixel as an edge with the specifed color
                                img.setRGB(x, y, newColor.getRGB());
                            }
                        }
                    }
                }
            }
        }

        for(int z = 0; z < img.getWidth(); z++){
            for(int e = 0; e < img.getHeight(); e++){
                if(img.getRGB(z, e) != newColor.getRGB()){
                    img.setRGB(z, e, black.getRGB());
                }
            }
        }
    }
}
