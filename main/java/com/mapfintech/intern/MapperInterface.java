package com.mapfintech.intern;

import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface MapperInterface {
    ClientDTO clientToClientDTO(Client client);

    Client clientDTOToClient(ClientDTO clientDTO);
}
