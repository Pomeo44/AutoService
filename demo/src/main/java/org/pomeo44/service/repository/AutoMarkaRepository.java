package org.pomeo44.service.repository;

import org.pomeo44.model.AutoMarka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pomeo on 22.10.2016.
 */
public interface AutoMarkaRepository extends JpaRepository<AutoMarka, Integer> { //extends CrudRepository<AutoMarka, Integer> {
}
