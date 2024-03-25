package s3.ventas;
import java.util.Date;

public class Venta {
    private int id;
    private Date fecha;
    private double monto;

    public Venta(int id, Date fecha, double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

}