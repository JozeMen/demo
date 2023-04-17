package com.kursach.demo.repository;

import com.kursach.demo.entity.Committee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitteeRepository extends JpaRepository<Committee, String> {
    List<Committee> findAll();

    Committee findCommitteeByName(String comName);

    int deleteCommitteeByName(String name);
}
