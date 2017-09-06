package org.pomeo44.service.impl;

import org.pomeo44.model.AutoMarka;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.AutoMarkaService;
import org.pomeo44.service.repository.AutoMarkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class AutoMarkaServiceImpl extends AbstractService<AutoMarka, AutoMarkaRepository> implements AutoMarkaService {

    @Autowired
    private AutoMarkaRepository autoMarkaRepository;

    @Override
    protected AutoMarkaRepository getRepository() {
        return autoMarkaRepository;
    }
}
