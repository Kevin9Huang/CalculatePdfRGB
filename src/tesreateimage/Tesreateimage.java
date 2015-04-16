/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tesreateimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;


/**
 *
 * @author Kevin Huang
 */
public class Tesreateimage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       System.out.println("Hello World");
       convertPDFToImage("tes2.pdf");
    }
    public static void convertPDFToImage(String pdfFilename) throws IOException
    {
        PDDocument document = PDDocument.loadNonSeq(new File(pdfFilename), null);
        List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
        int page = 0;
        for (PDPage pdPage : pdPages)
        { 
            ++page;
            BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
            ImageIOUtil.writeImage(bim, "png", pdfFilename + "-" + page, 300);
        }
        document.close();
    }
}
