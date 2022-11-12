package com.hanzek.zavrsni.user;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findByUsername(String username);

	List<User> getUsers();
}
