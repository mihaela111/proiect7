package edu.info.ip.main;

import edu.info.ip.util.ThresholdDlg;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class MainTest {
    //test

    public static void main(String[] args) {

        BufferedImage inputImg= loadImage("./test_images/lena_gray_512.bmp");
        displayImage(inputImg, "Original image");

        displayImage(contrast(inputImg,1.5f), "Contrast");

        displayImage(contrastExpandare(inputImg, 10), "Contrast expandare");
        displayImage(contrastComprimare(inputImg), "Contrast comprimare");





    }

}
