package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.User;
import tn.esprit.rh.achat.repositories.UserRepository;
import tn.esprit.rh.achat.services.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Required for Mockito annotations
public class UserServiceImplMockTest {

    // Mock dependencies (e.g., Repository)
    @Mock
    private UserRepository userRepository; // Option 1: Annotation-based mock

    // Alternative (if not using annotations):
    // private UserRepository userRepository = Mockito.mock(UserRepository.class);

    // Inject mocks into the service under test
    @InjectMocks
    private UserServiceImpl userService; // Mockito will inject @Mock into this

    @Test
    public void testAddUser() {
        // 1. Arrange: Define test data & mock behavior
        User user = new User();
        user.setName("Alice");

        when(userRepository.save(any(User.class))).thenReturn(user); // Mock save()

        // 2. Act: Call the service method
        User savedUser = userService.addUser(user);

        // 3. Assert: Verify results and interactions
        assertEquals("Alice", savedUser.getName());
        verify(userRepository, times(1)).save(user); // Check if save() was called
		
		
    }
}