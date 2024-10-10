package umg.progra2.reportes;

import umg.progra2.DaseDatos.Service.ProductoService;
import umg.progra2.DaseDatos.model.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class
pruebas {

    public  static  void main (String [] arg) {
        try {
            List<Producto> prod = new ProductoService().obtenerTodosLosProductos();
            new PdfReport().generateProductReport(prod, "C:\\tmp\\report.pdf" );

            JOptionPane.showMessageDialog(null, "Reporte finalizado exitosamente en C:\\tmp\\report.pdf");

        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
