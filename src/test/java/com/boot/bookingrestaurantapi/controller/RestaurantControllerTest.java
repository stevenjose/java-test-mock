package com.boot.bookingrestaurantapi.controller;

import com.boot.bookingrestaurantapi.controllers.RestaurantController;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.jsons.TurnRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantControllerTest {

    private static final Long RESTAURANT_ID = 100L;
    private static final String SUCCESS_CODE = "200 OK";
    private static final String SUCCESS_STATUS = "Success";
    private static final String OK = "OK";
    private static final  RestaurantRest RESTAURANT = new RestaurantRest();

    private static final String NAME = "Macdonald";
    private static final String DESCRIPTION = "COMIDA RAPIDA";
    private static final String ADDRESS = "Calle 1";
    private static final String IMAGE = "logo.png";
    private static final List<TurnRest> TURN_REST = new ArrayList<>();

    @Mock
    RestaurantService restaurantService;

    @InjectMocks
    RestaurantController restaurantController;

    @Before
    public void init() throws BookingException {
        MockitoAnnotations.initMocks(this);
        RESTAURANT.setName(NAME);
        RESTAURANT.setDescription(DESCRIPTION);
        RESTAURANT.setAddress(ADDRESS);
        RESTAURANT.setId(RESTAURANT_ID);
        RESTAURANT.setImage(IMAGE);
        RESTAURANT.setTurns(TURN_REST);

        Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT);
        List<RestaurantRest> rest = Arrays.asList(RESTAURANT);
        Mockito.when(restaurantService.getRestaurants()).thenReturn(rest);
    }

    @Test
    public void getRestaurantByIdTest() throws BookingException {
        final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);
        assert response.getCode().equals(SUCCESS_CODE);
        assert response.getStatus().equals(SUCCESS_STATUS);
        assert response.getMessage().equals(OK);
        assert response.getData().equals(RESTAURANT);
    }

    @Test
    public void getRestaurantsTest() throws BookingException {
        final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurants();
        assert response.getCode().equals(SUCCESS_CODE);
        assert response.getStatus().equals(SUCCESS_STATUS);
        assert response.getMessage().equals(OK);
        assert response.getData().size() > 0;
    }

}
