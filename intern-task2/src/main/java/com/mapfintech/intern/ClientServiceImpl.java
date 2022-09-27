package com.mapfintech.intern;

import org.apache.commons.validator.GenericValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private GenericValidator genericValidator = new GenericValidator();

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Validations for crete client
     *
     * @param client's info
     * @return create client or print error message
     */
    @Override
    public Client createClient(Client client) {
        boolean flag = false;
        Optional<Client> usernameValidation = clientRepository.findByClientUserName(client.getClientUserName());
        if (genericValidator.isBlankOrNull(client.getClientName()) || client.getClientName().length() > 20) {
            logger.error("Name: " + client.getClientName() + " not valid!");
            flag = true;
        }
        if (genericValidator.isBlankOrNull(client.getClientSurname()) || client.getClientSurname().length() > 20) {
            logger.error("Surname: " + client.getClientSurname() + " not valid!");
            flag = true;
        }
        if (genericValidator.isBlankOrNull(client.getClientUserName()) || client.getClientUserName().length() > 15) {
            logger.error("Username: " + client.getClientUserName() + " not valid!");
            flag = true;
        }
        if (!genericValidator.isEmail(client.getClientEmail())) {
            logger.error("Email:" + client.getClientEmail() + "is not valid!");
            flag = true;
        }
        if (!genericValidator.isInRange(client.getClientPhone(), 10000000, 99999999)) {
            logger.error("Phone not valid!");
            flag = true;
        }
        if (usernameValidation.isPresent()) {
            logger.error("Username: " + client.getClientUserName() + " is already taken!");
            flag = true;
        }
        if (!flag) {
            logger.info("Created successfully!");
            return clientRepository.save(client);
        } else {
            logger.error("Something went wrong!");
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Client> fetchClientList() {
        logger.info("Fetched successfully!");
        return clientRepository.findAll();
    }

    /**
     * Set updated values to the collumns
     *
     * @param client's info
     * @param clientId
     * @return
     */
    @Override
    public Client updateClient(Client client, Long clientId) {
        Client cDB = clientRepository.findById(clientId).get();
        if (Objects.nonNull(client.getClientUserName()) && !"".equalsIgnoreCase(client.getClientUserName())) {
            cDB.setClientUserName(client.getClientUserName());
        }
        if (Objects.nonNull(client.getClientName()) && !"".equalsIgnoreCase(client.getClientName())) {
            cDB.setClientName(client.getClientName());
        }
        if (Objects.nonNull(client.getClientSurname()) && !"".equalsIgnoreCase(client.getClientSurname())) {
            cDB.setClientSurname(client.getClientSurname());
        }
        if (Objects.nonNull(client.getClientCompany()) && !"".equalsIgnoreCase(client.getClientCompany())) {
            cDB.setClientCompany(client.getClientCompany());
        }
        if (Objects.nonNull(client.getClientLEI()) && !"".equalsIgnoreCase(client.getClientLEI())) {
            cDB.setClientLEI(client.getClientLEI());
        }
        if (Objects.nonNull(client.getClientEmail()) && !"".equalsIgnoreCase(client.getClientEmail())) {
            cDB.setClientEmail(client.getClientEmail());
        }
        if (Objects.nonNull(client.getClientDateUpdated())) {
            cDB.setClientDateUpdated(client.getClientDateUpdated());
        }
        if (Objects.nonNull(client.getClientUserUpdated())) {
            cDB.setClientUserUpdated(client.getClientUserUpdated());
        }
        if (Objects.nonNull(client.getClientStatus())) {
            cDB.setClientStatus(client.getClientStatus());
        }
        logger.info("Updated successfully!");
        return clientRepository.save(cDB);
    }

    /**
     * Set updated values to the collumns
     *
     * @param client's                 info
     * @param clientId(clientUserName)
     * @return
     */
    @Override
    public Client updateClientByUserName(Client client, String clientId) {
        Client cDB = clientRepository.findByClientUserName(clientId).get();
        if (Objects.nonNull(client.getClientUserName()) && !"".equalsIgnoreCase(client.getClientUserName())) {
            cDB.setClientUserName(client.getClientUserName());
        }
        if (Objects.nonNull(client.getClientName()) && !"".equalsIgnoreCase(client.getClientName())) {
            cDB.setClientName(client.getClientName());
        }
        if (Objects.nonNull(client.getClientSurname()) && !"".equalsIgnoreCase(client.getClientSurname())) {
            cDB.setClientSurname(client.getClientSurname());
        }
        if (Objects.nonNull(client.getClientCompany()) && !"".equalsIgnoreCase(client.getClientCompany())) {
            cDB.setClientCompany(client.getClientCompany());
        }
        if (Objects.nonNull(client.getClientLEI()) && !"".equalsIgnoreCase(client.getClientLEI())) {
            cDB.setClientLEI(client.getClientLEI());
        }
        if (Objects.nonNull(client.getClientEmail()) && !"".equalsIgnoreCase(client.getClientEmail())) {
            cDB.setClientEmail(client.getClientEmail());
        }
        if (Objects.nonNull(client.getClientDateUpdated())) {
            cDB.setClientDateUpdated(client.getClientDateUpdated());
        }
        if (Objects.nonNull(client.getClientUserUpdated())) {
            cDB.setClientUserUpdated(client.getClientUserUpdated());
        }
        if (Objects.nonNull(client.getClientStatus())) {
            cDB.setClientStatus(client.getClientStatus());
        }
        logger.info("Updated successfully!");
        return clientRepository.save(cDB);
    }


    /**
     * Delete client by id
     *
     * @param clientId
     */
    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
        logger.info("Deleted successfully!");

    }

    /**
     * Delete client by Username
     *
     * @param clientId(clientUserName)
     */
    @Override
    public void deleteClientByClientUserName(String clientId) {
        Client client = clientRepository.findByClientUserName(clientId).get();
        clientRepository.delete(client);
        logger.info("Deleted successfully!");

    }


}
