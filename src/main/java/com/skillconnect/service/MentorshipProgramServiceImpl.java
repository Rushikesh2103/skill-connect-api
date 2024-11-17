package com.skillconnect.service;

import com.skillconnect.model.MentorshipProgram;
import com.skillconnect.repository.MentorshipProgramRepository;
import com.skillconnect.service.MentorshipProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorshipProgramServiceImpl implements MentorshipProgramService {

    @Autowired
    private MentorshipProgramRepository mentorshipProgramRepository;

    @Override
    public List<MentorshipProgram> getAllMentorshipPrograms() {
        return mentorshipProgramRepository.findAll();
    }

    @Override
    public Optional<MentorshipProgram> getMentorshipProgramById(int id) {
        return mentorshipProgramRepository.findById(id);
    }

    @Override
    public MentorshipProgram saveMentorshipProgram(MentorshipProgram mentorshipProgram) {
        return mentorshipProgramRepository.save(mentorshipProgram);
    }

    @Override
    public void deleteMentorshipProgram(int id) {
        mentorshipProgramRepository.deleteById(id);
    }
}
