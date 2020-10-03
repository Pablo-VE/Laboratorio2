/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.agencia;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 *
 * @author Pablo-VE
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
        @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.agencia.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Alquileres", "Metodos para para la administracion de alquileres de vehiculos"),
                     new Tag("Ciudades", "Metodos para para la administracion de las ciudades de las oficinas"),
                     new Tag("Clientes", "Metodos para para la administracion de los clientes de la agencia"),
                     new Tag("Direcciones", "Metodos para para la administracion de las direcciones de las oficinas"),
                     new Tag("Grupos_Vehiculos", "Metodos para para la administracion de los grupos de los vehiculos"),
                     new Tag("Oficinas", "Metodos para para la administracion de las oficinas de la agencia"),
                     new Tag("Tamanos_Vehiculos", "Metodos para para la administracion del tamano de los vehiculos por grupo"),
                     new Tag("Tarjetas_Credito", "Metodos para para la administracion de las tarjetas de credito de los clientes"),
                     new Tag("Tipos_Seguros", "Metodos para para la administracion de los tipos de seguro"),
                     new Tag("Vehiculos", "Metodos para para la administracion de los vehiculos")
                );

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Agencia de Vehiculos",
                "Rest API sobre una agencia de vehiculos - Laboratorio 2",
                "Versión:2.1.0",
                "https://google.com",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }

    
}
