package com.onlinetutor.onlinetutor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "tutorForm")
public class TutorForm {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "fName name is required")
private String fName;

@NotBlank(message = "LName name is required")
private String lName;

@NotBlank(message = "phoneNo name is required")
private String phoneNo;

@NotBlank(message = "nationalId name is required")
private String nationalId;

@NotBlank(message = "adress name is required")
private String adress;

private String address2;

@NotBlank(message = "city name is required")
private String city;

@NotBlank(message = "postalCode name is required")
private String postalCode;

@NotBlank(message = "First name is required")
private String qualification;

private String afStudy;

@NotBlank(message = "First name is required")
private String experience;

private String hRate;

@NotBlank(message = "First name is required")
private String identityDoc;

private String identityDocContentType;

@JsonIgnore
@Lob
private byte[] identityDocBytes;

@NotBlank(message = "scoreReportDoc name is required")
private String scoreReportDoc;

private String scoreReportDocContentType;

@JsonIgnore
@Lob
private byte[] scoreReportDocBytes;

@NotBlank(message = "TsCs name is required")
private String tsCs;

 @OneToOne
 @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
 @JsonIgnoreProperties("registrationForm")
  private User user;

public TutorForm(){}

public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}


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


public String getIdentityDoc() {
    return identityDoc;
}


public void setIdentityDoc(String identityDoc) {
    this.identityDoc = identityDoc;
}


public String getIdentityDocContentType() {
    return identityDocContentType;
}


public void setIdentityDocContentType(String identityDocContentType) {
    this.identityDocContentType = identityDocContentType;
}


public byte[] getIdentityDocBytes() {
    return identityDocBytes;
}


public void setIdentityDocBytes(byte[] identityDocBytes) {
    this.identityDocBytes = identityDocBytes;
}


public String getScoreReportDoc() {
    return scoreReportDoc;
}


public void setScoreReportDoc(String scoreReportDoc) {
    this.scoreReportDoc = scoreReportDoc;
}


public String getScoreReportDocContentType() {
    return scoreReportDocContentType;
}


public void setScoreReportDocContentType(String scoreReportDocContentType) {
    this.scoreReportDocContentType = scoreReportDocContentType;
}


public byte[] getScoreReportDocBytes() {
    return scoreReportDocBytes;
}


public void setScoreReportDocBytes(byte[] scoreReportDocBytes) {
    this.scoreReportDocBytes = scoreReportDocBytes;
}


public String getTsCs() {
    return tsCs;
}


public void setTsCs(String tsCs) {
    this.tsCs = tsCs;
}


public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}
     
}
