package com.jc.studyindexsample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleService {
	private final MemberRepository memberRepository;

	@Transactional
	public void save() {
		List<String> names = new ArrayList<>();
		List<String> locations = new ArrayList<>();
		List<String> jobs = new ArrayList<>();

		IntStream.range(0, 10)
			.forEach(i -> locations.add("location" + i));

		IntStream.range(0, 20)
			.forEach(i -> jobs.add("job" + i));

		IntStream.range(0, 30)
			.forEach(i -> names.add("name" + i));

		List<Member> collect = IntStream.range(0, 10000)
			.mapToObj(i -> new Member(names.get(i % 30), locations.get(i % 10), jobs.get(i % 20)))
			.collect(Collectors.toList());

		memberRepository.saveAll(collect);
	}
}
