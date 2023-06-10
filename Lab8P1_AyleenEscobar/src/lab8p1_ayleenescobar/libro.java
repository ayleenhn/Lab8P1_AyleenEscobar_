/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_ayleenescobar;

/**
 *
 * @author famil
 */
public class libro {
    private String titulo;
    private String autor;
    private int Publicacion;

    public libro(String tituloL, String autorL, int PublicacionL) {
        this.titulo = tituloL;
        this.autor = autorL;
        this.Publicacion = PublicacionL;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

    public void setpublicacion(int Publicacion) {
        this.Publicacion = Publicacion;
    }
}
