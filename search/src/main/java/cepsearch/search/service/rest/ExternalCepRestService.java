package cepsearch.search.service.rest;

import cepsearch.search.model.Address;

public interface ExternalCepRestService {
    Address searchByCep(String cep);
    boolean support(String cep);

}

