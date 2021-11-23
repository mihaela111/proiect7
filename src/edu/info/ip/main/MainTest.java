package edu.info.ip.main;

import edu.info.ip.util.BrightnessRGBDlg;
import edu.info.ip.util.ContrastCompressDlg;
import edu.info.ip.util.ContrastExpandDlg;
import edu.info.ip.util.ThresholdDlg;

import java.awt.image.BufferedImage;

import static edu.info.ip.util.ImageUtil.*;

public class MainTest {


    public static void main(String[] args) {

       BufferedImage inputImg= loadImage("./test_images/lena_gray_512.bmp");
       // displayImage(inputImg, "Original image");

       // displayImage(contrast(inputImg,1.5f), "Contrast");



       // displayImage(contrastExpandare(inputImg, 3), "Contrast expandare");
      //  BufferedImage testImage = applySettingsDlg(inputImg, new BrightnessRGBDlg());
        BufferedImage testImage = applySettingsDlg(inputImg, new ContrastExpandDlg());
        displayImage(testImage, "Contrast Expandare");
       BufferedImage testImagec = applySettingsDlg(inputImg, new ContrastCompressDlg());
      displayImage(testImage, "Contrast Comprimare");







    }

}
