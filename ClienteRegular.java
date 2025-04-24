public class ClienteRegular {
    private int idCliente;
    private String nombre;
    private String tipoTransaccion;
    private int edad;
    private String horaLlegada;

    public ClienteRegular(int idCliente, String nombre, String tipoTransaccion, int edad, String horaLlegada) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
        this.edad = edad;
        this.horaLlegada = horaLlegada;
    }

    
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public int getEdad() {
        return edad;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    @Override
    public String toString() {
        return "Cliente Regular [ID=" + idCliente + ", Nombre=" + nombre + ", Transacción=" + tipoTransaccion + ", Edad=" + edad + ", Llegada=" + horaLlegada + "]";
    }
}
