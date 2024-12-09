package com.onlinetutor.onlinetutor.DTO;

import org.springframework.web.multipart.MultipartFile;

public class TutorFormRequestDTO {

    private String fName;
    private String lName;
    private String phoneNo;
    private String nationalId;
    private String adress;
    private String address2;
    private String city;
    private String postalCode;
    private String qualification;
    private String afStudy;
    private String experience;
    private String hRate;
    private String tsCs;

    private MultipartFile identityDoc;
    private MultipartFile scoreReportDoc;
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getNationalId() {
        return nationalId;
    }
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getAfStudy() {
        return afStudy;
    }
    public void setAfStudy(String afStudy) {
        this.afStudy = afStudy;
    }
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String gethRate() {
        return hRate;
    }
    public void sethRate(String hRate) {
        this.hRate = hRate;
    }
    public String getTsCs() {
        return tsCs;
    }
    public void setTsCs(String tsCs) {
        this.tsCs = tsCs;
    }
    public MultipartFile getIdentityDoc() {
        return identityDoc;
    }
    public void setIdentityDoc(MultipartFile identityDoc) {
        this.identityDoc = identityDoc;
    }
    public MultipartFile getScoreReportDoc() {
        return scoreReportDoc;
    }
    public void setScoreReportDoc(MultipartFile scoreReportDoc) {
        this.scoreReportDoc = scoreReportDoc;
    }

  
}
