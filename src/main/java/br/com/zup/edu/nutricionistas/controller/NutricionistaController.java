package br.com.zup.edu.nutricionistas.controller;

import br.com.zup.edu.nutricionistas.model.Nutricionista;
import br.com.zup.edu.nutricionistas.repository.NutricionistaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NutricionistaController {

    private final NutricionistaRepository nutricionistaRepository;

    public NutricionistaController(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }

    @PostMapping("/nutricionista")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NutricionistaRequest nutricionistaRequest, UriComponentsBuilder uriComponentsBuilder){
        Nutricionista nutricionista = nutricionistaRequest.toModel();
        nutricionistaRepository.save(nutricionista);

        URI location = uriComponentsBuilder.path("/nutricionista/{ìd}").buildAndExpand(nutricionista.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
