package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionStreets;
import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionStreetsRepository extends JpaRepository<TbSuggestionStreets, Long> {

    TbSuggestionStreets findByNameAndSuggestionRef(String name, Long suggestionRef);
}
