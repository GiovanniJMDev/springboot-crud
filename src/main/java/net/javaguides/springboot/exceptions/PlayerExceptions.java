package net.javaguides.springboot.exceptions;

public class PlayerExceptions {

    public static class PlayerNotFoundException extends RuntimeException {
        public PlayerNotFoundException(Long id) {
            super("Player with ID " + id + " not found.");
        }
    }

    public static class InvalidPlayerDataException extends RuntimeException {
        public InvalidPlayerDataException(String message) {
            super("Invalid player data: " + message);
        }
    }

    public static class PlayerAlreadyExistsException extends RuntimeException {
        public PlayerAlreadyExistsException(String fieldName, String value) {
            super("A player with " + fieldName + ": " + value + " already exists.");
        }
    }

    public static class PlayerDeletionException extends RuntimeException {
        public PlayerDeletionException(Long id) {
            super("Failed to delete player with ID " + id + ".");
        }
    }
}
