package edu.info.ip.main;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class MainTest {

    public static void main(String[] args) {
        BufferedImage inputImg= loadImage("./test_images/lena_color_512.bmp");
        displayImage(inputImg, "Original image");
        //displayImage(generateRandom(600,600),"Random Pixels");

//        displayImage(extractBand(inputImg, 'R'),"Red");
//        displayImage(extractBand(inputImg, 'G'),"Green");
//        displayImage(extractBand(inputImg, 'B'),"Blue");
        //displayImage(extractBand(inputImg, 'A'),"Alpha");

//        displayImage(extractBandV2(inputImg, 0),"Redv2");
//        displayImage(extractBandV2(inputImg, 1),"Greenv2");
//        displayImage(extractBandV2(inputImg, 2),"Bluev2");
        //displayImage(extractBandV2(inputImg, 3),"Alphav2");

//        displayImage(flipH(inputImg), "Flip H");
//        displayImage(flipV(inputImg), "Flip V");
//        displayImage(flipH(flipV(inputImg)), "Flip V+H");

        displayImage(simpleSaltPepperNoise(inputImg,0.03d));
    }
}
