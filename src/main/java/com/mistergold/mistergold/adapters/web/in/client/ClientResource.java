package com.mistergold.mistergold.adapters.web.in.client;

import com.mistergold.mistergold.adapters.web.in.client.dto.ClientDTO;
import com.mistergold.mistergold.adapters.web.in.client.mapper.ClientWebMapper;
import com.mistergold.mistergold.application.ports.in.client.DeleteClientUseCase;
import com.mistergold.mistergold.application.ports.in.client.SaveClientUseCase;
import com.mistergold.mistergold.application.ports.in.client.SearchClientUseCase;
import com.mistergold.mistergold.application.ports.in.client.UpdateClientUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
@Tag(name = "clientes")
public class ClientResource {
    private final SearchClientUseCase searchClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final SaveClientUseCase saveClientUseCase;
    private final ClientWebMapper mapper;

    @Operation(summary = "Busca por um cliente na base de dados pelo Id.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de buscar cliente!"),
    })
    @GetMapping("/listartodos")
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(mapper.mapToDTO(searchClientUseCase.findAll()));
    }

    @Operation(summary = "Busca por um cliente na base de dados pelo Id.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de buscar cliente!"),
    })
    @GetMapping("/{id}/id")
    public ResponseEntity<ClientDTO> findById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(searchClientUseCase.findById(id)));
    }

    @Operation(summary = "Busca por um cliente na base de dados pelo E-mail.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de buscar cliente!"),
    })
    @GetMapping("/{email}/email")
    public ResponseEntity<ClientDTO> findByEmail(@PathVariable(name = "email") String email) {
        return ResponseEntity.ok().body(mapper.mapToDTO(searchClientUseCase.findByEmail(email)));
    }

    @Operation(summary = "Salva um cliente na base de dados.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente salvo com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de salvar cliente!"),
    })
    @PostMapping("/salvar")
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody ClientDTO clientDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDTO(saveClientUseCase.save(mapper.mapToDomain(clientDTO))));
    }

    @Operation(summary = "Atualiza um cliente na base de dados pelo Id.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de atualizar cliente!"),
    })
    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(updateClientUseCase.update(mapper.mapToDomain(clientDTO), id)));
    }

    @Operation(summary = "Desativa um cliente na base de dados pelo Id.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente desativado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de desativar cliente!"),
    })
    @DeleteMapping("/{id}/desativar")
    public ResponseEntity<ClientDTO> inactivate(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok().body(mapper.mapToDTO(deleteClientUseCase.inactivate(id)));
    }

    @Operation(summary = "Deleta um cliente na base de dados pelo Id.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos!"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos!"),
            @ApiResponse(responseCode = "500", description = "Falha no serviço de deletar cliente!"),
    })
    @DeleteMapping("/{id}/deletar")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") String id) {
        deleteClientUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
