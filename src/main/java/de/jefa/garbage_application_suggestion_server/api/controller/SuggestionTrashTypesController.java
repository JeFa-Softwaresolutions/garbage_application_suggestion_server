package de.jefa.garbage_application_suggestion_server.api.controller;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTrashTypes;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionTrashTypesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion_trash_types")
public class SuggestionTrashTypesController {

    private final SuggestionTrashTypesService suggestionTrashTypesService;

    public SuggestionTrashTypesController(SuggestionTrashTypesService suggestionTrashTypesService) {
        this.suggestionTrashTypesService = suggestionTrashTypesService;
    }

    @PostMapping("/create")
    public boolean createSuggestionTrashType(@RequestParam String name, @RequestParam Long suggestionRef) {
        return suggestionTrashTypesService.createSuggestionTrashTypes(name, suggestionRef);
    }

    @GetMapping("/{name}&{suggestionRef}")
    public TbSuggestionTrashTypes findByNameAndSuggestionRef(@PathVariable String name, @PathVariable Long suggestionRef) {
        return suggestionTrashTypesService.findByNameAndSuggestionRef(name, suggestionRef);
    }
}