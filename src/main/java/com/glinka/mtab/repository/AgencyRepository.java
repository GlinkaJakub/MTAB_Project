package com.glinka.mtab.repository;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgencyRepository extends JpaRepository<Agency, Long> {

    List<Agency> findAllByOwner(User user);

    Agency findByName(String name);

}
