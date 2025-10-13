package com.example;

public class Productos {
    String nombre;
    double prezo;
    boolean disponible;
    String[] categorias; // lista de 3 categorias
    int stock;
    String descripcion;
    Proveedor proveedor;


    // Constructores autogenerados por el source action
    public Productos(String nombre, double prezo, boolean disponible, String[] categorias, int stock,
            String descripcion, Proveedor proveedor) {
        this.nombre = nombre;
        this.prezo = prezo;
        this.disponible = disponible;
        this.categorias = categorias;
        this.stock = stock;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }


    public Productos(String nombre, double prezo, boolean disponible, String[] categorias, int stock,
            String descripcion) {
        this.nombre = nombre;
        this.prezo = prezo;
        this.disponible = disponible;
        this.categorias = categorias;
        this.stock = stock;
        this.descripcion = descripcion;
    }





    // Si necesitas modificar algun campo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // Getters si necesitas leer algun campo

    public String getNombre() {
        return nombre;
    }


    public double getPrezo() {
        return prezo;
    }


    public boolean isDisponible() {
        return disponible;
    }


    public String[] getCategorias() {
        return categorias;
    }


    public int getStock() {
        return stock;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }

}

