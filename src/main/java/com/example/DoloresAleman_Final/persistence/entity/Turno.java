package com.example.DoloresAleman_Final.persistence.entity;

import com.example.DoloresAleman_Final.controller.OdontologoController;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table (name="turnos")
public class Turno {
    protected final static Logger logger = Logger.getLogger(Turno.class);
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "turnoSequence", sequenceName = "turnoSequence", allocationSize = 1)

    @Column(name = "id_turno", nullable = false)
    private Long id;

    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_odontologo" , referencedColumnName = "id_odontologo")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente" , referencedColumnName = "id_paciente")
    private Paciente paciente;

// --------------------------------CONSTRUCTORES-------------------------------------------------

   /* public Turno() {
    }

    public Turno(Date date, Odontologo odontologo, Paciente paciente) {
        this.date = date;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }*/
    // --------------------------------GETTERS AND SETTERS-------------------------------------------------

    public Long getId() {
        return id;
    }

    //public void setId(Long id) {
    //    this.id = id;
    //}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
