package de.karnik.auverso.data.repositories;

import de.karnik.auverso.data.models.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, String> {
  @Override
  Optional<Contact> findById(String id);

  @Override
  void delete(Contact deleted);
}