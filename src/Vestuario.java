class Vestuario implements Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String talla;
    private String color;

    public Vestuario(String nombre, String codigo, double precio, String talla, String color) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.talla = talla;
        this.color = color;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
}