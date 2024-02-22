package de.jefa.garbage_application_suggestion_server.api.service;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestions;
import de.jefa.garbage_application_suggestion_server.api.repository.SuggestionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionsService {

    private final SuggestionsRepository suggestionsRepository;

    public SuggestionsService(SuggestionsRepository suggestionsRepository) {
        this.suggestionsRepository = suggestionsRepository;
    }

    public TbSuggestions findByCityNameStateSystemIdDistrictSystemIdAndUserName(String cityName, String stateSystemId, String districtSystemId, String userName) {
        return suggestionsRepository.findByCityNameStateSystemIdDistrictSystemIdAndUserName(cityName, stateSystemId, districtSystemId, userName);
    }

    public List<TbSuggestions> findByCreatedBy(String createdBy) {
        return suggestionsRepository.findByCreatedBy(createdBy);
    }

    public boolean saveSuggestion(String cityName, String stateSystemId, String districtSystemId, String userName, String linkToInformations, boolean needStreetsForCalc) {
        final TbSuggestions suggestion = new TbSuggestions();
        suggestion.setCityName(cityName);
        suggestion.setStateSystemId(stateSystemId);
        suggestion.setDistrictSystemId(districtSystemId);
        suggestion.setCreatedBy(userName);
        suggestion.setLinkToInformations(linkToInformations);
        suggestion.setNeedStreetsForCalcFlag(needStreetsForCalc);
        try {
            suggestionsRepository.save(suggestion);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
