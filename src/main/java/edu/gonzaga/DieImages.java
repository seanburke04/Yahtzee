//Crandall wrote some of this
package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DieImages {
    //General path
    private String workingDirectory = System.getProperty("user.dir");
    private String navigate = "/src/media/Dice";
    private String diceFolder = workingDirectory + navigate;
    private ArrayList<ImageIcon> images;

    public DieImages(){
        images = new ArrayList<>(12);
        loadImages();
    }

    public ImageIcon getImages(int dieValue){
        return images.get(dieValue);
    }

    private void loadImages(){
        BufferedImage currentPicture;
        images.add(null);
        for(int i = 1; i < 7; i++){
            try{
                String filename = diceFolder + "/D6-0" + i + ".png";
                currentPicture = ImageIO.read(new File(filename));
                Image dieImage = currentPicture.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(dieImage);
                images.add(scaledImage);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
