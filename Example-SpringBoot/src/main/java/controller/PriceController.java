package controller;

import model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.PriceService;
import service.api.ServiceApi;

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
