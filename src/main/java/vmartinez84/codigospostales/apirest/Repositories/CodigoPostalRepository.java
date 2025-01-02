package vmartinez84.codigospostales.apirest.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vmartinez84.codigospostales.apirest.Dtos.EstadoDto;
import vmartinez84.codigospostales.apirest.Entitites.CodigoPostalEntidad;

public interface CodigoPostalRepository extends JpaRepository<CodigoPostalEntidad, Integer> {
    
    //@Query("select  distinct(c.estado) as Nombre, c.estadoid as Id from CodigoPostalEntidad c")
    //public List<EstadoDto> findEstados();

    // @Query("select distinct(c.Estado) from CodigoPostalEntidad c")
    // List<String> findEstados();

    @Query("SELECT new vmartinez84.codigospostales.apirest.Dtos.EstadoDto(c.EstadoId, c.Estado) FROM CodigoPostalEntidad c GROUP BY c.EstadoId, c.Estado")
    List<EstadoDto> findDistinctEstados();

    @Query("SELECT new vmartinez84.codigospostales.apirest.Dtos.EstadoDto(c.AlcaldiaId, c.Alcaldia) FROM CodigoPostalEntidad c WHERE c.EstadoId = ?1 GROUP BY c.AlcaldiaId, c.Alcaldia")
    List<EstadoDto> findAlcaldiasPorEstadoId(int id);    

    @Query("select c from CodigoPostalEntidad c where c.CodigoPostal = ?1")
    List<CodigoPostalEntidad> findByCodigoPostal(String codigopostal);

    @Query("SELECT c FROM CodigoPostalEntidad c WHERE c.EstadoId = ?1 and c.AlcaldiaId = ?2")
    List<CodigoPostalEntidad> findCodigosPostalesPorEstadoIdYAlcaldiaId(int id, int alcaldiaId);

    @Query("SELECT c FROM CodigoPostalEntidad c WHERE c.Asentamiento like %?1%")
    List<CodigoPostalEntidad> findCodigosPostalesPorColonia(String colonia);

    @Query("SELECT new vmartinez84.codigospostales.apirest.Dtos.EstadoDto(c.AlcaldiaId, c.Alcaldia) FROM CodigoPostalEntidad c WHERE c.EstadoId = ?1 GROUP BY c.AlcaldiaId, c.Alcaldia")
    List<CodigoPostalEntidad> findCodigosPostalesPorEstadoId(int id);

    @Query("SELECT c FROM CodigoPostalEntidad c WHERE c.EstadoId = ?1 and c.AlcaldiaId = ?2 and c.Asentamiento like %?3%")
    List<CodigoPostalEntidad> findCodigosPostalesPorEstadoIdAlcaldiaIdYColonia(int id, int alcaldiaId, String colonia);

    @Query("SELECT c FROM CodigoPostalEntidad c ORDER BY RAND() LIMIT 1")
    CodigoPostalEntidad getRandom();

    @Query("SELECT c FROM CodigoPostalEntidad c WHERE c.EstadoId = ?1 ORDER BY RAND() LIMIT 1")
    CodigoPostalEntidad getRandomByEstadoId(int estadoId);
}
