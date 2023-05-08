package com.assesment.mPokket.controller;

import com.assesment.mPokket.entity.PhoneBook;
import com.assesment.mPokket.entity.dto.PhoneBookDto;
import com.assesment.mPokket.service.PhoneBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/phone-book")
public class PhoneBookController {

    private PhoneBookService phoneBookService;

    @Autowired
    private PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @PostMapping()
    private ResponseEntity<PhoneBook> createPhoneBook(@RequestBody PhoneBookDto phoneBookDto) {
        try {
            PhoneBook phoneBook = phoneBookService.createPhoneRecorde(phoneBookDto);
            return new ResponseEntity<>(phoneBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneBook> getPhoneBookById(@PathVariable("id") String id) {
        PhoneBook phoneBook = phoneBookService.getPhoneBookById(id);
        return new ResponseEntity<>(phoneBook, HttpStatus.OK);
    }

    @GetMapping("/{lastname}")
    public ResponseEntity<PhoneBook> getPhoneBookByLastName(@PathVariable("last_name") String lastName) {
        PhoneBook phoneBook = phoneBookService.getPhoneBookByLastName(lastName);
        return new ResponseEntity<>(phoneBook, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PhoneBook>> getAllRecords() {
        List<PhoneBook> phoneBookList = phoneBookService.getAllPhoneRecords();
        return new ResponseEntity<>(phoneBookList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneBook> updateRecordById(@PathVariable("id") String id, @RequestBody PhoneBookDto phoneBookDto) {
        PhoneBook phoneBook = phoneBookService.updatePhoneBookRecord(id, phoneBookDto);
        return new ResponseEntity<>(phoneBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecordById(@PathVariable("id") String id) {
        phoneBookService.deleteRecordById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllRecord() {
        phoneBookService.deleteAllRecords();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
