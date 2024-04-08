package com.jpa.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Applicant")
@Table(name = "APPLICANT")
public class Applicant {

    @Id
    @GeneratedValue(generator = "sequence_app_id")
    @GenericGenerator(name = "sequence_app_id", strategy = "sequence")
    private Integer id;

    private String applicantId;

    private String name;

    private String email;

    private String phoneNumber;

    public Applicant() {

    }

    public Applicant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    @PrePersist
    public void printId() {
        System.out.println("=================== " + getApplicantId());
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}