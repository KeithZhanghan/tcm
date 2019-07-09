package jz.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicine_type", schema = "graduation")
public class MedicineType {
    private String medicineTypeId;
    private String medicineTypeName;
    private String medicineClassify;
    private Integer isValid;

    @Id
    @Column(name = "medicine_type_id", nullable = false, length = 255)
    public String getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(String medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    @Basic
    @Column(name = "medicine_type_name", nullable = true, length = 255)
    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }

    @Basic
    @Column(name = "medicine_classify", nullable = true, length = 255)
    public String getMedicineClassify() {
        return medicineClassify;
    }

    public void setMedicineClassify(String medicineClassify) {
        this.medicineClassify = medicineClassify;
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

        MedicineType that = (MedicineType) o;

        if (medicineTypeId != null ? !medicineTypeId.equals(that.medicineTypeId) : that.medicineTypeId != null)
            return false;
        if (medicineTypeName != null ? !medicineTypeName.equals(that.medicineTypeName) : that.medicineTypeName != null)
            return false;
        if (medicineClassify != null ? !medicineClassify.equals(that.medicineClassify) : that.medicineClassify != null)
            return false;
        if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicineTypeId != null ? medicineTypeId.hashCode() : 0;
        result = 31 * result + (medicineTypeName != null ? medicineTypeName.hashCode() : 0);
        result = 31 * result + (medicineClassify != null ? medicineClassify.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
