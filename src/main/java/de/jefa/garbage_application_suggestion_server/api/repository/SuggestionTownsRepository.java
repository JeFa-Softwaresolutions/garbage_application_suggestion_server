package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestionTowns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionTownsRepository extends JpaRepository<TbSuggestionTowns, Long> {

    TbSuggestionTowns findByNameAndSuggestionRef(String name, Long suggestionRef);
}