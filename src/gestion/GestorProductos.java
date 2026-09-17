/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;
import java.util.TreeSet;
import modelo.Producto;
/**
 *
 * @author verit
 */
public class GestorProductos {
    private TreeSet<Producto> productos;
    public GestorProductos() {
        productos = new TreeSet<>();
    }
    public TreeSet<Producto> getProductos() {
        return productos;
    }
    public boolean agregarProducto(Producto producto) {
        return productos.add(producto);
    }
    public boolean eliminarProducto(int codigo) {
        Producto producto = buscarPorCodigo(codigo);
        if (producto != null) {
            return productos.remove(producto);
        }
        return false;
    }
    public Producto buscarPorCodigo(int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }
    public boolean actualizarProducto(Producto productoNuevo) {
        Producto productoAnterior = buscarPorCodigo(productoNuevo.getCodigo());
        if (productoAnterior != null) {
            productos.remove(productoAnterior);
            productos.add(productoNuevo);
            return true;
        }
        return false;
    }
    public TreeSet<Producto> buscarPorNombre(String texto) {
        TreeSet<Producto> resultado = new TreeSet<>();
        for (Producto producto : productos) {
            if (producto.getDescripcion().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(producto);
            }
        }
        return resultado;
    }
    public TreeSet<Producto> buscarPorPrecio(double minimo, double maximo) {
        TreeSet<Producto> resultado = new TreeSet<>();
        for (Producto producto : productos) {
            if (producto.getPrecio() >= minimo && producto.getPrecio() <= maximo) {
                resultado.add(producto);
            }
        }
        return resultado;
    }
    public TreeSet<Producto> buscarPorRubro(String rubro) {
        TreeSet<Producto> resultado = new TreeSet<>();
        for (Producto producto : productos) {
            if (producto.getRubro().equalsIgnoreCase(rubro)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }
}

