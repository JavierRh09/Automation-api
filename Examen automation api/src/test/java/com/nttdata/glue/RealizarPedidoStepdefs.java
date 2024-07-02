package com.nttdata.glue;

import com.nttdata.steps.CrearPedido;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RealizarPedidoStepdefs {

    @Steps
    CrearPedido crearPedido;

    @When("realizo el pedido con el id {string}, petId: {string}, quantity: {string}")
    public void realizoElPedidoConElIdPetIdQuantity(String id, String petId, String quantity) {
            crearPedido.crearPedido(id,petId,quantity);
    }
}
