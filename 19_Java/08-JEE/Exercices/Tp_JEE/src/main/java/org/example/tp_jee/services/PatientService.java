package org.example.tp_jee.services;

import org.example.tp_jee.models.Patient;
import org.example.tp_jee.repository.PatientRepository;
import org.example.tp_jee.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class PatientService {

    private PatientRepository patientRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public PatientService() {
        this.sessionFactory = HibernateSession.getSessionFactory();
    }

    public boolean createPatient(String name, String firstName, LocalDate birthDate, String photo) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        patientRepository = new PatientRepository(session);
        Patient patient = Patient.builder().name(name).firstName(firstName).birthDate(birthDate).photo(photo).build();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except) {
            try{
                session.getTransaction().rollback();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }

    public List<Patient> getAllPatients() {
        session = sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        List<Patient> patients = patientRepository.findAll();
        session.close();
        return patients;
    }
}
