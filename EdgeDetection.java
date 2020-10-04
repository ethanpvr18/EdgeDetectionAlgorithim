import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EdgeDetection {
    public static void main(String[] args) throws IOException {
        for(int i = 3; i < 4; i++){
            String imagePath = "/Users/ethan/Desktop/"+i+".jpg";
            BufferedImage img = ImageIO.read(new File(imagePath));

            System.out.println("Image Found: " + imagePath);

            System.out.println("Detecting Edges ...");

            detectEdges(img);

            System.out.println("Writing the File ...");

            ImageIO.write(img, "png", new File("/Users/ethan/Desktop/"+i+".png"));
        }
    }

    public static void detectEdges(BufferedImage img){
        Color newColor = Color.BLACK;
        Color black = Color.WHITE;

        for(int x = 0; x < img.getWidth(); x++){
            for(int y = 0; y < img.getHeight(); y++){

                System.out.println("Currently on pixel: (" + x + "," + y + ")");

                Color currentPixelColor = new Color(img.getRGB(x, y));
                if(x < img.getWidth() - 1){
                    Color nextPixelColor = new Color(img.getRGB(x+1, y));

                    int RED = currentPixelColor.getRed();
                    int BLUE = currentPixelColor.getBlue();
                    int GREEN = currentPixelColor.getGreen();

                    int RED2 = nextPixelColor.getRed();
                    int BLUE2 = nextPixelColor.getBlue();
                    int GREEN2 = nextPixelColor.getGreen();

                    if(RED2 - RED > 5){
                        if(BLUE2 - BLUE > 5){
                            if(GREEN2 - GREEN > 5){
                                img.setRGB(x, y, newColor.getRGB());
                            }
                        }
                    }
                }

                if(y < img.getHeight() - 1){
                    Color nextPixelColor = new Color(img.getRGB(x, y+1));

                    int RED = currentPixelColor.getRed();
                    int BLUE = currentPixelColor.getBlue();
                    int GREEN = currentPixelColor.getGreen();

                    int RED2 = nextPixelColor.getRed();
                    int BLUE2 = nextPixelColor.getBlue();
                    int GREEN2 = nextPixelColor.getGreen();

                    if(RED2 - RED > 5){
                        if(BLUE2 - BLUE > 5){
                            if(GREEN2 - GREEN > 5){
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