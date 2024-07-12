package com.apoorva.journal.service.repository;

import com.apoorva.journal.service.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long>{}