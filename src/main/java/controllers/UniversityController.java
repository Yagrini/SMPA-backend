package controllers;

import entities.University;
import models.UniversityDAO;
import validators.UniversityValidator;

import java.util.Collection;

public class UniversityController {


    public Collection<University> index() {
        UniversityDAO universityDAO = new UniversityDAO();
        Collection<University> universities = universityDAO.getUniversities();
        return universities;
    }

    public Object store(University u) {
        UniversityValidator validator = new UniversityValidator();
        University university = validator.createUniversityValidation(u);
        return university;
    }
}
