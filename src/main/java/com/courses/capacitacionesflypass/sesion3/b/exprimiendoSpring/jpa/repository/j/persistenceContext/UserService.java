package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.j.persistenceContext;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Crear un nuevo usuario y persistirlo en la base de datos.
     */
    @Transactional
    public void createUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        // Persistir entidad, estado: Managed
        entityManager.persist(user);
        // La entidad es gestionada y sincronizada al final de la transacción
    }

    /**
     * Actualizar el email de un usuario existente.
     */
    @Transactional
    public void updateUser(Long id, String newEmail) {
        // Encontrar la entidad, estado: Managed
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setEmail(newEmail);
            // No es necesario llamar a persist() o merge(), la entidad ya está gestionada
        }
    }

    /**
     * Desasociar una entidad del contexto de persistencia y luego volver a asociarla.
     */
    @Transactional
    public void detachAndMerge(Long id, String newUsername) {
        // Encontrar la entidad, estado: Managed
        User user = entityManager.find(User.class, id);

        if (user != null) {
            // Desasociar la entidad, estado: Detached
            entityManager.detach(user);

            // Cambiar el estado mientras está detached (no sincronizado con la DB)
            user.setUsername(newUsername);

            // Volver a asociar la entidad al Persistence Context, estado: Managed
            entityManager.merge(user);
        }
    }

    /**
     * Eliminar un usuario por ID.
     */
    @Transactional
    public void deleteUser(Long id) {
        // Encontrar la entidad, estado: Managed
        User user = entityManager.find(User.class, id);
        if (user != null) {
            // Eliminar la entidad, estado: Removed
            entityManager.remove(user);
            // La entidad se eliminará de la base de datos al final de la transacción
        }
    }

    /**
     * Recuperar un usuario por ID.
     */
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        // Encontrar la entidad, estado: Managed
        return entityManager.find(User.class, id);
        // La entidad es gestionada y puede ser actualizada durante la transacción
    }
}
