package de.jefa.garbage_application_suggestion_server.api.controller;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionPickupDistrictsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion_pickup_districts")
public class SuggestionPickupDistrictsController {

    private final SuggestionPickupDistrictsService suggestionPickupDistrictsService;

    public SuggestionPickupDistrictsController(SuggestionPickupDistrictsService suggestionPickupDistrictsService) {
        this.suggestionPickupDistrictsService = suggestionPickupDistrictsService;
    }

    @PostMapping("/create")
    public boolean createSuggestionPickupDistrict(@RequestParam String name, @RequestParam Long suggestionRef) {
        return suggestionPickupDistrictsService.createSuggestionPickupDistrict(name, suggestionRef);
    }

    @GetMapping("/{name}&{suggestionRef}")
    public TbSuggestionPickupDistricts findByNameAndSuggestionRef(@PathVariable String name, @PathVariable Long suggestionRef) {
        return suggestionPickupDistrictsService.findByNameAndSuggestionRef(name, suggestionRef);
    }
}