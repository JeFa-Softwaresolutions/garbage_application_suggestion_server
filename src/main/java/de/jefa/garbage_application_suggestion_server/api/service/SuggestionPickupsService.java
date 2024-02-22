package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickups;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionPickupsRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SuggestionPickupsService {

    private final SuggestionPickupsRepository suggestionPickupsRepository;

    public SuggestionPickupsService(SuggestionPickupsRepository suggestionPickupsRepository) {
        this.suggestionPickupsRepository = suggestionPickupsRepository;
    }

    public boolean createSuggestionPickup(Date date, Long suggestionRef, Long suggestionPickupDistrictRef, Long suggestionTrashTypeRef) {
        final TbSuggestionPickups suggestionPickups = new TbSuggestionPickups();
        suggestionPickups.setDate(date);
        suggestionPickups.setSuggestionRef(suggestionRef);
        suggestionPickups.setSuggestionTrashTypeRef(suggestionTrashTypeRef);
        suggestionPickups.setSuggestionPickupDistrictRef(suggestionPickupDistrictRef);
        try {
            suggestionPickupsRepository.save(suggestionPickups);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<TbSuggestionPickups> findBySuggestionRefAndSuggestionTrashTypeRefAndSuggestionPickupDistrictRef(Long suggestionRef, Long suggestionPickupDistrictRef, Long suggestionTrashTypeRef) {
        return suggestionPickupsRepository.findBySuggestionRefAndSuggestionPickupDistrictRefAndSuggestionTrashTypeRef(suggestionRef, suggestionPickupDistrictRef, suggestionTrashTypeRef);
    }
}
