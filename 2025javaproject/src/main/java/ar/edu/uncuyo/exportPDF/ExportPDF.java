package ar.edu.uncuyo.exportPDF;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class ExportPDF {

    public void exportarPDF() {
        String url = "jdbc:postgresql://localhost:5432/BIKENZO";
        String user = "postgres";
        String password = "123e";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PDDocument document = new PDDocument();
            DatabaseMetaData metaData = conn.getMetaData();

            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            while (tables.next()) {
                String schema = tables.getString("TABLE_SCHEM");
                String table = tables.getString("TABLE_NAME");

                // Filtrar esquemas del sistema como 'pg_catalog' y 'information_schema'
                if (schema.equalsIgnoreCase("pg_catalog") || schema.equalsIgnoreCase("information_schema")) continue;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + schema + "." + table);

                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

                int y = 750;
                contentStream.beginText();
                contentStream.newLineAtOffset(50, y);
                contentStream.showText("Tabla: " + schema + "." + table);
                contentStream.endText();
                y -= 20;

                contentStream.setFont(PDType1Font.HELVETICA, 9);
                ResultSetMetaData rsmd = rs.getMetaData();

                while (rs.next()) {
                    if (y < 50) {
                        contentStream.close();
                        page = new PDPage(PDRectangle.A4);
                        document.addPage(page);
                        contentStream = new PDPageContentStream(document, page);
                        contentStream.setFont(PDType1Font.HELVETICA, 9);
                        y = 750;
                    }

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String col = rsmd.getColumnName(i);
                        String val = rs.getString(i);
                        if (val == null) val = "NULL";

                        contentStream.beginText();
                        contentStream.newLineAtOffset(50, y);
                        contentStream.showText(col + ": " + val);
                        contentStream.endText();
                        y -= 12;
                    }

                    contentStream.beginText();
                    contentStream.newLineAtOffset(50, y);
                    contentStream.showText("----------------------------------------");
                    contentStream.endText();
                    y -= 15;
                }

                rs.close();
                stmt.close();
                contentStream.close();
            }

            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            document.save("export_todas_tablas_" + fecha + ".pdf");
            document.close();

            System.out.println("PDF generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
