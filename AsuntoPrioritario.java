public class AsuntoPrioritario {
    private int idAsunto;
    private String descripcionAsunto;
    private String clienteReporta;
    private String horaReporte;
    private String empleadoAsignado;

    public AsuntoPrioritario(int idAsunto, String descripcionAsunto, String clienteReporta, String horaReporte, String empleadoAsignado) {
        this.idAsunto = idAsunto;
        this.descripcionAsunto = descripcionAsunto;
        this.clienteReporta = clienteReporta;
        this.horaReporte = horaReporte;
        this.empleadoAsignado = empleadoAsignado;
    }

    
    public int getIdAsunto() {
        return idAsunto;
    }

    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

    public String getClienteReporta() {
        return clienteReporta;
    }

    public String getHoraReporte() {
        return horaReporte;
    }

    public String getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    @Override
    public String toString() {
        return "Asunto Prioritario [ID=" + idAsunto + ", Asunto=" + descripcionAsunto + ", Reporta=" + clienteReporta + ", Reporte=" + horaReporte + ", Atiende=" + empleadoAsignado + "]";
    }
}



