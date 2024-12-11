class Venta {
    private Vendedor vendedor;
    private double ganancia;

    public Venta(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.ganancia = 0;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public Vendedor getVendedor() { return vendedor; }
    public double getGanancia() { return ganancia; }
}
