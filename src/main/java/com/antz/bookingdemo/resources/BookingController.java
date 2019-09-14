package com.antz.bookingdemo.resources;

import com.antz.bookingdemo.models.HotelBooking;
import com.antz.bookingdemo.repository.BookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/bookings")
@Api(name = "Hotel booking API", description = "This is hotel booking API", stage = ApiStage.BETA)
public class BookingController {
    //private List<HotelBooking> bookings;
    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository)
    {
        this.bookingRepository = bookingRepository;

/*       bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot",200.00,3));
        bookings.add(new HotelBooking("Novotel",100.00,3));
       bookings.add(new HotelBooking("GreenPark",50.00,3));
 */
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ApiMethod(description = "Provide all bookings")
    public List<HotelBooking> getAll() {
        //return bookings;
        return bookingRepository.findAll();
    }

    @RequestMapping(value="/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Provide affordable bookings")
    public List<HotelBooking> affordable(@ApiPathParam(name = "price") @PathVariable double price)
    {
        //return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create new bookings")
    public List<HotelBooking> Create(@RequestBody HotelBooking hotelBooking){
        //bookings.add(hotelBooking);
        bookingRepository.save(hotelBooking);

        return bookingRepository.findAll();
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Delete a booking")
    public List<HotelBooking> Remove(@ApiPathParam(name = "id") @PathVariable Long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();

    }

}
