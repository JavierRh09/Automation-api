package com.nttdata.steps;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearPedido {

    private static String CREATE_PEDIDO = "https://petstore.swagger.io/v2/store/order";


    @Step
    public void crearPedido( String id, String petId, String quantity){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"Id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \"2024-06-22T20:49:37.202Z\",\n" +
                        "  \"status\": \"En proceso - Mirash\",\n" +
                        "  \"complete\": \"true\",\n" +
                        "}")
                .log().all()
                .post(CREATE_PEDIDO)
                .then()
                .log().all()
        ;

    }
   public void validarType(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void validarCodigoRespuesta(int statusCode) {

        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
