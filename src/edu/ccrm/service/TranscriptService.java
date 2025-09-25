package edu.ccrm.service;

import edu.ccrm.domain.*;

public interface TranscriptService {
    void recordGrade(Student student, Course course, String letterGrade);
    void printTranscript(Student student);
}
