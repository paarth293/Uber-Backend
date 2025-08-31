package com.example.uber.services;

import com.example.uber.models.Booking;
import com.example.uber.models.Review;
import com.example.uber.repositories.BookingRepository;
import com.example.uber.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServices implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewServices(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("******************");
        Review r = Review
                .builder()
                .content("Amazing ride quality")
                .rating(5.0)
                .build();

        Booking b = Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build();

        reviewRepository.save(r); // this code executes the sql query
        bookingRepository.save(b);

        System.out.println(r);

        System.out.println(r.getId());

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews) {
            System.out.println(r.getContent());
        }
    }
}
