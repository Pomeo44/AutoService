package service.impl;

import dao.api.PriceDao;
import model.AutoType;
import model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.PriceService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceDao priceDao;

    @Override
    public Price findById(Integer id) {
        return priceDao.findById(id);
    }

    @Override
    public List<Price> getAll() {
        return priceDao.getAll();
    }

    @Override
    public void save(Price entity) {
        priceDao.saveOrUpdate(entity);
    }

    @Override
    public void update(Price entity) throws NonExistObject {
        if (findById(entity.getPriceId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getPriceId()));
        priceDao.merge(entity);
    }

    @Override
    public Integer add(Price entity) throws NonUniqueObject {
//        if (priceDao.findByName(entity.getName()) != null) {
//            throw  new NonUniqueObject("Такой тип машины уже есть");
//        }
        entity.setIsDelete(false);
        return priceDao.add(entity);
    }

    @Override
    public void delete(Price entity) throws NonExistObject {
        if (findById(entity.getPriceId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getPriceId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        Price entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
