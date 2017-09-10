package org.pomeo44.service.impl;

import org.pomeo44.model.Master;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.MasterService;
import org.pomeo44.service.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
