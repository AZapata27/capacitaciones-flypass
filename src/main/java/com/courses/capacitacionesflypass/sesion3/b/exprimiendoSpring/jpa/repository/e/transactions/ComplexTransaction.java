package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.e.transactions;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;


@RequiredArgsConstructor
public class ComplexTransaction implements TransactionCallback<Void> {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    private final String username;
    private final String email;
    private final String postTitle;

    @Override
    public Void doInTransaction(TransactionStatus status) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            userRepository.save(user);

            Post post = new Post();
            post.setTitle(postTitle);
            post.setAuthor(user);
            postRepository.save(post);


            Object primerSavePoint =  status.createSavepoint(); //Punto de guardado

            try {
                //Aqui podemos hace cualquier cosa otras operaciones de guardado etc

                // imaginemos que algo falla en este punto

            } catch (Exception e) {
                status.rollbackToSavepoint(primerSavePoint); // Rollback a un punto de guardado
            } finally {

                status.releaseSavepoint(primerSavePoint); // Liberar un punto de guardado en transacciónes muy largas
            }





        } catch (Exception e) {
            status.setRollbackOnly(); // Marca la transacción para rollback
            throw e; // Propaga la excepción para manejarla en un nivel superior
        }

        return null;
    }
}
