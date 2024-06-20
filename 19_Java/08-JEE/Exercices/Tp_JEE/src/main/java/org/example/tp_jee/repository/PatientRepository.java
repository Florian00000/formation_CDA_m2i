package org.example.tp_jee.repository;

import org.example.tp_jee.models.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {

    public PatientRepository(Session _session) {
        super(_session);
    }

    @Override
    public Patient findById(int id) {
        return (Patient) _session.get(Patient.class, id);
    }

    @Override
    public List<Patient> findAll() {
        return _session.createQuery("from Patient", Patient.class).list();
    }
}
