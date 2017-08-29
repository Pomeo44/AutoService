package service.impl;

import repository.api.PriceRepository;
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
public class PriceServiceImpl extends AbstractService<Price, PriceRepository> implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    protected PriceRepository getRepository() {
        return priceRepository;
    }
}
