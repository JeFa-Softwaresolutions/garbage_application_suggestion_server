package de.jefa.garbage_application_suggestion_server.api.controller;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionStreets;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionStreetsService;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionTownsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion_streets")
public class SuggestionStreetsController {

    private final SuggestionStreetsService suggestionStreetsService;

    public SuggestionStreetsController(SuggestionStreetsService suggestionStreetsService) {
        this.suggestionStreetsService = suggestionStreetsService;
    }

    @PostMapping("/create")
    public boolean createSuggestionTown(@RequestParam String townName, @RequestParam Long suggestionId, @RequestParam Long suggestionPickupDistrictId) {
        return suggestionStreetsService.createSuggestionStreet(townName, suggestionId, suggestionPickupDistrictId);
    }

    @GetMapping("/{name}&{suggestionRef}")
    public TbSuggestionStreets getSuggestionTownByNameAndSuggestionRef(@PathVariable String name, @PathVariable Long suggestionRef) {
        return suggestionStreetsService.findByNameAndSuggestionRef(name, suggestionRef);
    }
}
