package com.assesment.mPokket.service.impl;

import com.assesment.mPokket.constant.ErrorConstant;
import com.assesment.mPokket.entity.PhoneBook;
import com.assesment.mPokket.entity.dto.PhoneBookDto;
import com.assesment.mPokket.exception.ResourceNotFoundException;
import com.assesment.mPokket.repository.PhoneBookRepository;
import com.assesment.mPokket.service.PhoneBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private PhoneBookRepository phoneBookRepository;

    private PhoneBookServiceImpl(PhoneBookRepository phoneBookRepo) {
        this.phoneBookRepository = phoneBookRepo;
    }

    @Override
    public PhoneBook createPhoneRecorde(PhoneBookDto phoneBookDto) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setFirstName(phoneBookDto.getFirstName());
        phoneBook.setLastName(phoneBookDto.getLastName());
        phoneBook.setPhoneNumber(phoneBookDto.getPhoneNumber());
        return phoneBookRepository.save(phoneBook);
    }

    @Override
    public PhoneBook getPhoneBookById(String id) {

        Optional<PhoneBook> phoneBook = phoneBookRepository.findById(Long.valueOf(id));
        if(phoneBook.isPresent()) {
            return phoneBook.get();
        }else{
            throw new ResourceNotFoundException(ErrorConstant.RECORD_NOT_FOUND + id);
        }
    }

    @Override
    public List<PhoneBook> getAllPhoneRecords() {
        return (List<PhoneBook>) phoneBookRepository.findAll();
    }

    @Override
    public PhoneBook updatePhoneBookRecord(String id, PhoneBookDto phoneBookDto) {
        Optional<PhoneBook> phoneBook1 = phoneBookRepository.findById(Long.valueOf(id));
        if (phoneBook1.isPresent()) {
            PhoneBook phoneBook = phoneBook1.get();
            phoneBook.setFirstName(phoneBookDto.getFirstName());
            phoneBook.setLastName(phoneBookDto.getLastName());
            phoneBook.setPhoneNumber(phoneBookDto.getPhoneNumber());
            return phoneBookRepository.save(phoneBook);
        } else {
            throw new ResourceNotFoundException(ErrorConstant.RECORD_NOT_FOUND + id);
        }

    }

    @Override
    public void deleteRecordById(String id) {
        phoneBookRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void deleteAllRecords() {
        phoneBookRepository.deleteAll();
    }
}
