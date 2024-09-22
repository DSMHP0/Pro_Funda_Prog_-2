import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LecturaVentas {
    public static void leerArchivoVentas(String rutaArchivo, HashMap<Long, Vendedor> vendedores, HashMap<Integer, Producto> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int idProducto = Integer.parseInt(partes[0]);
                int cantidadVendida = Integer.parseInt(partes[1]);

                if (productos.containsKey(idProducto)) {
                    Producto producto = productos.get(idProducto);
                    producto.agregarCantidadVendida(cantidadVendida);
                    double totalVenta = producto.calcularTotalVendido();
                    // Aquí deberías relacionar la venta con el vendedor adecuado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
