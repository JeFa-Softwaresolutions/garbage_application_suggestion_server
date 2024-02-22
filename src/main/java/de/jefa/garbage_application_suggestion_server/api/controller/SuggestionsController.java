package de.jefa.garbage_application_suggestion_server.api.controller;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestions;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionsController {

    private final SuggestionsService suggestionsService;

    public SuggestionsController(SuggestionsService suggestionsService) {
        this.suggestionsService = suggestionsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSuggestion(@RequestParam String cityName, @RequestParam String stateSystemId, @RequestParam String districtSystemId, @RequestParam String userName, @RequestParam String linkToInformations, @RequestParam boolean needStreetsForCalc) {
        if(suggestionsService.saveSuggestion(cityName, stateSystemId, districtSystemId, userName, linkToInformations, needStreetsForCalc)) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.ok("User could not be created");
        }
    }

    @GetMapping("/{cityName}&{stateSystemId}&{districtSystemId}&{userName}")
    public TbSuggestions getSuggestionByCityNameStateSystemIdDistrictSystemIdAndUserName(@PathVariable String cityName, @PathVariable String stateSystemId, @PathVariable String districtSystemId, @PathVariable String userName) {
        return suggestionsService.findByCityNameStateSystemIdDistrictSystemIdAndUserName(cityName, stateSystemId, districtSystemId, userName);
    }

    @GetMapping("/{createdBy}")
    public List<TbSuggestions> getSuggestionsByCreatedBy(@PathVariable String createdBy) {
        return suggestionsService.findByCreatedBy(createdBy);
    }
}