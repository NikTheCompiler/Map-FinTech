package com.mapfintech.intern;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);

    List<Client> fetchClientList();

    Client updateClient(Client clientDTO, Long clientId);

    Client updateClientByUserName(Client clientDTO, String clientId);

    void deleteClientById(Long clientId);

    void deleteClientByClientUserName(String clientId);


}
