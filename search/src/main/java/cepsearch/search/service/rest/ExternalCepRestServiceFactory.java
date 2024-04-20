package cepsearch.search.service.rest;

import cepsearch.search.service.rest.ExternalCepRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class ExternalCepRestServiceFactory {

    private final List<ExternalCepRestService> externalCepRestServices;

    @Autowired
    public ExternalCepRestServiceFactory(List<ExternalCepRestService> externalCepRestServices) {
        this.externalCepRestServices = externalCepRestServices;
    }

    public ExternalCepRestService create(String cep) {
        return externalCepRestServices.stream()
                .filter(service -> service.support(cep))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nenhum provedor de CEP suportado encontrado para o CEP " + cep));
    }
}