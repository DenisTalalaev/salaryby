package by.salary.organisationservice.service;

import by.salary.organisationservice.entity.Organisation;
import by.salary.organisationservice.exceptions.OrganisationNotFoundException;
import by.salary.organisationservice.model.OrganisationRequestDTO;
import by.salary.organisationservice.model.OrganisationResponseDTO;
import by.salary.organisationservice.repo.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    public List<OrganisationResponseDTO> getAllOrganisations() {
        return organisationRepository.findAll()
                .stream()
                .map(OrganisationResponseDTO::new)
                .toList();
    }

    public OrganisationResponseDTO getOrganisationById(Long id) {
        return organisationRepository.findById(id)
                .map(OrganisationResponseDTO::new)
                .orElseThrow(() -> new OrganisationNotFoundException("Organisation with id: " + id + " not found", HttpStatus.NOT_FOUND));
    }

    public OrganisationResponseDTO createOrganisation(OrganisationRequestDTO organisationRequestBody) {
        Organisation organisation = organisationRepository.save(new Organisation(organisationRequestBody));
        return new OrganisationResponseDTO(organisation);
    }

    public OrganisationResponseDTO deleteOrganisationById(Long id) {
        Optional<Organisation> organisation = organisationRepository.findById(id);
        if(organisation.isEmpty()){
            throw new OrganisationNotFoundException("Organisation not found", HttpStatus.NOT_FOUND);
        }
        organisationRepository.delete(organisation.get());
        return new OrganisationResponseDTO(organisation.get());
    }

    public OrganisationResponseDTO updateOrganisation(Long id, OrganisationRequestDTO organisationRequestBody) {
        Optional<Organisation> organisation = organisationRepository.findById(id);
        if(organisation.isEmpty()){
            throw new OrganisationNotFoundException("Organisation not found", HttpStatus.NOT_FOUND);
        }
        organisation.get().update(organisationRequestBody);
        return new OrganisationResponseDTO(organisation.get());
    }
}
