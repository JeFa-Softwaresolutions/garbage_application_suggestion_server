package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionPickupDistrictsRepository extends JpaRepository<TbSuggestionPickupDistricts, Long> {

    TbSuggestionPickupDistricts findByNameAndSuggestionRef(String name, Long suggestionRef);
}