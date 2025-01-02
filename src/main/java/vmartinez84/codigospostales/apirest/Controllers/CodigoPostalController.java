package vmartinez84.codigospostales.apirest.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vmartinez84.codigospostales.apirest.Dtos.EstadoDto;
import vmartinez84.codigospostales.apirest.Entitites.CodigoPostalEntidad;
import vmartinez84.codigospostales.apirest.Repositories.CodigoPostalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/CodigosPostales")
public class CodigoPostalController {

    @Autowired
    private CodigoPostalRepository repository;

    @GetMapping("Estados")
    public List<EstadoDto> obtnerEstadoDtos() {
        List<EstadoDto> estados = new ArrayList<>();

        estados = repository.findDistinctEstados();

        return estados;
    }

    @GetMapping("Estados/{id}/Alcaldias")
    public List<EstadoDto> obtnerAlcaldias(@PathVariable int id) {
        List<EstadoDto> estados = new ArrayList<>();

        estados = repository.findAlcaldiasPorEstadoId(id);

        return estados;
    }

    @GetMapping("Estados/{id}/Alcaldias/{alcaldiaId}")
    public List<CodigoPostalEntidad> obtenerCodigosPostales(@PathVariable int id, @PathVariable int alcaldiaId) {
        List<CodigoPostalEntidad> codigosPostales;

        codigosPostales = repository.findCodigosPostalesPorEstadoIdYAlcaldiaId(id, alcaldiaId);

        return codigosPostales;
    }

    @GetMapping("{codigoPostal}")
    public List<CodigoPostalEntidad> obtnerAlcaldias(@PathVariable String codigoPostal) {
        List<CodigoPostalEntidad> codigosPostales;

        codigosPostales = repository.findByCodigoPostal(codigoPostal);

        return codigosPostales;
    }

    @GetMapping("{colonia}/Buscar")
    public List<CodigoPostalEntidad> obtrner(@PathVariable String colonia) {
        List<CodigoPostalEntidad> codigosPostales;

        codigosPostales = repository.findCodigosPostalesPorColonia(colonia);

        return codigosPostales;
    }

    @GetMapping("Aleatorio")
    public CodigoPostalEntidad ObtenerCodigoPostal() {
        CodigoPostalEntidad cPostalEntidad;
        
        cPostalEntidad = repository.getRandom();

        return cPostalEntidad;
    }

    @GetMapping("Estados/{estadoId}/Aleatorio")
    public CodigoPostalEntidad ObtenerCodigoPostalAleatorioDeEstado(@PathVariable int estadoId) {
        CodigoPostalEntidad cPostalEntidad;
      
        cPostalEntidad = repository.getRandomByEstadoId(estadoId);

        return cPostalEntidad;
    }

}
