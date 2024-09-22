import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerarReporte {
    public static void generarReporteVendedores(HashMap<Long, Vendedor> vendedores, String rutaSalida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
            List<Map.Entry<Long, Vendedor>> listaVendedores = vendedores.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparingDouble(v -> v.getValue().getTotalVentas())))
                .collect(Collectors.toList());

            for (Map.Entry<Long, Vendedor> entry : listaVendedores) {
                Vendedor vendedor = entry.getValue();
                writer.write(vendedor.getFormatoReporte());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
