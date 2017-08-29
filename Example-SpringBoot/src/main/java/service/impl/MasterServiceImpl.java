package service.impl;

import repository.api.MasterRepository;
import model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AbstractService;
import service.api.MasterService;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Service
public class MasterServiceImpl extends AbstractService<Master, MasterRepository> implements MasterService{
    @Autowired
    private MasterRepository masterRepository;

    @Override
    protected MasterRepository getRepository() {
        return masterRepository;
    }
}
