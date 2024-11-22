package com.example.durian_assurance.repositories.users;

import com.example.durian_assurance.models.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c.id from Client c where c.user.id = :userId ")
    Long getClientIdByUserID(@Param("userId") Long userId);

}
