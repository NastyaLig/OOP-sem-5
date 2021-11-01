package com.example.oop_three;

public class Profession {
    public String name;
    public String surname;
    public String spinner;
    public String nameEducation;
    public String specialization;
    public Boolean getBox;
    public String company, job, Email;
    public Boolean val;

    public Profession (String name, String surname, String spinner, String nameEducation,
                       String specialization, Boolean getBox, String company, String job,
                       String Email, Boolean val){
        this.name = name;
        this.surname = surname;
        this.spinner = spinner;
        this.nameEducation = nameEducation;
        this.specialization = specialization;
        this.getBox = getBox;
        this.company = company;
        this.job = job;
        this.Email = Email;
        this.val = val;
    }
}
