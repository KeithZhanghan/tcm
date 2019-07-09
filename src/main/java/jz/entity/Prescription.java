package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prescription {
    private String prescriptionId;
    private String prescriptionName;
    private String prescriptionMedId;
    private String prescriptionDescribe;
    private Integer isValid;

    @Id
    @Column(name = "prescription_id", nullable = false, length = 255)
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Basic
    @Column(name = "prescription_name", nullable = true, length = 255)
    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    @Basic
    @Column(name = "prescription_med_id", nullable = true, length = 255)
    public String getPrescriptionMedId() {
        return prescriptionMedId;
    }

    public void setPrescriptionMedId(String prescriptionMedId) {
        this.prescriptionMedId = prescriptionMedId;
    }

    @Basic
    @Column(name = "prescription_describe", nullable = true, length = 255)
    public String getPrescriptionDescribe() {
        return prescriptionDescribe;
    }

    public void setPrescriptionDescribe(String prescriptionDescribe) {
        this.prescriptionDescribe = prescriptionDescribe;
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

        Prescription that = (Prescription) o;

        if (prescriptionId != null ? !prescriptionId.equals(that.prescriptionId) : that.prescriptionId != null)
            return false;
        if (prescriptionName != null ? !prescriptionName.equals(that.prescriptionName) : that.prescriptionName != null)
            return false;
        if (prescriptionMedId != null ? !prescriptionMedId.equals(that.prescriptionMedId) : that.prescriptionMedId != null)
            return false;
        if (prescriptionDescribe != null ? !prescriptionDescribe.equals(that.prescriptionDescribe) : that.prescriptionDescribe != null)
            return false;
        if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prescriptionId != null ? prescriptionId.hashCode() : 0;
        result = 31 * result + (prescriptionName != null ? prescriptionName.hashCode() : 0);
        result = 31 * result + (prescriptionMedId != null ? prescriptionMedId.hashCode() : 0);
        result = 31 * result + (prescriptionDescribe != null ? prescriptionDescribe.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
