package com.assesment.mPokket.service;

import com.assesment.mPokket.entity.PhoneBook;
import com.assesment.mPokket.entity.dto.PhoneBookDto;

import java.util.List;

public interface PhoneBookService {

    PhoneBook createPhoneRecorde(PhoneBookDto phoneBookDto);

    PhoneBook getPhoneBookById(String id);
    PhoneBook getPhoneBookByLastName(String lastName);
    List<PhoneBook> getAllPhoneRecords();

    PhoneBook updatePhoneBookRecord(String id, PhoneBookDto phoneBookDto);

    void deleteRecordById(String id);

    void deleteAllRecords();
}
