package cepsearch.search.controller;
import cepsearch.search.model.Address;
import cepsearch.search.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cep")

public class CepController {
    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping
    public Address getAddressByCep(@RequestParam("cep") String cep) {

        return cepService.searchAddress(cep);
    }
}

