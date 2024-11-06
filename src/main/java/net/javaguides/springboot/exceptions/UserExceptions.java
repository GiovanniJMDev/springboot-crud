package net.javaguides.springboot.exceptions;

public class UserExceptions {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(Long id) {
            super("Usuario con ID " + id + " no encontrado.");
        }
    }

    public static class InvalidUserDataException extends RuntimeException {
        public InvalidUserDataException(String message) {
            super("Datos de usuario no válidos: " + message);
        }
    }

    public static class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String fieldName, String value) {
            super("Ya existe un usuario con " + fieldName + ": " + value);
        }
    }

    public static class UserDeletionException extends RuntimeException {
        public UserDeletionException(Long id) {
            super("No se pudo eliminar el usuario con ID " + id + ".");
        }
    }
}
