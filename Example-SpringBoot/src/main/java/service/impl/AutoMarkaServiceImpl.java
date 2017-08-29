package service.impl;

import repository.api.AutoMarkaRepository;
import model.AutoMarka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoMarkaService;

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
