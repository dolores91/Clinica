package com.example.DoloresAleman_Final.persistence.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pacientes")

public class Paciente {
    protected final static Logger logger = Logger.getLogger(Paciente.class);
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id_paciente", nullable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio" , referencedColumnName = "id_domicilio")
    private Domicilio domicilio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();



// --------------------------------CONSTRUCTORES-------------------------------------------------

   /* public Paciente() {
    }

    public Paciente(String nombre, String apellido, String email, String dni, Date fechaDeIngreso, Domicilio domicilio, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
        this.domicilio = domicilio;
        this.turnos = turnos;
    }*/
// --------------------------------GETTERS AND SETTERS-------------------------------------------------



    public Long getId() {
        return id;
    }

   // public void setId(Long id) {
   //     this.id = id;
   // }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
