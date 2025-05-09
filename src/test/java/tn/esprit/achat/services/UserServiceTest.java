package tn.esprit.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.achat.entities.User;
import tn.esprit.achat.repositories.UserRepository;

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
    public void testFindUserById() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("existinguser");
        
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        
        // Act
        User foundUser = userService.findUserById(1L);
        
        // Assert
        assertNotNull(foundUser);
        assertEquals("existinguser", foundUser.getUsername());
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        Long userId = 1L;
        doNothing().when(userRepository).deleteById(userId);
        
        // Act
        userService.deleteUser(userId);
        
        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }
}

// If you need the mock test implementation as well, you can add it here:
class UserServiceImplMockTest {
    // Your mock test implementation would go here
    // But typically you'd want this in a separate file
}