package com.jc.studyjpasample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.studyjpasample.domain.Hello;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Long> {
}
