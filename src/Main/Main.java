
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Rutas absolutas para los archivos
        String rutaVendedores = "C:\\Users\\DAVID\\OneDrive\\Documentos\\NetBeansProjects\\FUNDA_PROGR_2\\vendedores.txt";
        String rutaProductos = "C:\\Users\\DAVID\\OneDrive\\Documentos\\NetBeansProjects\\FUNDA_PROGR_2\\productos.txt";
        String rutaVentas = "C:\\Users\\DAVID\\OneDrive\\Documentos\\NetBeansProjects\\FUNDA_PROGR_2\\ventas.txt";

        HashMap<Long, Vendedor> vendedores = LecturaArchivos.leerArchivoVendedores(rutaVendedores);
        HashMap<Integer, Producto> productos = LecturaArchivos.leerArchivoProductos(rutaProductos);
        LecturaVentas.leerArchivoVentas(rutaVentas, vendedores, productos);

        // Generar reportes
        GenerarReporte.generarReporteVendedores(vendedores, "reporte_vendedores.csv");
        GenerarReporteProductos.generarReporteProductos(productos, "reporte_productos.csv");
    }
}