package com.mistergold.mistergold.adapters.web.in.product;

import com.mistergold.mistergold.adapters.web.in.product.dto.ProductDTO;
import com.mistergold.mistergold.adapters.web.in.product.mapper.ProductWebMapper;
import com.mistergold.mistergold.application.ports.in.product.DeleteProductUseCase;
import com.mistergold.mistergold.application.ports.in.product.SaveProductUseCase;
import com.mistergold.mistergold.application.ports.in.product.SearchProductUseCase;
import com.mistergold.mistergold.application.ports.in.product.UpdateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
@Tag(name = "produtos")
public class ProductResource {
    private final SearchProductUseCase searchProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final SaveProductUseCase saveProductUseCase;
    private final ProductWebMapper mapper;

    @Operation(summary = "Busca por um produto na base de dados pelo Id.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de buscar produto!"),
    })
    @GetMapping("/listartodos")
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok().body(mapper.mapToDTO(searchProductUseCase.findAll()));
    }

    @Operation(summary = "Busca por um produto na base de dados pelo Id.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de buscar produto!"),
    })
    @GetMapping("/{id}/id")
    public ResponseEntity<ProductDTO> findById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(searchProductUseCase.findById(id)));
    }

    @Operation(summary = "Salva um produto na base de dados.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de salvar produto!"),
    })
    @PostMapping("/salvar")
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDTO(saveProductUseCase.save(mapper.mapToDomain(productDTO))));
    }

    @Operation(summary = "Atualiza um produto na base de dados pelo Id.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de atualizar produto!"),
    })
    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO productDTO, @PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(updateProductUseCase.update(mapper.mapToDomain(productDTO), id)));
    }

    @Operation(summary = "Desativa um produto na base de dados pelo Id.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto desativado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de desativar produto!"),
    })
    @DeleteMapping("/{id}/desativar")
    public ResponseEntity<ProductDTO> inactivate(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(deleteProductUseCase.inactivate(id)));
    }

    @Operation(summary = "Deleta um produto na base de dados pelo Id.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de deletar produto!"),
    })
    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") String id) {
        deleteProductUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
