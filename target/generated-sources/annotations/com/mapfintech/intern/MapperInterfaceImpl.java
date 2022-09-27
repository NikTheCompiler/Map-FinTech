package com.mapfintech.intern;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-28T14:30:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MapperInterfaceImpl implements MapperInterface {

    @Override
    public ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setClientId( client.getClientId() );
        clientDTO.setClientUserName( client.getClientUserName() );
        clientDTO.setClientName( client.getClientName() );
        clientDTO.setClientSurname( client.getClientSurname() );
        clientDTO.setClientCompany( client.getClientCompany() );
        clientDTO.setClientLEI( client.getClientLEI() );
        clientDTO.setClientEmail( client.getClientEmail() );
        clientDTO.setClientPhone( client.getClientPhone() );
        clientDTO.setClientDemoFlag( client.getClientDemoFlag() );
        clientDTO.setClientStatus( client.getClientStatus() );
        clientDTO.setClientDateCreated( client.getClientDateCreated() );
        clientDTO.setClientDateUpdated( client.getClientDateUpdated() );
        clientDTO.setClientUserCreated( client.getClientUserCreated() );
        clientDTO.setClientUserUpdated( client.getClientUserUpdated() );

        return clientDTO;
    }

    @Override
    public Client clientDTOToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setClientId( clientDTO.getClientId() );
        client.setClientUserName( clientDTO.getClientUserName() );
        client.setClientName( clientDTO.getClientName() );
        client.setClientSurname( clientDTO.getClientSurname() );
        client.setClientCompany( clientDTO.getClientCompany() );
        client.setClientLEI( clientDTO.getClientLEI() );
        client.setClientEmail( clientDTO.getClientEmail() );
        client.setClientPhone( clientDTO.getClientPhone() );
        client.setClientDemoFlag( clientDTO.getClientDemoFlag() );
        client.setClientStatus( clientDTO.getClientStatus() );
        client.setClientDateCreated( clientDTO.getClientDateCreated() );
        client.setClientDateUpdated( clientDTO.getClientDateUpdated() );
        client.setClientUserCreated( clientDTO.getClientUserCreated() );
        client.setClientUserUpdated( clientDTO.getClientUserUpdated() );

        return client;
    }
}
