package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.Food;
import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.FoodRepository;
import com.mysql.jdbc.exceptions.MySQLDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodControllerTest {

    @InjectMocks
    private FoodController foodController;

    @Mock
    private FoodRepository foodRepository;

    @Test
    public void searchFoodSucces() {
        Food food = new Food();
        food.setFoodname("Melon");

        when(foodRepository.findFoodByFoodname("Melon"))
                .thenReturn(food);

        Food result = foodController.getFood("Melon");

        assertNotNull(result);
        assertEquals("Melon", result.getFoodname());
    }

    @Test
    public void searchFoodFailed() {
        when(foodRepository.findFoodByFoodname("Melon"))
                .thenReturn(null);

        Food result = foodController.getFood("Melon");

        assertNull(result);
    }

    @Test(expected = MySQLDataException.class)
    public void searchFoodException() {
        when(foodRepository.findFoodByFoodname("Melon"))
                .thenThrow(MySQLDataException.class);

        Food result = foodController.getFood("Melon");
    }

    @Test
    public void deleteFoodSuccess() throws Exception  {

        Food food=new Food();
        food.setId((long)5);

        doNothing().when(foodRepository).delete(food);
        FoodRepository my = Mockito.mock(FoodRepository.class);
        // Act
        String resultDelete= foodController.deleteFood((long)5);
        // Assert
        // verify(favoriteBookRepository, times(1)).delete((long) 5);
        assertEquals("Food deleted", resultDelete);
        assertNotNull(resultDelete);
    }

}
