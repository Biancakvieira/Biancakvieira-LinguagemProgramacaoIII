package cepsearch.search.service.rest.impl;

import cepsearch.search.model.Address;
import cepsearch.search.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {
    @Override
    public Address searchByCep(String cep) {
        log.error("Probrema");
        throw new RuntimeException("Probrema");
    }
    @Override
    public boolean support(String cep) {
        return cep.matches("\\d{8}");
    }
}
