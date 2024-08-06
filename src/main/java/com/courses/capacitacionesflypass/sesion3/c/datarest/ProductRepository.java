package com.courses.capacitacionesflypass.sesion3.c.datarest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Métodos de consulta adicionales si es necesario
}
