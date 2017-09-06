package service.repository;

import model.Price;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pomeo on 11.12.2016
 */
public interface PriceRepository extends CrudRepository<Price, Integer> {
}
