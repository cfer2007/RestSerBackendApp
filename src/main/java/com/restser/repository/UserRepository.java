package com.restser.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restser.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value="select * \r\n"
			+ "from users \r\n"
			+ "where uid \r\n"
			+ "not in(select id_friend \r\n"
			+ "	   from contact \r\n"
			+ "	   where uid = :id \r\n"
			+ "	   union \r\n"
			+ "	   select distinct uid \r\n"
			+ "	   from users \r\n"
			+ "	   where uid = :id)", nativeQuery = true)
	List<User> findWithOutDuplicate(@Param("id") String id);
}
