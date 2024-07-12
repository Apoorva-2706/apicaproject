package com.apoorva.journal.service.controller;

import com.apoorva.journal.service.model.Journal;
import com.apoorva.journal.service.service.JournalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/journals")
public class JournalController{
    @Autowired
    private JournalService journalService;


    @GetMapping("/")
    public ResponseEntity<List<Journal>> getAllJournals(){
        return ResponseEntity.ok(journalService.getAllJournals());
    }

    @PostMapping("/log")
    public ResponseEntity<Journal> saveLog(@RequestBody Journal journal){
        return ResponseEntity.ok(journalService.saveLog(journal));
    }
}