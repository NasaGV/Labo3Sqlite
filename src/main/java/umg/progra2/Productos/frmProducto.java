package umg.progra2.Productos;

import umg.progra2.DaseDatos.Service.ProductoService;
import umg.progra2.DaseDatos.model.Producto;
import umg.progra2.reportes.PdfReport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmProducto {
    private JPanel JPanel;
    private JTextField textFieldID;
    private JTextField textFieldDescripcion;
    private JComboBox comboBoxOrigen;
    private JTextField textFieldPrecio;
    private JTextField textFieldCantidad;
    private JButton buttonGuardar;
    private JButton ButtonActualizar;
    private JButton buttonEliminar;
    private JButton buttonLimpiar;
    private JButton buttonReporte;
    private JButton buttonBuscar;


    public frmProducto() {

        comboBoxOrigen.addItem("China");
        comboBoxOrigen.addItem("Japón");
        comboBoxOrigen.addItem("Corea del Sur");
        comboBoxOrigen.addItem("Estados Unidos");
        comboBoxOrigen.addItem("México");
        comboBoxOrigen.addItem("España");
        comboBoxOrigen.addItem("Argentina");
        comboBoxOrigen.addItem("Vietnam");
        comboBoxOrigen.addItem("Colombia");
        comboBoxOrigen.addItem("Italia");
        comboBoxOrigen.addItem("Suiza");
        comboBoxOrigen.addItem("Noruega");
        comboBoxOrigen.addItem("Suecia");
        comboBoxOrigen.addItem("Francia");
        comboBoxOrigen.addItem("Irlanda");
        comboBoxOrigen.addItem("Alemania");
        comboBoxOrigen.addItem("Escocia");
        comboBoxOrigen.addItem("Perú");
        comboBoxOrigen.addItem("Guatemala");
        comboBoxOrigen.addItem("Brasil");


        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();

            }
        });


        ButtonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();

            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();

            }
        });

        buttonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();

            }
        });

        buttonReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReportePDF();

            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();

            }
        });
    }
    private void guardarProducto() {
        try {
            double precio = Double.parseDouble(textFieldPrecio.getText());
            int cantidad = Integer.parseInt(textFieldCantidad.getText());

            Producto producto = new Producto();
            producto.setDescripcion(textFieldDescripcion.getText());
            producto.setOrigen((String) comboBoxOrigen.getSelectedItem());
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);

            new ProductoService().crearProducto(producto);
            JOptionPane.showMessageDialog(JPanel, "Producto guardado correctamente.");
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JPanel, "Error al guardar el producto. Asegúrate de que los valores sean correctos.");
        }
    }

    private void actualizarProducto() {
        try {
            int id = Integer.parseInt(textFieldID.getText());
            double precio = Double.parseDouble(textFieldPrecio.getText());
            int cantidad = Integer.parseInt(textFieldCantidad.getText());

            Producto producto = new ProductoService().obtenerProducto(id);
            if (producto != null) {
                producto.setDescripcion(textFieldDescripcion.getText());
                producto.setOrigen((String) comboBoxOrigen.getSelectedItem());
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);

                new ProductoService().actualizarProducto(producto);
                JOptionPane.showMessageDialog(JPanel, "Producto actualizado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(JPanel, "Producto no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JPanel, "Error al actualizar el producto.");
        }
    }

    private void eliminarProducto() {
        try {
            int id = Integer.parseInt(textFieldID.getText());
            new ProductoService().eliminarProducto(id);
            JOptionPane.showMessageDialog(JPanel, "Producto eliminado correctamente.");
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JPanel, "Error al eliminar el producto.");
        }
    }

    private void limpiarCampos() {
        textFieldID.setText("");
        textFieldDescripcion.setText("");
        textFieldPrecio.setText("");
        textFieldCantidad.setText("");
        comboBoxOrigen.setSelectedIndex(0);
    }

    private void generarReportePDF() {
        try {
            List<Producto> productos = new ProductoService().obtenerTodosLosProductos();
            String outputPath = "C:\\tmp\\ReporteProductos.pdf";
            new PdfReport().generateProductReport(productos, outputPath);
            JOptionPane.showMessageDialog(JPanel, "Reporte generado exitosamente en " + outputPath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JPanel, "Error al generar el reporte PDF.");
        }
    }

    private void buscarProducto() {
        try {
            int id = Integer.parseInt(textFieldID.getText());
            Producto producto = new ProductoService().obtenerProducto(id);
            if (producto != null) {
                textFieldDescripcion.setText(producto.getDescripcion());
                comboBoxOrigen.setSelectedItem(producto.getOrigen());
                textFieldPrecio.setText(String.valueOf(producto.getPrecio()));
                textFieldCantidad.setText(String.valueOf(producto.getCantidad()));
                JOptionPane.showMessageDialog(JPanel, "Producto encontrado.");
            } else {
                JOptionPane.showMessageDialog(JPanel, "Producto no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(JPanel, "Por favor, ingresa un ID válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JPanel, "Error al buscar el producto.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new frmProducto().JPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}

