package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.g.locking;

import com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.entity.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Por defecto es NONE
    @Lock(LockModeType.NONE)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithNoneLock(Long id);


    /**
     * Aplica un bloqueo optimista en la entidad `Product` con el ID dado.
     * Este método se utiliza cuando se espera que las colisiones de acceso concurrente sean raras.
     * Utiliza un campo de versión para detectar cambios concurrentes.
     *
     * Caso de uso: Cuando se realizan múltiples lecturas concurrentes y actualizaciones esporádicas.
     * Necesario para: Asegurar que las actualizaciones no sobrescriban los cambios realizados por otra transacción concurrente.
     */
    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithOptimisticLock(Long id);

    /**
     * Aplica un bloqueo optimista con incremento forzado en la entidad `Product` con el ID dado.
     * Este método no solo detecta colisiones, sino que también incrementa la versión de la entidad,
     * forzando a que otras transacciones detecten un cambio.
     *
     * Caso de uso: Utilizar cuando una transacción necesita garantizar que otras entidades
     * gestionadas detecten que ha ocurrido un cambio, incluso sin modificaciones directas.
     * Necesario para: Evitar condiciones de carrera donde las transacciones puedan operar
     * sobre datos "viejos" sin conocimiento de los cambios recientes.
     */
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithOptimisticForceIncrement(Long id);

    /**
     * Aplica un bloqueo pesimista de lectura en la entidad `Product` con el ID dado.
     * Este bloqueo permite múltiples lecturas concurrentes, pero bloquea las escrituras.
     *
     * Caso de uso: Cuando es importante leer datos consistentes sin impedir a otros lectores
     * acceder a los mismos datos, pero evitando escrituras concurrentes.
     * Necesario para: Asegurar que los datos leídos no sean modificados por otra transacción
     * mientras están siendo leídos.
     */
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithPessimisticReadLock(Long id);

    /**
     * Aplica un bloqueo pesimista de escritura en la entidad `Product` con el ID dado.
     * Este bloqueo impide que otras transacciones lean o escriban en la entidad hasta que el bloqueo se libere.
     *
     * Caso de uso: Cuando una transacción necesita modificar datos y es crítico que
     * ninguna otra transacción lea o modifique esos datos simultáneamente.
     * Necesario para: Evitar inconsistencias de datos en situaciones de alta concurrencia
     * donde las transacciones necesitan realizar modificaciones garantizadas.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithPessimisticWriteLock(Long id);

    /**
     * Aplica un bloqueo pesimista con incremento forzado en la entidad `Product` con el ID dado.
     * Similar a PESSIMISTIC_WRITE, pero también fuerza un incremento en el número de versión de la entidad.
     *
     * Caso de uso: Cuando es necesario no solo bloquear la escritura sino también forzar
     * que todas las entidades gestionadas que lean esta entidad detecten el cambio.
     * Necesario para: Garantizar que los cambios realizados en una transacción sean visibles
     * y que otras transacciones no operen sobre datos desactualizados.
     */
    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product findProductWithPessimisticForceIncrement(Long id);
}
