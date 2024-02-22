package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionPickupDistrictsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class SuggestionPickupDistrictsService {

    private final SuggestionPickupDistrictsRepository suggestionPickupDistrictsRepository;

    public SuggestionPickupDistrictsService(SuggestionPickupDistrictsRepository suggestionPickupDistrictsRepository) {
        this.suggestionPickupDistrictsRepository = suggestionPickupDistrictsRepository;
    }

    public boolean createSuggestionPickupDistrict(String name, Long suggestionRef) {
        final TbSuggestionPickupDistricts suggestionPickupDistricts = new TbSuggestionPickupDistricts();
        suggestionPickupDistricts.setName(name);
        suggestionPickupDistricts.setSuggestionRef(suggestionRef);
        try {
            suggestionPickupDistrictsRepository.save(suggestionPickupDistricts);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public TbSuggestionPickupDistricts findByNameAndSuggestionRef(String name, Long suggestionRef) {
        return suggestionPickupDistrictsRepository.findByNameAndSuggestionRef(name, suggestionRef);
    }
}