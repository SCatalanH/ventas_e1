package s3.ventas;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    private List<Venta> ventas;

    public VentaController() {
        this.ventas = new ArrayList<>();
        // Agregar datos de ventas de ejemplo
        agregarVentasDeEjemplo();
    }

    // Método para agregar ventas de ejemplo
    private void agregarVentasDeEjemplo() {
        // Agregamos algunas ventas de ejemplo para probar los endpoints
        // Aquí se agregarían las ventas reales de la tienda
        this.ventas.add(new Venta(1, new Date(), 50.0));
        this.ventas.add(new Venta(2, new Date(), 30.0));
        this.ventas.add(new Venta(3, new Date(), 20.0));

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, -1); // Retrocede un día
    this.ventas.add(new Venta(4, cal.getTime(), 40.0));

    cal.add(Calendar.DAY_OF_MONTH, -1); // Retrocede otro día
    this.ventas.add(new Venta(5, cal.getTime(), 60.0));

    cal.add(Calendar.DAY_OF_MONTH, -1); // Retrocede otro día
    this.ventas.add(new Venta(6, cal.getTime(), 25.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(7, cal.getTime(), 35.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(8, cal.getTime(), 45.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(9, cal.getTime(), 55.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(10, cal.getTime(), 65.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(11, cal.getTime(), 75.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(12, cal.getTime(), 85.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(13, cal.getTime(), 95.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(14, cal.getTime(), 105.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(15, cal.getTime(), 115.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(16, cal.getTime(), 125.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(17, cal.getTime(), 135.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(18, cal.getTime(), 145.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(19, cal.getTime(), 155.0));

    cal.add(Calendar.DAY_OF_MONTH, -1);
    this.ventas.add(new Venta(20, cal.getTime(), 165.0));
    }

    // Endpoint para obtener todas las ventas
    @GetMapping("")
    public List<Venta> obtenerTodasLasVentas() {
        return this.ventas;
    }

    @GetMapping("/ventas-mensuales/{year}/{month}")
    public double calcularTotalVentasMensuales(@PathVariable int year, @PathVariable int month) {
        // Crear un objeto Calendar para el primer día del mes especificado
        Calendar calInicioMes = Calendar.getInstance();
        calInicioMes.set(year, month - 1, 1); // El mes en Calendar es 0-indexado, por lo que restamos 1
    
        // Crear un objeto Calendar para el último día del mes especificado
        Calendar calFinMes = Calendar.getInstance();
        calFinMes.set(year, month - 1, calFinMes.getActualMaximum(Calendar.DAY_OF_MONTH)); // Último día del mes
    
        // Sumar los montos de las ventas que ocurrieron en el mes especificado
        double totalVentasMensuales = 0.0;
        for (Venta venta : this.ventas) {
            Calendar calVenta = Calendar.getInstance();
            calVenta.setTime(venta.getFecha());
            if (calVenta.after(calInicioMes) && calVenta.before(calFinMes)) {
                totalVentasMensuales += venta.getMonto();
            }
        }
        return totalVentasMensuales;
    }
    

    // Endpoint para calcular el promedio de ventas diarias
    @GetMapping("/ventas-diarias/{year}/{month}/{day}")
public double calcularTotalVentasDiarias(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
    // Crear un objeto Calendar para la fecha especificada
    Calendar calConsulta = Calendar.getInstance();
    calConsulta.set(year, month - 1, day); // El mes en Calendar es 0-indexado, por lo que restamos 1
    
    // Sumar los montos de las ventas que ocurrieron en la fecha especificada
    double totalVentasDiarias = 0.0;
    for (Venta venta : this.ventas) {
        Calendar calVenta = Calendar.getInstance();
        calVenta.setTime(venta.getFecha());
        if (calVenta.get(Calendar.YEAR) == year &&
            calVenta.get(Calendar.MONTH) == month - 1 && // Restamos 1 porque el mes en Calendar es 0-indexado
            calVenta.get(Calendar.DAY_OF_MONTH) == day) {
            totalVentasDiarias += venta.getMonto();
        }
    }
    return totalVentasDiarias;
}


    @GetMapping("/ventas-anuales/{year}")
    public double calcularTotalVentasAnuales(@PathVariable int year) {
        // Sumar los montos de las ventas que ocurrieron en el año especificado
        double totalVentasAnuales = 0.0;
        for (Venta venta : this.ventas) {
            Calendar calVenta = Calendar.getInstance();
            calVenta.setTime(venta.getFecha());
            if (calVenta.get(Calendar.YEAR) == year) {
                totalVentasAnuales += venta.getMonto();
            }
        }
        return totalVentasAnuales;
    }
    
}
