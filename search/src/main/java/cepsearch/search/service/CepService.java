package cepsearch.search.service;
import cepsearch.search.service.rest.ExternalCepRestServiceFactory;
import cepsearch.search.model.Address;
import cepsearch.search.repository.AddressRepository;
import cepsearch.search.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CepService {
    private final AddressRepository addressRepository;
    private final ExternalCepRestServiceFactory externalCepRestServiceFactory;

    public CepService(AddressRepository addressRepository, ExternalCepRestServiceFactory externalCepRestServiceFactory) {
        this.addressRepository = addressRepository;
        this.externalCepRestServiceFactory = externalCepRestServiceFactory;
    }

    private boolean isValidCep(String cep) {
        return cep.matches("\\d{5}-\\d{3}");
    }

    public Address searchAddress(String cep) {
        if (!isValidCep(cep)) {
            throw new InvalidCepException("CEP inválido");
        }
        ExternalCepRestService externalCepRestService = externalCepRestServiceFactory.create(cep);
        Address address = externalCepRestService.searchByCep(cep);
        addressRepository.save(address);
        return address;
    }
}
