package com.apoorva.journal.service.service;


import com.apoorva.journal.service.model.Journal;
import com.apoorva.journal.service.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService{
    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "journal-group")
    public void consumeUserEvent(String event){
        Journal journal = new Journal();
        journal.setEvent(event);
        journal.setTimestamp(LocalDateTime.now());
        journalRepository.save(journal);
    }

    public List<Journal> getAllJournals(){
        return journalRepository.findAll();
    }

    public Journal saveLog(Journal journal){
        return journalRepository.save(journal);
    }
    
}