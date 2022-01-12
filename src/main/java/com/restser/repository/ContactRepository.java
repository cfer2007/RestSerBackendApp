package com.restser.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restser.dto.ContactDTO;
import com.restser.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	@Query(value = "select con.id_contact as idContact,\r\n"
			+ "con.id_friend as idFriend,\r\n"
			+ "con.uid as uid,\r\n"
			+ "(select email from users where uid=con.id_friend) as email,\r\n"
			+ "(select username from users where uid=con.id_friend) as username\r\n"
			+ "from contact con, users cli\r\n"
			+ "where \r\n"
			+ "cli.uid=con.uid\r\n"
			+ "and con.uid=:id",nativeQuery = true)
	List<ContactDTO> findByUser(@Param("id") String id);
	
	
	@Modifying()
    @Query(value = "insert into contact(date,uid,id_friend) values(:date,:uid,:idFriend)", nativeQuery = true)    
	@Transactional
	void insertContact(@Param("date") String date, @Param("uid") String uid,@Param("idFriend") String idFriend);
	
	@Modifying()
    @Query(value = "delete from contact where uid=:uid and id_friend=:idFriend", nativeQuery = true)    
	@Transactional
	void deleteContact(@Param("uid") String uid,@Param("idFriend") String idFriend);
}
