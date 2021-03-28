package br.com.rodrigogmartins.restwithspringboot.repositories;

import br.com.rodrigogmartins.restwithspringboot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
