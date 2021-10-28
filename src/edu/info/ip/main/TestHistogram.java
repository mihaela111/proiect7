package edu.info.ip.main;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class TestHistogram {
    public static void main(String[] args) {

        BufferedImage inputImg= loadImage("./test_images/lena_color_512.bmp");

        displayImage(inputImg, "Original image");

        displayImage(histogramImage(inputImg,0,256,150),"RED");
        displayImage(histogramImage(inputImg,1,256,150),"GREEN");
        displayImage(histogramImage(inputImg,2,256,150),"BLUE");

        BufferedImage grayImg = colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_PAL);
        displayImage(grayImg, "Gray");

        displayImage(histogramImage(grayImg,0,256,150),"LUMINOSITY");

        BufferedImage contrastStretchImg = contrastStretch(grayImg);
        displayImage(contrastStretchImg, "Gray ContrastStretch");

        displayImage(histogramImage(contrastStretchImg,0,256,150),"LUMINOSITY");


    }
}
