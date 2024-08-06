package com.courses.capacitacionesflypass.sesion3.c.datarest;

import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Product.class)
public class ProductEventHandler {


    /**
     * Antes de Crear (BeforeCreate)
     * Después de Crear (AfterCreate)
     * Antes de Guardar (BeforeSave)
     * Después de Guardar (AfterSave)
     * Antes de Eliminar (BeforeDelete)
     * Después de Eliminar (AfterDelete)
     * Antes de Vincular (BeforeLinkSave)
     * Después de Vincular (AfterLinkSave)
     * Antes de Desvincular (BeforeLinkDelete)
     * Después de Desvincular (AfterLinkDelete)
     */

    @HandleBeforeCreate
    public void handleBeforeCreate(Product product) {
        // Lógica personalizada antes de crear un producto
        System.out.println("Before creating product: " + product.getName());
    }

    @HandleAfterCreate
    public void handleAfterCreate(Product product) {
        // Lógica personalizada después de crear un producto
        System.out.println("After creating product: " + product.getName());
    }

    @HandleBeforeSave
    public void handleBeforeSave(Product product) {
        // Lógica personalizada antes de guardar un producto
        System.out.println("Before saving product: " + product.getName());
    }

    @HandleAfterSave
    public void handleAfterSave(Product product) {
        // Lógica personalizada después de guardar un producto
        System.out.println("After saving product: " + product.getName());
    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Product product) {
        // Lógica personalizada antes de eliminar un producto
        System.out.println("Before deleting product: " + product.getName());
    }

    @HandleAfterDelete
    public void handleAfterDelete(Product product) {
        // Lógica personalizada después de eliminar un producto
        System.out.println("After deleting product: " + product.getName());
    }

    @HandleBeforeLinkSave
    public void handleBeforeLinkSave(Product product, Object linked) {
        // Lógica personalizada antes de vincular una entidad relacionada
        System.out.println("Before linking related entity to product: " + product.getName());
    }

    @HandleAfterLinkSave
    public void handleAfterLinkSave(Product product, Object linked) {
        // Lógica personalizada después de vincular una entidad relacionada
        System.out.println("After linking related entity to product: " + product.getName());
    }

    @HandleBeforeLinkDelete
    public void handleBeforeLinkDelete(Product product, Object linked) {
        // Lógica personalizada antes de desvincular una entidad relacionada
        System.out.println("Before unlinking related entity from product: " + product.getName());
    }

    @HandleAfterLinkDelete
    public void handleAfterLinkDelete(Product product, Object linked) {
        // Lógica personalizada después de desvincular una entidad relacionada
        System.out.println("After unlinking related entity from product: " + product.getName());
    }
}
