package jz.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disease {
    private String diseaseId;
    private String diseaseTypeId;
    private String diseaseName;
    private String diseaseReason;
    private String diseaseDescribe;
    private String diseaseSymptomId;
    private Integer isValid;





    @Id
    @Column(name = "disease_id", nullable = false, length = 255)
    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    @Basic
    @Column(name = "disease_type_id", nullable = true, length = 255)
    public String getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(String diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "disease_name", nullable = true, length = 255)
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Basic
    @Column(name = "disease_reason", nullable = true, length = 255)
    public String getDiseaseReason() {
        return diseaseReason;
    }

    public void setDiseaseReason(String diseaseReason) {
        this.diseaseReason = diseaseReason;
    }

    @Basic
    @Column(name = "disease_describe", nullable = true, length = 255)
    public String getDiseaseDescribe() {
        return diseaseDescribe;
    }

    public void setDiseaseDescribe(String diseaseDescribe) {
        this.diseaseDescribe = diseaseDescribe;
    }

    @Basic
    @Column(name = "disease_symptom_id", nullable = true, length = 255)
    public String getDiseaseSymptomId() {
        return diseaseSymptomId;
    }

    public void setDiseaseSymptomId(String diseaseSymptomId) {
        this.diseaseSymptomId = diseaseSymptomId;
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

        Disease disease = (Disease) o;

        if (diseaseId != null ? !diseaseId.equals(disease.diseaseId) : disease.diseaseId != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(disease.diseaseTypeId) : disease.diseaseTypeId != null)
            return false;
        if (diseaseName != null ? !diseaseName.equals(disease.diseaseName) : disease.diseaseName != null) return false;
        if (diseaseReason != null ? !diseaseReason.equals(disease.diseaseReason) : disease.diseaseReason != null)
            return false;
        if (diseaseDescribe != null ? !diseaseDescribe.equals(disease.diseaseDescribe) : disease.diseaseDescribe != null)
            return false;
        if (diseaseSymptomId != null ? !diseaseSymptomId.equals(disease.diseaseSymptomId) : disease.diseaseSymptomId != null)
            return false;
        if (isValid != null ? !isValid.equals(disease.isValid) : disease.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diseaseId != null ? diseaseId.hashCode() : 0;
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (diseaseName != null ? diseaseName.hashCode() : 0);
        result = 31 * result + (diseaseReason != null ? diseaseReason.hashCode() : 0);
        result = 31 * result + (diseaseDescribe != null ? diseaseDescribe.hashCode() : 0);
        result = 31 * result + (diseaseSymptomId != null ? diseaseSymptomId.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
