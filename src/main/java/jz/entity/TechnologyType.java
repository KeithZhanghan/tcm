package jz.entity;

import javax.persistence.*;

@Entity
@Table(name = "technology_type", schema = "graduation")
public class TechnologyType {
    private String technologyTypeId;
    private String technologyTypeName;
    private String technologyClassify;
    private Integer isValid;

    @Id
    @Column(name = "technology_type_id", nullable = false, length = 255)
    public String getTechnologyTypeId() {
        return technologyTypeId;
    }

    public void setTechnologyTypeId(String technologyTypeId) {
        this.technologyTypeId = technologyTypeId;
    }

    @Basic
    @Column(name = "technology_type_name", nullable = true, length = 255)
    public String getTechnologyTypeName() {
        return technologyTypeName;
    }

    public void setTechnologyTypeName(String technologyTypeName) {
        this.technologyTypeName = technologyTypeName;
    }

    @Basic
    @Column(name = "technology_classify", nullable = true, length = 255)
    public String getTechnologyClassify() {
        return technologyClassify;
    }

    public void setTechnologyClassify(String technologyClassify) {
        this.technologyClassify = technologyClassify;
    }

    @Basic
    @Column(name = "is_valid", nullable = true)
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TechnologyType that = (TechnologyType) o;

        if (technologyTypeId != null ? !technologyTypeId.equals(that.technologyTypeId) : that.technologyTypeId != null)
            return false;
        if (technologyTypeName != null ? !technologyTypeName.equals(that.technologyTypeName) : that.technologyTypeName != null)
            return false;
        if (technologyClassify != null ? !technologyClassify.equals(that.technologyClassify) : that.technologyClassify != null)
            return false;
        if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = technologyTypeId != null ? technologyTypeId.hashCode() : 0;
        result = 31 * result + (technologyTypeName != null ? technologyTypeName.hashCode() : 0);
        result = 31 * result + (technologyClassify != null ? technologyClassify.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
