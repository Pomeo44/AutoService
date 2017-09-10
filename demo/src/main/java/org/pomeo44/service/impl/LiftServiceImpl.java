package org.pomeo44.service.impl;

import org.pomeo44.model.Lift;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.LiftService;
import org.pomeo44.service.repository.LiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class LiftServiceImpl extends AbstractService<Lift, LiftRepository> implements LiftService {

    @Autowired
    private LiftRepository liftRepository;

    @Override
    protected LiftRepository getRepository() {
        return liftRepository;
    }
}
