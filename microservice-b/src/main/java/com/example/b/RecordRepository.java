package com.example.b;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// NOTE: Replace 'com.yourcompany.model' with the actual package of your RecordEntity
import com.yourcompany.model.RecordEntity; 

@Repository
public interface RecordRepository extends JpaRepository<Person, Long> {
    // Spring Data JPA automatically provides methods like:
    // - save(RecordEntity)
    // - findById(Long)
    // - findAll()
    // - delete(RecordEntity)
}
