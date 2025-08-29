package com.example.uber.repositories;

import com.example.uber.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //jpa repo is a generic give the model class and id type


}
