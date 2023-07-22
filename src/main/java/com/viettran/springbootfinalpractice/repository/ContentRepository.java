package com.viettran.springbootfinalpractice.repository;

import com.viettran.springbootfinalpractice.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
