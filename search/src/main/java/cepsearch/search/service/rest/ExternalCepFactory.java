package cepsearch.search.service.rest;

import cepsearch.search.service.rest.impl.BrasilApiRestServiceImpl;
import cepsearch.search.service.rest.impl.CepAbertoServiceImpl;
import cepsearch.search.service.rest.impl.ViaCepRestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExternalCepFactory {
    private static final Map<String, ExternalCepRestService> EXTERNAL_SYSTEMS = Map.of(
            "VIACEP",
            new ViaCepRestServiceImpl(),
            "CEPABERTO",
            new CepAbertoServiceImpl(),
            "BRASILAPI",
            new BrasilApiRestServiceImpl()
    );

    private final Map<String, ExternalCepRestService> externalCepRestServiceMap;

    public ExternalCepRestService create(String api) {

        return Optional.ofNullable(externalCepRestServiceMap.get(api))
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma implementação de cep"));

    }
}
