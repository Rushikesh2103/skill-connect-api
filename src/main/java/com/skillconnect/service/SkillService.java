package com.skillconnect.service;

import com.skillconnect.model.Skill;
import java.util.List;
import java.util.Optional;

public interface SkillService {
    List<Skill> getAllSkills();
    Optional<Skill> getSkillById(int id);
    Skill saveSkill(Skill skill);
    void deleteSkill(int id);
}
