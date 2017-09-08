package org.pomeo44.controller;

import org.pomeo44.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.PriceService;
import org.pomeo44.service.api.ServiceApi;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/price")
public class PriceController extends AbstractRestController<Price>{

    @Autowired
    private PriceService priceService;

    @Override
    protected ServiceApi getService() {
        return priceService;
    }
}
