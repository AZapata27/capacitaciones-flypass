package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.e.transactions;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Post;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.User;
import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@RequiredArgsConstructor
public class BlogServiceManualTransaction {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final TransactionTemplate transactionTemplate;


    public void exampleCustomManualTrancation() {
        transactionTemplate.execute(status -> {

            /*

            savePaymentRequest(request); // DB

            callThePaymentProviderApi(request); // API

            updatePaymentState(request); // DB

            saveHistoryForAuditing(request); // DB

            callTheStockProviderApi(request); // API

            publishDomainEvent(request); // Event Bus


            status.createSavepoint(); // Punto de guardado

            */


            return null;
        });
    }


    public void createUserAndPost(String username, String email, String postTitle) {

        transactionTemplate.execute(status -> {
                try {

                    //Step 1
                    User user = new User();
                    user.setUsername(username);
                    user.setEmail(email);
                    userRepository.save(user);

                    Post post = new Post();
                    post.setTitle(postTitle);
                    post.setAuthor(user);
                    postRepository.save(post);

                    Object primerSavePoint =  status.createSavepoint(); //Punto de guardado

                    //Step 2

                    try {
                        //Aqui podemos hace cualquier cosa otras operaciones de guardado etc

                        // imaginemos que algo falla en este punto

                    } catch (Exception e) {
                        status.rollbackToSavepoint(primerSavePoint); // Rollback a un punto de guardado

                         // Reintentar la operación
                        // Guardar en que estado se quedó para luego reconstruir la transaccion
                        // Realizar cualquier accion de compensacion solo para el step 2 ya que el step 1 ya se realizó okey

                        // si ya nada funciona y se necesita hacer un rollback completo se puede hacer un rollback completo lanzando excepcion

                    }



                } catch (Exception e) {
                    status.setRollbackOnly(); // Marca la transacción para rollback
                    throw e; // Propaga la excepción para manejarla en un nivel superior
                }

                return null;
        });
    }


    public void createNewTransactionImplementation(String username, String email, String postTitle) {

        ComplexTransaction complexTransaction = new ComplexTransaction(userRepository, postRepository, username, email, postTitle);

        transactionTemplate.execute(complexTransaction);
    }
}
