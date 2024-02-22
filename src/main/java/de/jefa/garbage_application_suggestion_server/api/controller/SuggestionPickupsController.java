package de.jefa.garbage_application_suggestion_server.api.controller;

import ch.qos.logback.classic.pattern.DateConverter;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickups;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionPickupDistrictsService;
import de.jefa.garbage_application_suggestion_server.api.service.SuggestionPickupsService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/suggestion_pickups")
public class SuggestionPickupsController {

    private final SuggestionPickupsService suggestionPickupsService;

    public SuggestionPickupsController(SuggestionPickupsService suggestionPickupsService) {
        this.suggestionPickupsService = suggestionPickupsService;
    }

    @PostMapping("/create")
    public boolean createSuggestionPickupDistrict(@RequestParam String date, @RequestParam Long suggestionRef, @RequestParam Long suggestionTrashTypeRef, @RequestParam Long suggestionPickupDistrictRef) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final java.util.Date utilDate = dateFormat.parse(date);
        return suggestionPickupsService.createSuggestionPickup(new Date(utilDate.getTime()), suggestionRef, suggestionPickupDistrictRef, suggestionTrashTypeRef);
    }

    @GetMapping("/{suggestionRef}&{suggestionTrashTypeRef}&{suggestionPickupDistrictRef}")
    public List<TbSuggestionPickups> findByNameAndSuggestionRef(@PathVariable Long suggestionRef, @PathVariable Long suggestionTrashTypeRef, @PathVariable Long suggestionPickupDistrictRef) {
        return suggestionPickupsService.findBySuggestionRefAndSuggestionTrashTypeRefAndSuggestionPickupDistrictRef(suggestionRef, suggestionPickupDistrictRef, suggestionTrashTypeRef);
    }
}