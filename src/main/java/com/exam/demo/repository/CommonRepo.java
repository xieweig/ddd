package com.exam.demo.repository;

import com.exam.demo.entity.base.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonRepo<T extends BaseEntity> extends JpaRepository<T, Long> {


}
