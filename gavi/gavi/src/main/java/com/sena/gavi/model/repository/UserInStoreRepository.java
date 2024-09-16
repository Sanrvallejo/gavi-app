package com.sena.gavi.model.repository;

import com.sena.gavi.model.entities.UsersInStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInStoreRepository extends JpaRepository<UsersInStore, String> {
}
