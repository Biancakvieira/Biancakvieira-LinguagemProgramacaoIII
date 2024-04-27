package cepsearch.search.service.rest.impl;

import cepsearch.search.service.rest.ExternalCepRestService;
import cepsearch.search.model.Address;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private final List<ExternalCepRestService> externalImpl =
            List.of(
                    new CepAbertoServiceImpl(),
                    new BrasilApiRestServiceImpl(),
                    new ViaCepRestServiceImpl()
            );

    public FallBackRestImpl(List<String> falbackOrder, List<String> fallbackOrder) {
        this.fallbackOrder = fallbackOrder;
    }

    @Override
    public Address searchByCep(String cep) {

        Address response = null;
        for (ExternalCepRestService externalService : externalImpl) {
            try {
                response = externalService.searchByCep(cep);
                break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }
    @Override
    public boolean support(String cep) {
        return cep.matches("\\d{8}");
    }

}
