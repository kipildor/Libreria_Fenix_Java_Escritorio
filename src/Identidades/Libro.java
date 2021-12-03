package Identidades;

import java.util.*;

public class Libro {
    private int idlibro;
    private String isbn;
    private String titulo;
    private String autor;
    private int cantpaginas;
    private String editorial;
    private Date fechapublicacion;
    private double precio;
    private Tema tema;

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantpaginas() {
        return cantpaginas;
    }

    public void setCantpaginas(int cantpaginas) {
        this.cantpaginas = cantpaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Libro() {
    }

    public Libro(int idlibro, String isbn, String titulo, String autor, int cantpaginas, String editorial, Date fechapublicacion, double precio, Tema tema) {
        this.idlibro = idlibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantpaginas = cantpaginas;
        this.editorial = editorial;
        this.fechapublicacion = fechapublicacion;
        this.precio = precio;
        this.tema = tema;
    }

   
}
