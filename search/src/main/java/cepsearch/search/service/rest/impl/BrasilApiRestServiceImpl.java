package cepsearch.search.service.rest.impl;

import cepsearch.search.model.Address;
import cepsearch.search.service.rest.ExternalCepRestService;

public class BrasilApiRestServiceImpl implements ExternalCepRestService {
    @Override
    public Address searchByCep(String cep) {
        return Address.builder()
                .street("Brasil api")
                .cep(cep)
                .build();
    }
    @Override
    public boolean support(String cep) {
        return cep.matches("\\d{8}");
    }
}

