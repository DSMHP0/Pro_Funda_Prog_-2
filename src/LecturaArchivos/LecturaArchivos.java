import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LecturaArchivos {
    public static HashMap<Long, Vendedor> leerArchivoVendedores(String rutaArchivo) {
        HashMap<Long, Vendedor> vendedores = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipoDocumento = partes[0];
                long numeroDocumento = Long.parseLong(partes[1]);
                String nombre = partes[2];
                String apellido = partes[3];
                Vendedor vendedor = new Vendedor(tipoDocumento, numeroDocumento, nombre, apellido);
                vendedores.put(numeroDocumento, vendedor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    public static HashMap<Integer, Producto> leerArchivoProductos(String rutaArchivo) {
        HashMap<Integer, Producto> productos = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int idProducto = Integer.parseInt(partes[0]);
                String nombreProducto = partes[1];
                double precioPorUnidad = Double.parseDouble(partes[2]);
                Producto producto = new Producto(idProducto, nombreProducto, precioPorUnidad);
                productos.put(idProducto, producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}