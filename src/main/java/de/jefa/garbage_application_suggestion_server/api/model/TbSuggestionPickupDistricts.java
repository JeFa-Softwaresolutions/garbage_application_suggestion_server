package de.jefa.garbage_application_suggestion_server.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_suggestion_pickup_districts", schema = "public", catalog = "db_garbage_test")
public class TbSuggestionPickupDistricts {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "autoid", nullable = false)
    private long autoid;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Basic
    @Column(name = "suggestion_ref")
    private Long suggestionRef;

    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSuggestionRef() {
        return suggestionRef;
    }

    public void setSuggestionRef(Long suggestionRef) {
        this.suggestionRef = suggestionRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSuggestionPickupDistricts that = (TbSuggestionPickupDistricts) o;
        return autoid == that.autoid && Objects.equals(name, that.name) && Objects.equals(suggestionRef, that.suggestionRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoid, name, suggestionRef);
    }
}
