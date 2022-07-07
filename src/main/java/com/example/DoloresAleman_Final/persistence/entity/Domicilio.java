package com.example.DoloresAleman_Final.persistence.entity;

import com.example.DoloresAleman_Final.controller.OdontologoController;
import org.apache.log4j.Logger;

import javax.persistence.*;

@Entity
@Table(name ="domicilios")
public class Domicilio {
    protected final static Logger logger = Logger.getLogger(Domicilio.class);
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilioSecuence")
  //  @SequenceGenerator(name = "domicilioSecuence", sequenceName = "domicilioSecuence", allocationSize = 1)

    @Column(name = "id_domicilio", nullable = false)
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToOne(mappedBy = "domicilio") //aca no va el jsonignore
    private Paciente paciente;

// --------------------------------CONSTRUCTORES-------------------------------------------------

    /*public Domicilio(Long id) {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }*/
// --------------------------------GETTERS AND SETTERS-------------------------------------------------

    public Long getId() {
        return id;
    }
    //public void setId(Long id) {
    //    this.id = id;
    //}

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
