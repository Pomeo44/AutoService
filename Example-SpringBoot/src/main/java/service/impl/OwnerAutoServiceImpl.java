package service.impl;

import service.repository.OwnerAutoRepository;
import model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.OwnerAutoService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class OwnerAutoServiceImpl extends AbstractService<OwnerAuto, OwnerAutoRepository> implements OwnerAutoService {

    @Autowired
    private OwnerAutoRepository ownerAutoRepository;

    @Override
    protected OwnerAutoRepository getRepository() {
        return ownerAutoRepository;
    }
}
