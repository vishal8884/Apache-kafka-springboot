package com.springboot.repository;

import com.springboot.entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaDataRepository extends JpaRepository<WikiMediaData,Long> {
}
