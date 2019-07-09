package jz.entity;

import javax.persistence.*;


public class DiseaseType {
    private String diseaseTypeId;
    private String diseaseClassify;
    private String diseaseTypeName;
    private Integer isValid;


    @Id
    @Column(name = "disease_type_id", nullable = false, length = 255)
    public String getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(String diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "disease_classify", nullable = true, length = 255)
    public String getDiseaseClassify() {
        return diseaseClassify;
    }

    public void setDiseaseClassify(String diseaseClassify) {
        this.diseaseClassify = diseaseClassify;
    }

    @Basic
    @Column(name = "disease_type_name", nullable = true, length = 255)
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
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

        DiseaseType that = (DiseaseType) o;

        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (diseaseClassify != null ? !diseaseClassify.equals(that.diseaseClassify) : that.diseaseClassify != null)
            return false;
        if (diseaseTypeName != null ? !diseaseTypeName.equals(that.diseaseTypeName) : that.diseaseTypeName != null)
            return false;
        if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diseaseTypeId != null ? diseaseTypeId.hashCode() : 0;
        result = 31 * result + (diseaseClassify != null ? diseaseClassify.hashCode() : 0);
        result = 31 * result + (diseaseTypeName != null ? diseaseTypeName.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        return result;
    }
}
