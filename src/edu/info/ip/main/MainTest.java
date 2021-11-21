package edu.info.ip.main;

import edu.info.ip.util.ThresholdDlg;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class MainTest {
    //test

    public static void main(String[] args) {
//        BufferedImage inputImg= loadImage("./test_images/lena_color_512.bmp");
        BufferedImage inputImg= loadImage("./test_images/eight.bmp");
//        BufferedImage inputImg= loadImage("./test_images/lena_gray_512.bmp");
//        BufferedImage inputImg= loadImage("./test_images/logo.png");
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

//        displayImage(simpleSaltPepperNoise(inputImg,0.03d));

//        BufferedImage grayLevels = grayLevelGenerator(100,20,10,200);
//        displayImage(grayLevels);
//        saveImage(grayLevels,"./out_images/gray_level_100_20_10_200.png", "png");

//        displayImage(pixelate(inputImg,64));

//        displayImage(brightnessV1(inputImg,40), "Brightness V1");
//        displayImage(brightnessV2(inputImg,-40), "Brightness V2");
//        displayImage(brightnessV3(inputImg,40), "Brightness V3");
//
//        displayImage(contrast(inputImg,1.5f), "Contrast");

        // combined action
//        BufferedImage brightness = brightnessV3(inputImg, -40);
//        BufferedImage contrast = contrast(brightness, 1.5f);
//        displayImage(contrast, "Brightness+Contrast");

//        BufferedImage testImg = applySettingsDlg(inputImg, new BrightnessDlg());
//        displayImage(testImg);

//        displayImage(brightnessRGB(inputImg,255,255,0), "BrightnessRGB");

//        BufferedImage testImage = applySettingsDlg(inputImg, new BrightnessRGBDlg());
//        displayImage(testImage, "Brightness RGB");

//        displayImage(contrastGamma(inputImg, 0.5));

//        BufferedImage testImg = applySettingsDlg(inputImg, new GammaDlg());
//        displayImage(testImg, "Gamma Contrast");

//        displayImage(contrastStretch(inputImg));

//        displayImage(negativate(inputImg));

//        displayImage(colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_GREEN), "Green");
//        displayImage(colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_AVG), "AVG");
//        displayImage(colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_SQRT), "SQRT");
//        displayImage(colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_USUAL), "USUAL");
//        displayImage(colorToGray(inputImg, GrayTransforms.GRAY_TRANSFORMS_PAL), "PAL");

        BufferedImage grayImg, thresholdImg, contrastImg, negativeImg, maskedImg;

//        grayImg = colorToGray(inputImg,GrayTransforms.GRAY_TRANSFORMS_PAL);
//        displayImage(grayImg, "Gray PAL");

        contrastImg = contrastStretch(inputImg);
        displayImage(contrastImg, "Contrast Stretch");

//        thresholdImg = threshold(contrastImg, 40);
        thresholdImg = applySettingsDlg(contrastImg, new ThresholdDlg());
        displayImage(thresholdImg, "Threshold");

        negativeImg = negative(thresholdImg);
        displayImage(negativeImg, "Negative");

        maskedImg = applyMask(inputImg,negativeImg);
        displayImage(maskedImg,"Apply Mask");

        displayImage(contrastStretch(maskedImg));
    }

}
