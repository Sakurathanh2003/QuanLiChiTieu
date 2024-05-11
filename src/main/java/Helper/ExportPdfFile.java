/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Coordinator.AppCoordinator;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.Font;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExportPdfFile {
    public void exportFile(String path, String[] headers, int numberOfColumn, String[] data) throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        
        try (Document document = new Document(pdfDocument)) {
     
            try {
                addTitlePage(document, "THỐNG KÊ\n");
                addLine(document);
                addNormalContent(document, "Username: " + AppCoordinator.getUsername() + "\n");
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" dd/MM/yyyy HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                addNormalContent(document, "Ngày tạo: " + dtf.format(now) + "\n");
                
                
                addLine(document);
                addEmptyLine(document);
                addTable(document, headers, numberOfColumn, data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            document.close();
        }
    }
    
    private static void addLine(Document document) throws IOException {
        Border border = new SolidBorder(ColorConstants.GRAY, 2f);
        Table divider = new Table(1).useAllAvailableWidth();
        divider.setBorder(border);
        document.add(divider);
    }
    
    private static void addTitlePage(Document document, String content) throws IOException {
        Paragraph title = new Paragraph(content);
        PdfFont font = PdfFontFactory.createFont("/fonts/vuTimesBold.ttf");
        title.setFont(font);
        title.setFontSize(20);
        title.setFontColor(ColorConstants.RED);
        document.add(title);
    }
    
    private static void addNormalContent(Document document, String content) throws IOException {
        Paragraph title = new Paragraph(content);
        PdfFont font = PdfFontFactory.createFont("/fonts/vuTimes.ttf");
        title.setFont(font);
        title.setFontSize(14);
        title.setFontColor(ColorConstants.BLACK);
        
        document.add(title);
    }
    
    private static void addTable(Document document, String[] headers, int numberOfColumn, String[] data) throws IOException {
        Table table = new Table(UnitValue.createPercentArray(numberOfColumn)).useAllAvailableWidth();
        PdfFont fontBold = PdfFontFactory.createFont("/fonts/vuTimesBold.ttf");
        PdfFont fontRegular = PdfFontFactory.createFont("/fonts/vuTimes.ttf");

        for (String header: headers) {
            Cell headerCell = new Cell().add(new Paragraph(header));
            headerCell.setFont(fontBold);
            headerCell.setFontSize(15);
            
            table.addCell(headerCell);
        }
        
        for (String text: data) {
            Cell cell = new Cell().add(new Paragraph(text));
            cell.setFont(fontRegular);
            cell.setFontSize(14);
            
            table.addCell(cell);
        }
        
        document.add(table);
    }
    
    private static void addEmptyLine(Document document) {
        Paragraph title = new Paragraph("\n");
        document.add(title);
    }
}
