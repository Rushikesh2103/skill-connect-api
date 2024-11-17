package com.skillconnect.service;

import com.skillconnect.model.Skill;
import com.skillconnect.repository.SkillRepository;
import com.skillconnect.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> getSkillById(int id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }
}
