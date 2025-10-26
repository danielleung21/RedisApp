package com.daniel.topaz.rba.repo;

import com.daniel.topaz.rba.dm.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
