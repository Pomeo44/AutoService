package controller;

import model.Price;
import service.api.PriceService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/price")
public class PriceController extends AbstractRestController<Price>{

    @EJB
    private PriceService priceService;

    @Override
    protected ServiceApi getService() {
        return priceService;
    }
}
