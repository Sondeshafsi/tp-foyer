package tn.esprit.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.achat.entities.User;
import tn.esprit.achat.repositories.UserRepository;
import tn.esprit.achat.services.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testAddUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        
        when(userRepository.save(any(User.class))).thenReturn(user);
        
        // Act
        User savedUser = userService.addUser(user);
        
        // Assert
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }
    
    @Test
    public void testUpdateUser() {
        // Add your update test implementation here
    }
    
    @Test
    public void testDeleteUser() {
        // Add your delete test implementation here
    }
    
    // Add more test methods as needed
}