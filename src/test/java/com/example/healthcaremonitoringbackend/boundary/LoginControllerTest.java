package com.example.healthcaremonitoringbackend.boundary;

import com.example.healthcaremonitoringbackend.entity.User;
import com.example.healthcaremonitoringbackend.repository.UserRepository;
import com.mysql.jdbc.exceptions.MySQLDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @InjectMocks
    private RegisterController registerController;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loginSuccess() {
        User user = new User();
        user.setUsername("gica");

        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca"))
                .thenReturn(user);

        User result = loginController.getUser("gica", "ciuperca");

        assertNotNull(result);
        assertEquals("gica", result.getUsername());
    }

    @Test
    public void loginFailed() {
        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca"))
                .thenReturn(null);

        User result = loginController.getUser("gica", "ciuperca");

        assertNull(result);
    }

    @Test(expected = MySQLDataException.class)
    public void loginException() {
        when(userRepository.findUserByUsernameAndPassword("gica", "ciuperca"))
                .thenThrow(MySQLDataException.class);

        User result = loginController.getUser("gica", "ciuperca");
    }

    @Test
    public void createUserSuccessfuly() throws Exception {
        when(userRepository.findUserByUsername(eq("Mara"))).thenReturn(null);
        doAnswer(returnsFirstArg()).when(userRepository).save(any(User.class));
        String resultSave = registerController.addNewUser("Mara");
        assertEquals("Saved", resultSave);
        assertNotNull(resultSave);
    }

//    @Test(expected = InvalidClientNameException.class)
//    public void createClientWithEmptyName() throws Exception {
//        registerController.addNewUser("");
//    }





}
