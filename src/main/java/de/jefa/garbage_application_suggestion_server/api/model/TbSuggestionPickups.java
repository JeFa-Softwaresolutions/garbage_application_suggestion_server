package de.jefa.garbage_application_suggestion_server.api.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_suggestion_pickups", schema = "public", catalog = "db_garbage_test")
public class TbSuggestionPickups {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "autoid", nullable = false)
    private long autoid;

    @Basic
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "suggestion_ref", nullable = true)
    private Long suggestionRef;

    @Basic
    @Column(name = "suggestion_pickup_district_ref", nullable = true)
    private Long suggestionPickupDistrictRef;

    @Basic
    @Column(name = "suggestion_trash_type_ref", nullable = true)
    private Long suggestionTrashTypeRef;

    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSuggestionRef() {
        return suggestionRef;
    }

    public void setSuggestionRef(Long suggestionRef) {
        this.suggestionRef = suggestionRef;
    }

    public Long getSuggestionPickupDistrictRef() {
        return suggestionPickupDistrictRef;
    }

    public void setSuggestionPickupDistrictRef(Long suggestionPickupDistrictRef) {
        this.suggestionPickupDistrictRef = suggestionPickupDistrictRef;
    }

    public Long getSuggestionTrashTypeRef() {
        return suggestionTrashTypeRef;
    }

    public void setSuggestionTrashTypeRef(Long suggestionTrashTypeRef) {
        this.suggestionTrashTypeRef = suggestionTrashTypeRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSuggestionPickups that = (TbSuggestionPickups) o;
        return autoid == that.autoid && Objects.equals(date, that.date) && Objects.equals(suggestionRef, that.suggestionRef) && Objects.equals(suggestionPickupDistrictRef, that.suggestionPickupDistrictRef) && Objects.equals(suggestionTrashTypeRef, that.suggestionTrashTypeRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoid, date, suggestionRef, suggestionPickupDistrictRef, suggestionTrashTypeRef);
    }
}
