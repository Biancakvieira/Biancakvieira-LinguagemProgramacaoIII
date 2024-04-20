package cepsearch.search.controller;
import cepsearch.search.model.Address;
import cepsearch.search.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cep")
@RequiredArgsConstructor
public class CepController {
    private final CepService cepService;
    @GetMapping
    public Address getAddressByCep(@RequestParam("cep") String cep) {

        return cepService.searchAddress(cep);
    }
}

