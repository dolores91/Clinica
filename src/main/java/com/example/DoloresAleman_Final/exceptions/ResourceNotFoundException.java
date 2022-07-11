package com.example.DoloresAleman_Final.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends Exception{

    private int pacienteId;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Integer id, String message) {
        super(message);
        this.setPacienteId(id);
    }



    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "pacienteId=" + pacienteId + ", " +
                "message= " + this.getMessage() +
                "}";
    }
}