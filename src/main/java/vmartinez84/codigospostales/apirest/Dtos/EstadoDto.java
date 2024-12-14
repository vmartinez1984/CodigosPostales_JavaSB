package vmartinez84.codigospostales.apirest.Dtos;

public class EstadoDto {

    
    public EstadoDto(int id, String nombre) {
        Id = id;
        Nombre = nombre;
    }

    private int Id;
    private String Nombre;
    
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
}
