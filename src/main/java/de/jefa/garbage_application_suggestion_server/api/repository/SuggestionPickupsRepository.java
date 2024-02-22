package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionPickupsRepository extends JpaRepository<TbSuggestionPickups, Long> {

    List<TbSuggestionPickups> findBySuggestionRefAndSuggestionPickupDistrictRefAndSuggestionTrashTypeRef(Long suggestionRef, Long suggestionPickupDistrictRef, Long suggestionTrashTypeRef);
}