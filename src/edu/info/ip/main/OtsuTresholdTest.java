package edu.info.ip.main;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class OtsuTresholdTest {

    public static void main(String[] args) {
        BufferedImage inputImg= loadImage("./test_images/lena_gray_512.bmp");

        displayImage(inputImg, "Original image");

        int otsuThreshold = otsuTreshold(inputImg);

        displayImage(threshold(inputImg,otsuThreshold), "OtsuThreshold: " + otsuThreshold);

    }

}
