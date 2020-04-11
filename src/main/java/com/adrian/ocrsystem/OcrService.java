package com.adrian.ocrsystem;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

@Service
public class OcrService {

    public  String doOcr(String url) {

        try {
            URL urlImage = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(urlImage);

            ITesseract iTesseract = new Tesseract();
            iTesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getParent());
            iTesseract.setLanguage("eng");

            return iTesseract.doOCR(bufferedImage);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return "";
    }
}
