package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Symptom {
    private String symptomId;
    private String symptomName;
    private String symptomTecId;
    private String symptomPreId;
    private String symptomMedId;
    private Integer isValid;

    @Id
    @Column(name = "symptom_id", nullable = false, length = 255)
    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    @Basic
    @Column(name = "symptom_name", nullable = true, length = 255)
    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    @Basic
    @Column(name = "symptom_tec_id", nullable = true, length = 255)
    public String getSymptomTecId() {
        return symptomTecId;
    }

    public void setSymptomTecId(String symptomTecId) {
        this.symptomTecId = symptomTecId;
    }

    @Basic
    @Column(name = "symptom_pre_id", nullable = true, length = 255)
    public String getSymptomPreId() {
        return symptomPreId;
    }

    public void setSymptomPreId(String symptomPreId) {
        this.symptomPreId = symptomPreId;
    }

    @Basic
    @Column(name = "symptom_med_id", nullable = true, length = 255)
    public String getSymptomMedId() {
        return symptomMedId;
    }

    public void setSymptomMedId(String symptomMedId) {
        this.symptomMedId = symptomMedId;
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

        Symptom symptom = (Symptom) o;

        if (symptomId != null ? !symptomId.equals(symptom.symptomId) : symptom.symptomId != null) return false;
        if (symptomName != null ? !symptomName.equals(symptom.symptomName) : symptom.symptomName != null) return false;
        if (symptomTecId != null ? !symptomTecId.equals(symptom.symptomTecId) : symptom.symptomTecId != null)
            return false;
        if (symptomPreId != null ? !symptomPreId.equals(symptom.symptomPreId) : symptom.symptomPreId != null)
            return false;
        if (symptomMedId != null ? !symptomMedId.equals(symptom.symptomMedId) : symptom.symptomMedId != null)
            return false;
        if (isValid != null ? !isValid.equals(symptom.isValid) : symptom.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = symptomId != null ? symptomId.hashCode() : 0;
        result = 31 * result + (symptomName != null ? symptomName.hashCode() : 0);
        result = 31 * result + (symptomTecId != null ? symptomTecId.hashCode() : 0);
        result = 31 * result + (symptomPreId != null ? symptomPreId.hashCode() : 0);
        result = 31 * result + (symptomMedId != null ? symptomMedId.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
