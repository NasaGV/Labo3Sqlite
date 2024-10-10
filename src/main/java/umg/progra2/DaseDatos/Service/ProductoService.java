package umg.progra2.DaseDatos.Service;



import umg.progra2.DaseDatos.Dao.ProductoDAO;
import umg.progra2.DaseDatos.model.Producto;

import java.sql.SQLException;
import java.util.List;

public class ProductoService {
    private ProductoDAO productoDAO;

    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }

    public void crearProducto(Producto producto) throws SQLException {
        productoDAO.insertar(producto);
    }

    public Producto obtenerProducto(int id) throws SQLException {
        return productoDAO.obtenerPorId(id);
    }

    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        return productoDAO.obtenerTodos();
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        productoDAO.actualizar(producto);
    }

    public void eliminarProducto(int id) throws SQLException {
        productoDAO.eliminar(id);
    }
}
