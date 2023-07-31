package com.ipg.merchantservice.repository;

import com.ipg.merchantservice.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditRepository extends JpaRepository<Audit, String> { }
