package org.pomeo44.service.impl;

import org.pomeo44.service.api.PriceService;
import org.pomeo44.service.repository.PriceRepository;
import org.pomeo44.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.pomeo44.service.AbstractService;

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
