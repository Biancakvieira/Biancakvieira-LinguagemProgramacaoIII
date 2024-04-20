package cepsearch.search.service;

import cepsearch.search.NotFoundException;
import cepsearch.search.model.Address;
import cepsearch.search.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        // Implementar a lógica de negócio para criar um novo endereço
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id) {
        // Implementar a lógica de negócio para obter um endereço pelo ID
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereço não encontrado"));
    }

    public Address updateAddress(Long id, Address address) {
        // Implementar a lógica de negócio para atualizar um endereço
        Address existingAddress = getAddressById(id);
        existingAddress.setStreet(address.getStreet());
        existingAddress.setNumber(address.getNumber());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setNeighborhood(address.getNeighborhood());
        existingAddress.setCep(address.getCep());
        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(Long id) {
        // Implementar a lógica de negócio para excluir um endereço
        addressRepository.deleteById(id);
    }

}
