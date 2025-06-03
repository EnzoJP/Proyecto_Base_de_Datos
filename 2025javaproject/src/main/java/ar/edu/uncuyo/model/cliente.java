package ar.edu.uncuyo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente", schema = "clientes")
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generación automática de ID
    @Column(name = "ID_cliente")
    private Long ID_cliente;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;

    @Column(name = "cod_postal")
    private String codPostal;

    @ManyToOne
    @JoinColumn(name = "ID_genero")
    private genero ID_genero;

    public cliente() {}

    public cliente(String nombre, String apellido, String dni, String telefono, String email, String codPostal, genero ID_genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.codPostal = codPostal;
        this.ID_genero = ID_genero;
    }

    // Getters y setters

    public Long getId() {
        return ID_cliente;
    }

    public void setId(Long id) {
        this.ID_cliente = id;
    }

    public void setIdObjeto(genero generoAsetear) {
        this.ID_genero = generoAsetear;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public genero getGenero() {
        return ID_genero;
    }

    public void setGenero(genero ID_genero) {
        this.ID_genero = ID_genero;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + ID_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", genero=" + ID_genero +
                '}';
    }
}
