package de.jefa.garbage_application_suggestion_server.api.controller;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionTownsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion_towns")
public class SuggestionTownsController {

    private final SuggestionTownsService suggestionTownsService;

    public SuggestionTownsController(SuggestionTownsService suggestionTownsService) {
        this.suggestionTownsService = suggestionTownsService;
    }

    @PostMapping("/create")
    public boolean createSuggestionTown(@RequestParam String townName, @RequestParam Long suggestionId, @RequestParam Long suggestionPickupDistrictId) {
        return suggestionTownsService.createSuggestionTown(townName, suggestionId, suggestionPickupDistrictId);
    }

    @GetMapping("/{name}&{suggestionRef}")
    public TbSuggestionTowns getSuggestionTownByNameAndSuggestionRef(@PathVariable String name, @PathVariable Long suggestionRef) {
        return suggestionTownsService.findByNameAndSuggestionRef(name, suggestionRef);
    }
}