import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnirPdf {

    public static void mergePDFFiles(List<File> files, String mergedFileName) {

        try {
            PDFMergerUtility pdfmerger = new PDFMergerUtility();
            for (File file : files) {
                PDDocument document = PDDocument.load(file);
                pdfmerger.setDestinationFileName(mergedFileName);
                pdfmerger.addSource(file);
                pdfmerger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
                document.close();
            }
        } catch (IOException e) {
            System.out.println("Error to merge files. Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String directorioInicial = "src\\main\\resources\\Ninos";
        String directorioFinal = "src\\main\\resources\\NinosFinal";
        File carpeta = new File(directorioInicial);

        List<String> listado = Arrays.asList(carpeta.list());
        for (String l : listado) {
            File docNino = new File(directorioInicial + "\\" + l);
            List<String> documentosNino = Arrays.asList(docNino.list());
            List<File> inputPdfList2 = new ArrayList<File>();
            int index = 1;
            for (String doc : documentosNino) {
                File val = new File(docNino.getPath() + "\\" + "a" + index + ".pdf");
                if (val.isFile()) {
                    inputPdfList2.add(new File(val.getPath()));
                }
                index++;
            }
            File carpetaFinal = new File(directorioFinal + "\\" + l);
            carpetaFinal.mkdir();
            mergePDFFiles(inputPdfList2, directorioFinal + "\\" + l + "\\" + l + ".pdf");
        }
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
        System.out.println(" ♥♥♥♥♥♥♥♥Listo amor acabamos♥♥♥♥♥♥♥♥");
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
        System.out.println("--------------♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥----------");
    }


}
