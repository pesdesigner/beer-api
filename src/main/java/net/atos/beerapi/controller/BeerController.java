package net.atos.beerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.atos.beerapi.model.Beer;
import net.atos.beerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
@Tag(name="Beer API", description = "API Adega de Ouro")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping(produces = "application/json")
    @Operation(
            summary = "Listar todas as cervejas",
            description = "Listar estoque"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "estoque disponível | []")
    })
    public List<Beer> getAllBeer() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Listar cerveja por id",
            description = "Listar apenas um tipo de cerveja"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "estoque disponível | []")
    })
    public Beer getBeerById(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @PostMapping(produces = "application/json")
    @Operation(
            summary = "Cadastrar cerveja no estoque",
            description = "Cadastra um tipo de cerveja no estoque"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna o tipo de cerveja cadastrado")
    })
    public Beer saveBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir cerveja do estoque",
            description = "Exc tipo de cerveja no estoque"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna o tipo de cerveja cadastrado")
    })
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
    }
}
