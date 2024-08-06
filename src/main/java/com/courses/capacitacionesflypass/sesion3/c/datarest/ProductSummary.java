package com.courses.capacitacionesflypass.sesion3.c.datarest;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "productSummary", types = { Product.class })
public interface ProductSummary {
    String getName();
    double getPrice();
}
