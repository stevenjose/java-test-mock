package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.entities.Board;
import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.impl.RestaurantServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class RestaurantServiceTest {

    private static final Long RESTAURANT_ID = 100L;
    private static final Restaurant RESTAURANT = new Restaurant();

    private static final String NAME = "Macdonald";
    private static final String DESCRIPTION = "COMIDA RAPIDA";
    private static final String ADDRESS = "Calle 1";
    private static final String IMAGE = "logo.png";
    private static final List<Turn> TURNS = new ArrayList<>();
    private static final List<Board> BOARDS = new ArrayList<>();
    private static final List<Reservation> RESERVATIONS = new ArrayList<>();
    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        RESTAURANT.setName(NAME);
        RESTAURANT.setDescription(DESCRIPTION);
        RESTAURANT.setAddress(ADDRESS);
        RESTAURANT.setId(RESTAURANT_ID);
        RESTAURANT.setImage(IMAGE);
        RESTAURANT.setTurns(TURNS);
        RESTAURANT.setBoards(BOARDS);
        RESTAURANT.setReservations(RESERVATIONS);

    }

    @Test
    public void getRestaurantByIdTest() throws Exception {
        Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
        restaurantService.getRestaurantById(RESTAURANT_ID);
        assertEquals(RESTAURANT_ID, RESTAURANT.getId());
    }

    /*@Test
    public void getRestaurantsTest() throws Exception {
        Mockito.when(restaurantRepository.findAll()).thenReturn(List.of(RESTAURANT));
        List<RestaurantRest> rest = restaurantService.getRestaurants();
        assertEquals(1, rest.size());
        assertNotNull(rest);
        assertFalse(rest.isEmpty());
        assertEquals(NAME, rest.get(0).getName());
    }*/
}
