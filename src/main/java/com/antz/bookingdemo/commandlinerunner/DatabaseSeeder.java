package com.antz.bookingdemo.commandlinerunner;

import com.antz.bookingdemo.models.HotelBooking;
import com.antz.bookingdemo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner{
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings= new ArrayList<>();

        bookings.add(new HotelBooking("Marriot",200.00,3));
        bookings.add(new HotelBooking("Novotel",100.00,3));
        bookings.add(new HotelBooking("GreenPark",50.00,3));

        bookingRepository.saveAll(bookings);

    }
}