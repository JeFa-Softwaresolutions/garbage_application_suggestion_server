package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionStreets;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionStreetsRepository;
import org.springframework.stereotype.Service;

@Service
public class SuggestionStreetsService {

    private final SuggestionStreetsRepository suggestionStreetsRepository;

    public SuggestionStreetsService(SuggestionStreetsRepository suggestionStreetsRepository) {
        this.suggestionStreetsRepository = suggestionStreetsRepository;
    }

    public boolean createSuggestionStreet(String name, Long suggestionId, Long suggestionPickupDistrictId) {
        final TbSuggestionStreets suggestionStreets = new TbSuggestionStreets();
        suggestionStreets.setSuggestionPickupDistrictRef(suggestionPickupDistrictId);
        suggestionStreets.setSuggestionRef(suggestionId);
        suggestionStreets.setName(name);
        try {
            suggestionStreetsRepository.save(suggestionStreets);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public TbSuggestionStreets findByNameAndSuggestionRef(String name, Long suggestionRef) {
        return suggestionStreetsRepository.findByNameAndSuggestionRef(name, suggestionRef);
    }
}
