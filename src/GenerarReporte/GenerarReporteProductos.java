import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GenerarReporteProductos {
    public static void generarReporteProductos(HashMap<Integer, Producto> productos, String rutaSalida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
            List<Producto> listaProductos = productos.values().stream()
                .sorted(Comparator.comparingDouble(Producto::calcularTotalVendido).reversed())
                .collect(Collectors.toList());

            for (Producto producto : listaProductos) {
                writer.write(producto.getFormatoReporte());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
