package vmartinez84.codigospostales.apirest.Entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "codigopostal")
public class CodigoPostalEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigopostal")
    private String CodigoPostal;

    private String Estado;
    
    @Column(name = "estadoid")
    private int EstadoId;
    private String Alcaldia;

    @Column(name = "alcaldiaid", nullable = false)
    private int AlcaldiaId;

    @Column(name = "tipodeasentamiento")
    private String TipoDeAsentamiento;
    
    private String Asentamiento;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigoPostal() {
        return CodigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        CodigoPostal = codigoPostal;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public int getEstadoId() {
        return EstadoId;
    }
    public void setEstadoId(int estadoId) {
        EstadoId = estadoId;
    }
    public String getAlcaldia() {
        return Alcaldia;
    }
    public void setAlcaldia(String alcaldia) {
        Alcaldia = alcaldia;
    }
    public int getAlcaldiaId() {
        return AlcaldiaId;
    }
    public void setAlcaldiaId(int alcaldiaId) {
        AlcaldiaId = alcaldiaId;
    }
    public String getTipoDeAsentamiento() {
        return TipoDeAsentamiento;
    }
    public void setTipoDeAsentamiento(String tipoDeAsentamiento) {
        TipoDeAsentamiento = tipoDeAsentamiento;
    }
    public String getAsentamiento() {
        return Asentamiento;
    }
    public void setAsentamiento(String asentamiento) {
        Asentamiento = asentamiento;
    }

    
}
