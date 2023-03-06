package com.jc.dbreplicasample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jc.dbreplicasample.domain.Sample;
import com.jc.dbreplicasample.dto.RequestAddSampleDto;
import com.jc.dbreplicasample.dto.ResponseSampleDto;
import com.jc.dbreplicasample.repository.SampleRepository;

@Service
public class SampleService {
	private final SampleRepository sampleRepository;

	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}

	@Transactional
	public void addSample(RequestAddSampleDto requestAddSampleDto) {
		Sample sample = new Sample(requestAddSampleDto.getName());
		sampleRepository.save(sample);
	}

	@Transactional(readOnly = true)
	public List<ResponseSampleDto> findAllSamples() {
		List<Sample> all = sampleRepository.findAll();
		System.out.println("all.size() = " + all.size());
		return all.stream()
			.map(ResponseSampleDto::of)
			.collect(Collectors.toList());
	}
}
