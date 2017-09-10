package org.pomeo44.controller;

import org.pomeo44.model.Price;
import org.pomeo44.service.api.PriceService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/price")
public class PriceController extends AbstractRestController<Price>{

    @Autowired
    private PriceService priceService;

    @Override
    protected ServiceApi getService() {
        return priceService;
    }
}
