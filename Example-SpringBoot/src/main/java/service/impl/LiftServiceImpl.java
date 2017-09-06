package service.impl;

import service.repository.LiftRepository;
import model.Lift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.LiftService;

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
