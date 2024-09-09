package com.mistergold.mistergold.adapters.web.in.user.mapper;

import com.mistergold.mistergold.adapters.web.in.user.dto.UserDTO;
import com.mistergold.mistergold.application.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserWebMapper {
    UserDTO mapToDTO(User user);
    User mapToDomain(UserDTO userDTO);
}
