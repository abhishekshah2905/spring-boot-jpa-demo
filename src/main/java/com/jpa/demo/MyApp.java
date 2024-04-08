package com.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public void run(String... strings) throws Exception {
        Applicant applicant1 = new Applicant("abhishek rai-1", "abhishek.shah@email.com", "+1-990-980-9877");
        Applicant applicant2 = new Applicant("abhishek rai-2", "abhishek.shah@email.com", "+1-990-980-9877");
        Applicant applicant3 = new Applicant("abhishek rai-3", "abhishek.shah@email.com", "+1-990-980-9877");
        Applicant applicant4 = new Applicant("abhishek rai-4", "abhishek.shah@email.com", "+1-990-980-9877");
        List<Applicant> applicants = Arrays.asList(applicant1, applicant2, applicant3, applicant4);

        applicants.forEach(applicant -> {
            applicant.setName(applicant.getName() + UUID.randomUUID());
            Applicant saved = applicantRepository.save(applicant);
        });

//        List<Applicant> savedApplicants = applicantRepository.saveAll(applicants);

//        System.out.println(savedApplicants);

        System.out.println("-------------All applicants----------------");
        applicantRepository.findAll().forEach(System.out::println);

        System.out.println("-------------Deleting----------------");
        applicantRepository.deleteById("I-3");

        Applicant applicant = new Applicant("abhishek shah", "abhishek.shah@email.com", "+1-990-980-9877");
        Applicant saved = applicantRepository.save(applicant);
        System.out.println("-------------All applicants----------------");
        applicantRepository.findAll().forEach(System.out::println);
    }
}
