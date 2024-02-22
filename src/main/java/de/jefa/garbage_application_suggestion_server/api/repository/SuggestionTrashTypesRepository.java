package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionPickupDistricts;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTrashTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionTrashTypesRepository extends JpaRepository<TbSuggestionTrashTypes, Long> {

    TbSuggestionTrashTypes findByNameAndSuggestionRef(String name, Long suggestionRef);
}