package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicine {
    private String medicineId;
    private String medicineTypeId;
    private String medicineName;
    private String medicineDescribe;
    private String medicineEfficacy;
    private String medicineImage;
    private Integer isValid;

    @Id
    @Column(name = "medicine_id", nullable = false, length = 255)
    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    @Basic
    @Column(name = "medicine_type_id", nullable = true, length = 255)
    public String getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(String medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    @Basic
    @Column(name = "medicine_name", nullable = true, length = 255)
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Basic
    @Column(name = "medicine_describe", nullable = true, length = 255)
    public String getMedicineDescribe() {
        return medicineDescribe;
    }

    public void setMedicineDescribe(String medicineDescribe) {
        this.medicineDescribe = medicineDescribe;
    }

    @Basic
    @Column(name = "medicine_efficacy", nullable = true, length = 255)
    public String getMedicineEfficacy() {
        return medicineEfficacy;
    }

    public void setMedicineEfficacy(String medicineEfficacy) {
        this.medicineEfficacy = medicineEfficacy;
    }

    @Basic
    @Column(name = "medicine_image", nullable = true, length = 255)
    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
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

        Medicine medicine = (Medicine) o;

        if (medicineId != null ? !medicineId.equals(medicine.medicineId) : medicine.medicineId != null) return false;
        if (medicineTypeId != null ? !medicineTypeId.equals(medicine.medicineTypeId) : medicine.medicineTypeId != null)
            return false;
        if (medicineName != null ? !medicineName.equals(medicine.medicineName) : medicine.medicineName != null)
            return false;
        if (medicineDescribe != null ? !medicineDescribe.equals(medicine.medicineDescribe) : medicine.medicineDescribe != null)
            return false;
        if (medicineEfficacy != null ? !medicineEfficacy.equals(medicine.medicineEfficacy) : medicine.medicineEfficacy != null)
            return false;
        if (medicineImage != null ? !medicineImage.equals(medicine.medicineImage) : medicine.medicineImage != null)
            return false;
        if (isValid != null ? !isValid.equals(medicine.isValid) : medicine.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicineId != null ? medicineId.hashCode() : 0;
        result = 31 * result + (medicineTypeId != null ? medicineTypeId.hashCode() : 0);
        result = 31 * result + (medicineName != null ? medicineName.hashCode() : 0);
        result = 31 * result + (medicineDescribe != null ? medicineDescribe.hashCode() : 0);
        result = 31 * result + (medicineEfficacy != null ? medicineEfficacy.hashCode() : 0);
        result = 31 * result + (medicineImage != null ? medicineImage.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
