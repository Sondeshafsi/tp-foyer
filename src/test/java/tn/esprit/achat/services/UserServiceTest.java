@Test
public void testRetrieveUser() {
    // Arrange
    User mockUser = new User("Bob");
    when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

    // Act
    User retrievedUser = userService.retrieveUser(1L);

    // Assert
    assertEquals("Bob", retrievedUser.getName());
    verify(userRepository, times(1)).findById(1L);
}

@Test
public void testDeleteUser() {
    // Arrange
    doNothing().when(userRepository).deleteById(1L);

    // Act
    userService.deleteUser(1L);

    // Assert
    verify(userRepository, times(1)).deleteById(1L);
}