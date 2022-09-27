package com.mapfintech.intern;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private MapperInterface mapperInterface;
    private ClientRepository clientRepository;
    private ClientService clientService;
    private GenericValidator genericValidator = new GenericValidator();

    @Autowired
    public ClientController(
            MapperInterface mapperInterface,
            ClientRepository userRepository,
            ClientService clientService
    ) {
        this.mapperInterface = mapperInterface;
        this.clientRepository = userRepository;
        this.clientService = clientService;
    }

    /**
     * Get all clients' info
     *
     * @return all clients' info
     */
    @GetMapping
    public List<Client> fetchClientList() {
        return clientService.fetchClientList();
    }

    /**
     * Create a new client in the database
     *
     * @param client's info
     * @return client's info
     */
    @PostMapping
    public Client createClient(@Valid @RequestBody Client client) {
        client.setClientUserUpdated(0);
        client.setClientUserCreated(1);
        client.setClientStatus("Created");
        return clientService.createClient(client);
    }

    /**
     * Search by id or by Username
     *
     * @param id(clientId/clientUserName)
     * @return client's info
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable(value = "id") String id) {
        if (genericValidator.isInt(id)) {
            return new ResponseEntity<>(mapperInterface.clientToClientDTO(clientRepository.findById(Long.parseLong(id)).get()
            ), HttpStatus.OK
            );

        } else {
            return new ResponseEntity<>(mapperInterface.clientToClientDTO(clientRepository.findByClientUserName(id).get()
            ), HttpStatus.OK
            );

        }
    }

    /**
     * Update client's info
     *
     * @param clientDTO(updated info)
     * @param id(clientId/clientUserName)
     * @return updated client's info
     */

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO, @PathVariable("id") String clientId) {
        if (genericValidator.isInt(clientId)) {
            clientDTO.setClientUserUpdated(1);
            clientDTO.setClientStatus("Updated");
            Date date = new Date();
            clientDTO.setClientDateUpdated(date);
            Client client = mapperInterface.clientDTOToClient(clientDTO);
            clientDTO = mapperInterface.clientToClientDTO(clientService.updateClient(client, Long.parseLong(clientId)));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientDTO);
        } else {


            clientDTO.setClientUserUpdated(1);
            clientDTO.setClientStatus("Updated");
            Date date = new Date();
            clientDTO.setClientDateUpdated(date);
            Client client = mapperInterface.clientDTOToClient(clientDTO);
            clientDTO = mapperInterface.clientToClientDTO(clientService.updateClientByUserName(client, clientId));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientDTO);
        }
    }

    /**
     * Delete a client by id or username
     *
     * @param id(clientId/clientUserName)
     * @return "Deleted Successfully" message
     */
    @DeleteMapping("/{id}")
    public String deleteClientById(@PathVariable("id") String clientId) {
        if (genericValidator.isInt(clientId)) {
            clientService.deleteClientById(Long.parseLong(clientId));
            return "Deleted Successfully";
        } else {
            clientService.deleteClientByClientUserName(clientId);
            return "Deleted Successfully";
        }

    }


}
