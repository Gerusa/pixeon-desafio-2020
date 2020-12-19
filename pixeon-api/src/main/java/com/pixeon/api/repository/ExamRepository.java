package com.pixeon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeon.api.model.Exam;

/**
 * @author Gerusa
 *
 */
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
