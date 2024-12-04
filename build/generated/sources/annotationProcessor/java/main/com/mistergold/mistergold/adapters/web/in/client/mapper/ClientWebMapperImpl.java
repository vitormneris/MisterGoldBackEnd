package com.mistergold.mistergold.adapters.web.in.client.mapper;

import com.mistergold.mistergold.adapters.web.PageResponseDTO;
import com.mistergold.mistergold.adapters.web.in.InfoActivationDTO;
import com.mistergold.mistergold.adapters.web.in.client.dto.AddressDTO;
import com.mistergold.mistergold.adapters.web.in.client.dto.ClientDTO;
import com.mistergold.mistergold.adapters.web.in.client.dto.RecoveryDTO;
import com.mistergold.mistergold.adapters.web.in.order.dto.OrderDTO;
import com.mistergold.mistergold.application.domain.InfoActivation;
import com.mistergold.mistergold.application.domain.PageResponse;
import com.mistergold.mistergold.application.domain.abstracts.Recovery;
import com.mistergold.mistergold.application.domain.client.Address;
import com.mistergold.mistergold.application.domain.client.Client;
import com.mistergold.mistergold.application.domain.order.Order;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T11:09:51-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.5 (Ubuntu)"
)
@Component
public class ClientWebMapperImpl implements ClientWebMapper {

    @Override
    public List<ClientDTO> mapTListDTO(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( mapToDTO( client ) );
        }

        return list;
    }

    @Override
    public Set<OrderDTO> mapToListDTO(Set<Order> order) {
        if ( order == null ) {
            return null;
        }

        Set<OrderDTO> set = new LinkedHashSet<OrderDTO>( Math.max( (int) ( order.size() / .75f ) + 1, 16 ) );
        for ( Order order1 : order ) {
            set.add( mapToDTO( order1 ) );
        }

        return set;
    }

    @Override
    public RecoveryDTO mapToDTO(Recovery recovery) {
        if ( recovery == null ) {
            return null;
        }

        String code = null;
        String password = null;

        code = recovery.getCode();
        password = recovery.getPassword();

        RecoveryDTO recoveryDTO = new RecoveryDTO( code, password );

        return recoveryDTO;
    }

    @Override
    public Recovery mapToDomain(RecoveryDTO recoveryDTO) {
        if ( recoveryDTO == null ) {
            return null;
        }

        Recovery recovery = new Recovery();

        recovery.setCode( recoveryDTO.code() );
        recovery.setPassword( recoveryDTO.password() );

        return recovery;
    }

    @Override
    public Address mapToDomain(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setState( addressDTO.state() );
        address.setCity( addressDTO.city() );
        address.setNeighborhood( addressDTO.neighborhood() );
        address.setStreet( addressDTO.street() );
        address.setPostalCode( addressDTO.postalCode() );
        address.setNumber( addressDTO.number() );
        address.setComplement( addressDTO.complement() );

        return address;
    }

    @Override
    public AddressDTO mapToDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO.AddressDTOBuilder addressDTO = AddressDTO.builder();

        addressDTO.state( address.getState() );
        addressDTO.city( address.getCity() );
        addressDTO.neighborhood( address.getNeighborhood() );
        addressDTO.street( address.getStreet() );
        addressDTO.postalCode( address.getPostalCode() );
        addressDTO.number( address.getNumber() );
        addressDTO.complement( address.getComplement() );

        return addressDTO.build();
    }

    @Override
    public PageResponseDTO<ClientDTO> mapToPageResponseDto(PageResponse<Client> pageResponse) {
        if ( pageResponse == null ) {
            return null;
        }

        PageResponseDTO<ClientDTO> pageResponseDTO = new PageResponseDTO<ClientDTO>();

        if ( pageResponse.getPageSize() != null ) {
            pageResponseDTO.setPageSize( pageResponse.getPageSize().longValue() );
        }
        if ( pageResponse.getTotalElements() != null ) {
            pageResponseDTO.setTotalElements( pageResponse.getTotalElements().intValue() );
        }
        if ( pageResponse.getTotalPages() != null ) {
            pageResponseDTO.setTotalPages( pageResponse.getTotalPages() );
        }
        if ( pageResponse.getCurrentPage() != null ) {
            pageResponseDTO.setCurrentPage( pageResponse.getCurrentPage() );
        }
        if ( pageResponse.getNextPage() != null ) {
            pageResponseDTO.setNextPage( pageResponse.getNextPage() );
        }
        if ( pageResponse.getPreviousPage() != null ) {
            pageResponseDTO.setPreviousPage( pageResponse.getPreviousPage() );
        }
        pageResponseDTO.setContent( clientSetToClientDTOSet( pageResponse.getContent() ) );

        return pageResponseDTO;
    }

    @Override
    public InfoActivationDTO mapToDTO(InfoActivation infoActivation) {
        if ( infoActivation == null ) {
            return null;
        }

        Boolean isActive = null;
        Instant creationDate = null;
        Instant deactivationDate = null;

        isActive = infoActivation.getIsActive();
        creationDate = infoActivation.getCreationDate();
        deactivationDate = infoActivation.getDeactivationDate();

        InfoActivationDTO infoActivationDTO = new InfoActivationDTO( isActive, creationDate, deactivationDate );

        return infoActivationDTO;
    }

    @Override
    public InfoActivation mapToDomain(InfoActivationDTO infoActivation) {
        if ( infoActivation == null ) {
            return null;
        }

        InfoActivation.InfoActivationBuilder infoActivation1 = InfoActivation.builder();

        infoActivation1.isActive( infoActivation.isActive() );
        infoActivation1.creationDate( infoActivation.creationDate() );
        infoActivation1.deactivationDate( infoActivation.deactivationDate() );

        return infoActivation1.build();
    }

    protected Set<ClientDTO> clientSetToClientDTOSet(Set<Client> set) {
        if ( set == null ) {
            return null;
        }

        Set<ClientDTO> set1 = new LinkedHashSet<ClientDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Client client : set ) {
            set1.add( mapToDTO( client ) );
        }

        return set1;
    }
}