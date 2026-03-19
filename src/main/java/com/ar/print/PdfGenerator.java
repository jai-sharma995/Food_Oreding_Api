package com.ar.print;

import java.io.FileOutputStream;
import com.ar.entity.Orders;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {

    public static void generate(Orders order) {
        try {
            String path = "orders/order_" + order.getId() + ".pdf";

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();

            doc.add(new Paragraph("Food Order Invoice"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Customer Name: " + order.getUser().getUsername()));
            doc.add(new Paragraph("Mobile: " + order.getUser().getMobileno()));
            doc.add(new Paragraph("Address: " + order.getUser().getAddress()));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Food Item: " + order.getFoodName()));
            doc.add(new Paragraph("Price: ₹ " + order.getPrice()));
            doc.add(new Paragraph("Order Time: " + order.getOrderTime()));

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
