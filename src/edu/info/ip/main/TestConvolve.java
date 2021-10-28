package edu.info.ip.main;

import java.awt.image.BufferedImage;
import java.awt.image.Kernel;

import static edu.info.ip.util.ImageUtil.*;

public class TestConvolve {
    public static void main(String[] args) {
        BufferedImage inputImg= loadImage("./test_images/lena_color_512.bmp");
//        BufferedImage inputImg= loadImage("./test_images/rice.bmp");
        displayImage(inputImg, "Original image");

        float[] avg = { 0.11f, 0.11f, 0.11f,
                        0.11f, 0.11f, 0.11f,
                        0.11f, 0.11f, 0.11f};

        float[] sharpening = {  0.0f, -1.0f, 0.00f,
                                -1.0f, 5.0f, -1.0f,
                                0.0f, -1.0f, 0.0f};

        float[] edge = { 0.0f, -1.0f, 0.00f,
                        -1.0f, 4.0f, -1.0f,
                         0.0f, -1.0f, 0.0f};

        int kSize = 31;
        float[] avg2 = new float[kSize*kSize];
        for (int i = 0; i < kSize*kSize; i++) {
            avg2[i] = 1.0f/(kSize*kSize);
        }

        Kernel kernel1 = new Kernel(3,3, avg);
        Kernel kernel2 = new Kernel(kSize, kSize, avg2);

//        displayImage(convolutionSimple(inputImg, kernel1), "AVG 3x3");

        displayImage(convolutionSimple(inputImg, kernel2), "AVG " + kSize + "x" + kSize);
        displayImage(convolution(inputImg, kernel2), "AVG " + kSize + "x" + kSize);

//        displayImage(convolutionSimple(inputImg, new Kernel(3,3, sharpening)), "Sharpening 3x3");
//
//        BufferedImage blurImg = convolutionSimple(inputImg, new Kernel(3,3,avg));
//        BufferedImage grayImg = colorToGray(blurImg, GrayTransforms.GRAY_TRANSFORMS_PAL);
//        BufferedImage edgeImg = convolutionSimple(grayImg, new Kernel(3,3, edge));
//        displayImage(edgeImg, "Edge 3x3");
//
//        BufferedImage contrastImg = contrastStretch(edgeImg);
//        displayImage(contrastImg, "Contrast Stretch");
    }
}
