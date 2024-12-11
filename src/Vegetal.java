class Vegetal implements Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String fechaEnvasado;
    private String fechaCaducidad;

    public Vegetal(String nombre, String codigo, double precio, String fechaEnvasado, String fechaCaducidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.fechaEnvasado = fechaEnvasado;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
}
