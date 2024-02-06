package net.atos.beerapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Product ID", example = "1", required = true)
    private Long id;

    @Schema(name = "Product name", example = "Product 1", required = false)
    private String name;
    @Schema(name = "Product type", example = "type", required = false)
    private String type;
    @Schema(name = "Product alcoholContent", example = "alcoholContent", required = true)
    private double alcoholContent;

}
