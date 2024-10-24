package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check to make sure a city can not be found
     * add the new city to the list
     * check if the new city is now found in the list
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        assertEquals(list.hasCity(mockCity), false);
        list.addCity(mockCity);
        assertEquals(list.hasCity(mockCity), true);
    }

    /**
     * check to make sure a city can not be found
     * test to throw illegal argument exception when the city is not in the list
     * add the new city to the list
     * check if the new city is now found in the list
     * remove the city from the list
     * check to see that the city is now not in the list
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        assertEquals(list.hasCity(mockCity), false);
        assertThrows(IllegalArgumentException.class, () -> {list.deleteCity(mockCity);});
        list.addCity(mockCity);
        assertEquals(list.hasCity(mockCity), true);
        list.deleteCity(mockCity);
        assertEquals(list.hasCity(mockCity), false);
    }

    /**
     * check if it gets the count of cities in the list
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        assertEquals(list.countCities(), list.getCount());
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(),listSize + 1);
    }

}
