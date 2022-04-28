package com.RHELP.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RHELP.entities.Document;


@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {

	@Query("select d from Document d where d.employe.idUser = :id")
	List<Document> findDocumentByUserId(@Param("id") Long id);

	@Query("select d from Document d where d.titreDoc = :titre")
	List<Document> findDocumentByTitle(@Param("titre") String titre);
	
	@Query("select d from Document d where d.typeDoc= :type")
	List<Document> findDocumentByType(@Param("type") String type);
}
