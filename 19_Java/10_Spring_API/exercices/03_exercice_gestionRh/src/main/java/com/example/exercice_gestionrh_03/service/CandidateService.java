package com.example.exercice_gestionrh_03.service;

import com.example.exercice_gestionrh_03.dto.candidate.CandidateDtoGet;
import com.example.exercice_gestionrh_03.dto.candidate.CandidateDtoPost;
import com.example.exercice_gestionrh_03.entity.Candidate;
import com.example.exercice_gestionrh_03.exception.NotFoundException;
import com.example.exercice_gestionrh_03.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService implements BaseService<CandidateDtoPost, CandidateDtoGet> {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateDtoGet create(CandidateDtoPost candidateDtoPost) {
        Candidate candidate = candidateDtoPost.toCandidate();
        candidateRepository.save(candidate);
        return new CandidateDtoGet(candidate);
    }

    @Override
    public CandidateDtoGet update(int id, CandidateDtoPost candidateDtoPost) {
        Candidate candidate = candidateDtoPost.toCandidate();
        findCandidateByIdInData(id);
        candidate.setId(id);
        candidateRepository.save(candidate);
        return new CandidateDtoGet(candidate);
    }

    @Override
    public boolean delete(int id) {
        Candidate candidate = findCandidateByIdInData(id);
        candidateRepository.delete(candidate);
        return true;
    }

    @Override
    public CandidateDtoGet findById(int id) {
        Candidate candidate = findCandidateByIdInData(id);
        return new CandidateDtoGet(candidate);
    }

    @Override
    public List<CandidateDtoGet> findAll() {
        List<Candidate> candidateList = candidateRepository.findAll();
        return candidateList.stream().map(CandidateDtoGet::new).collect(Collectors.toList());
    }

    private Candidate findCandidateByIdInData(int id) {
        return candidateRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
