package com.assesment.mPokket.repository;

import com.assesment.mPokket.entity.PhoneBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneBookRepository extends CrudRepository<PhoneBook, Long> {

    Optional<PhoneBook> findByLastName(String lastName);
}
