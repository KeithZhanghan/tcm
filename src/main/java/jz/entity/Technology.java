package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Technology {
    private String technologyId;
    private String technologyTypeId;
    private String technologyName;
    private String technologyDescribe;
    private Integer isValid;

    @Id
    @Column(name = "technology_id", nullable = false, length = 255)
    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    @Basic
    @Column(name = "technology_type_id", nullable = true, length = 255)
    public String getTechnologyTypeId() {
        return technologyTypeId;
    }

    public void setTechnologyTypeId(String technologyTypeId) {
        this.technologyTypeId = technologyTypeId;
    }

    @Basic
    @Column(name = "technology_name", nullable = true, length = 255)
    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    @Basic
    @Column(name = "technology_describe", nullable = true, length = 255)
    public String getTechnologyDescribe() {
        return technologyDescribe;
    }

    public void setTechnologyDescribe(String technologyDescribe) {
        this.technologyDescribe = technologyDescribe;
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

        Technology that = (Technology) o;

        if (technologyId != null ? !technologyId.equals(that.technologyId) : that.technologyId != null) return false;
        if (technologyTypeId != null ? !technologyTypeId.equals(that.technologyTypeId) : that.technologyTypeId != null)
            return false;
        if (technologyName != null ? !technologyName.equals(that.technologyName) : that.technologyName != null)
            return false;
        if (technologyDescribe != null ? !technologyDescribe.equals(that.technologyDescribe) : that.technologyDescribe != null)
            return false;
        if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = technologyId != null ? technologyId.hashCode() : 0;
        result = 31 * result + (technologyTypeId != null ? technologyTypeId.hashCode() : 0);
        result = 31 * result + (technologyName != null ? technologyName.hashCode() : 0);
        result = 31 * result + (technologyDescribe != null ? technologyDescribe.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
