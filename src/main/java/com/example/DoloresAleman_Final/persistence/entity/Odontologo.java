package com.example.DoloresAleman_Final.persistence.entity;
import com.example.DoloresAleman_Final.controller.OdontologoController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="odontologos")
public class Odontologo {
    protected final static Logger logger = Logger.getLogger(Odontologo.class);
    @Id
    @GeneratedValue
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologoSequence")
   // @SequenceGenerator(name = "odontologoSequence", sequenceName = "odontologoSequence", allocationSize = 1)

    @Column(name = "id_odontologo", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();
// --------------------------------CONSTRUCTORES-------------------------------------------------
    public Odontologo(Long id) {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    // --------------------------------GETTERS AND SETTERS-------------------------------------------------

    public Long getId() {
        return id;
    }

  //  public void setId(Long id) {
  //      this.id = id;
  //  }

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
