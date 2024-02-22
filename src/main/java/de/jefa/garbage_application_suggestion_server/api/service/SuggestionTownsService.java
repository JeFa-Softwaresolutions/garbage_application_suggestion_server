package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionTownsRepository;
import org.springframework.stereotype.Service;

@Service
public class SuggestionTownsService {

    private final SuggestionTownsRepository suggestionTownsRepository;

    public SuggestionTownsService(SuggestionTownsRepository suggestionTownsRepository) {
        this.suggestionTownsRepository = suggestionTownsRepository;
    }

    public boolean createSuggestionTown(String name, Long suggestionId, Long suggestionPickupDistrictId) {
        final TbSuggestionTowns suggestionTowns = new TbSuggestionTowns();
        suggestionTowns.setSuggestionPickupDistrictRef(suggestionPickupDistrictId);
        suggestionTowns.setSuggestionRef(suggestionId);
        suggestionTowns.setName(name);
        try {
            suggestionTownsRepository.save(suggestionTowns);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public TbSuggestionTowns findByNameAndSuggestionRef(String name, Long suggestionRef) {
        return suggestionTownsRepository.findByNameAndSuggestionRef(name, suggestionRef);
    }
}