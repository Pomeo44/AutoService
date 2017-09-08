package org.pomeo44.service.impl;

import org.pomeo44.service.repository.OwnerAutoRepository;
import org.pomeo44.model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.OwnerAutoService;

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
