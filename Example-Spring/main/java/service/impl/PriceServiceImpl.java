package service.impl;

import repository.api.Dao;
import repository.api.PriceDao;
import model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.PriceService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class PriceServiceImpl extends AbstractService<Price, PriceDao> implements PriceService {

    @Autowired
    private PriceDao priceDao;

    @Override
    protected Dao getDao() {
        return priceDao;
    }
}
