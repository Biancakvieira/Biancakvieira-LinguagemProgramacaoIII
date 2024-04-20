package cepsearch.search.service.rest.impl;

import cepsearch.search.service.rest.ExternalCepRestService;
import cepsearch.search.model.Address;

public class ViaCepRestServiceImpl implements ExternalCepRestService {


    @Override
    public Address searchByCep(String cep) {
        return Address.builder()
                .street("Via cep")
                .cep(cep)
                .build();
    }
    @Override
    public boolean support(String cep) {
        return cep.matches("\\d{8}");
    }


}
