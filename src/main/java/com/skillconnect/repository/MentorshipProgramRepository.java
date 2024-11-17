package com.skillconnect.repository;

import com.skillconnect.model.MentorshipProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorshipProgramRepository extends JpaRepository<MentorshipProgram, Integer> {
    
}
