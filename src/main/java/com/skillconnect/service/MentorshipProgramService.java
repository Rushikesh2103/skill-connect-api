package com.skillconnect.service;

import com.skillconnect.model.MentorshipProgram;
import java.util.List;
import java.util.Optional;

public interface MentorshipProgramService {
    List<MentorshipProgram> getAllMentorshipPrograms();
    Optional<MentorshipProgram> getMentorshipProgramById(int id);
    MentorshipProgram saveMentorshipProgram(MentorshipProgram mentorshipProgram);
    void deleteMentorshipProgram(int id);
}
