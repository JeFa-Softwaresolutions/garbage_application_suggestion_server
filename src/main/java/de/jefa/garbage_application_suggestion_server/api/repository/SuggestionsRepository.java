package de.jefa.garbage_application_suggestion_server.api.repository;

import de.jefa.garbage_application_suggestion_server.api.model.TbSuggestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface SuggestionsRepository extends JpaRepository<TbSuggestions, Long> {

    @Query("SELECT s FROM TbSuggestions s WHERE s.cityName = :cityName AND s.stateSystemId = :stateSystemId AND s.districtSystemId = :districtSystemId AND s.createdBy = :userName")
    TbSuggestions findByCityNameStateSystemIdDistrictSystemIdAndUserName(@Param("cityName") String cityName, @Param("stateSystemId") String stateSystemId, @Param("districtSystemId") String districtSystemId, @Param("userName") String userName);

    List<TbSuggestions> findByCreatedBy(String createdBy);
}