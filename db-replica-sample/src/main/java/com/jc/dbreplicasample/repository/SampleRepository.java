package com.jc.dbreplicasample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.dbreplicasample.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
