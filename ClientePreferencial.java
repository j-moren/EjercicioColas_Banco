public class ClientePreferencial {
    private int idCliente;
    private String nombre;
    private String tipoTransaccion;
    private int edad;
    private String horaLlegada;
    private String motivoPreferencia;

    public ClientePreferencial(int idCliente, String nombre, String tipoTransaccion, int edad, String horaLlegada, String motivoPreferencia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
        this.edad = edad;
        this.horaLlegada = horaLlegada;
        this.motivoPreferencia = motivoPreferencia;
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

    public String getMotivoPreferencia() {
        return motivoPreferencia;
    }

    @Override
    public String toString() {
        return "Cliente Preferencial [ID=" + idCliente + ", Nombre=" + nombre + ", Transacción=" + tipoTransaccion + ", Edad=" + edad + ", Llegada=" + horaLlegada + ", Motivo=" + motivoPreferencia + "]";
    }
}
