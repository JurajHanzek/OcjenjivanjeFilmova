package com.hanzek.zavrsni.user;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hanzek.zavrsni.beans.Movie;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	@Autowired
	public JdbcTemplate iJdbcTemplate;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserDTO> findByUsername(String username) {

		//if()
		try {
			String sql = "SELECT * FROM user WHERE username = ? LIMIT 1";
			User temp = new User();
			temp = (User) iJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), username);
			UserDTO userDto = new UserDTO();
			userDto = mapUserToDTO(temp);
			return Optional.of(userDto);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	private UserDTO mapUserToDTO(final User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		Set<String> set = new HashSet<String>();
		String sql = "SELECT name \r\n" + "FROM authority\r\n"
				+ "join user_authority on user_authority.authority_id = authority.id\r\n"
				+ "where user_authority.user_id=?;";
		String auth = iJdbcTemplate.queryForObject(sql, String.class, user.getId());
		set.add(auth);
		userDTO.setAuthorities(set);
		return userDTO;
	}
	/*
	 * private UserDTO mapUserToDTO(final User user){ return new
	 * UserDTO(user.getId(),user.getUsername(),user.getFirst_name(),user.
	 * getLast_name(),user.getAuthorities().stream().map(Authority::getName).collect
	 * (Collectors.toSet())); }
	 */

	@Override
	public List<User> getUsers() {
		String sql ="SELECT * FROM user";
		return iJdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(User.class));
	}

}
