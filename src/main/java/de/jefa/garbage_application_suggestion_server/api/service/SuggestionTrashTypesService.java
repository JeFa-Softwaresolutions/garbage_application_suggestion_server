package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTrashTypes;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionTrashTypesRepository;
import org.springframework.stereotype.Service;

@Service
public class SuggestionTrashTypesService {

    private final SuggestionTrashTypesRepository suggestionTrashTypesRepository;

    public SuggestionTrashTypesService(SuggestionTrashTypesRepository suggestionTrashTypesRepository) {
        this.suggestionTrashTypesRepository = suggestionTrashTypesRepository;
    }

    public boolean createSuggestionTrashTypes(String name, Long suggestionRef) {
        final TbSuggestionTrashTypes suggestionTrashTypes = new TbSuggestionTrashTypes();
        suggestionTrashTypes.setName(name);
        suggestionTrashTypes.setSuggestionRef(suggestionRef);
        try {
            suggestionTrashTypesRepository.save(suggestionTrashTypes);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public TbSuggestionTrashTypes findByNameAndSuggestionRef(String name, Long suggestionRef) {
        return suggestionTrashTypesRepository.findByNameAndSuggestionRef(name, suggestionRef);
    }
}