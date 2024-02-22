package de.jefa.garbage_application_suggestion_server.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_suggestions", schema = "public", catalog = "db_garbage_test")
public class TbSuggestions {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "autoid", nullable = false)
    private long autoid;

    @Basic
    @Column(name = "city_name", nullable = false, length = 64)
    private String cityName;

    @Basic
    @Column(name = "link_to_informations", nullable = false, length = 128)
    private String linkToInformations;

    @Basic
    @Column(name = "need_streets_for_calc_flag", nullable = false)
    private boolean needStreetsForCalcFlag;

    @Basic
    @Column(name = "is_approved_flag", nullable = false)
    private boolean isApprovedFlag;

    @Basic
    @Column(name = "state_system_id", nullable = false, length = 8)
    private String stateSystemId;

    @Basic
    @Column(name = "district_system_id", nullable = false, length = 8)
    private String districtSystemId;

    @Basic
    @Column(name = "created_by", nullable = false, length = 64)
    @JsonIgnore
    private String createdBy;

    public long getAutoid() {
        return autoid;
    }

    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLinkToInformations() {
        return linkToInformations;
    }

    public void setLinkToInformations(String linkToInformations) {
        this.linkToInformations = linkToInformations;
    }

    public boolean isNeedStreetsForCalcFlag() {
        return needStreetsForCalcFlag;
    }

    public void setNeedStreetsForCalcFlag(boolean needStreetsForCalcFlag) {
        this.needStreetsForCalcFlag = needStreetsForCalcFlag;
    }

    public boolean isApprovedFlag() {
        return isApprovedFlag;
    }

    public void setApprovedFlag(boolean approvedFlag) {
        isApprovedFlag = approvedFlag;
    }

    public String getStateSystemId() {
        return stateSystemId;
    }

    public void setStateSystemId(String stateSystemId) {
        this.stateSystemId = stateSystemId;
    }

    public String getDistrictSystemId() {
        return districtSystemId;
    }

    public void setDistrictSystemId(String districtSystemId) {
        this.districtSystemId = districtSystemId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSuggestions that = (TbSuggestions) o;
        return autoid == that.autoid && needStreetsForCalcFlag == that.needStreetsForCalcFlag && isApprovedFlag == that.isApprovedFlag && Objects.equals(cityName, that.cityName) && Objects.equals(linkToInformations, that.linkToInformations) && Objects.equals(stateSystemId, that.stateSystemId) && Objects.equals(districtSystemId, that.districtSystemId) && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoid, cityName, linkToInformations, needStreetsForCalcFlag, isApprovedFlag, stateSystemId, districtSystemId, createdBy);
    }
}
