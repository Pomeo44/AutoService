package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.api.AutoMarkaDao;
import dao.api.AutoModelDao;
import dao.api.MasterDao;
import dao.api.SpecializationDao;
import model.AutoMarka;
import model.AutoModel;
import model.Master;
import model.Specialization;

import java.util.List;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Service
public class MasterServiceImpl {
    @Autowired
    private MasterDao masterDao;
    @Autowired
    private AutoModelDao autoModelDao;
    @Autowired
    private AutoMarkaDao autoMarkaDao;
    @Autowired
    private SpecializationDao specializationDao;

    @Transactional
    public Master findMasterById(Integer id) {
        Master master = masterDao.findById(id);
        return master;
    }

    @Transactional
    public List<Master> getAllMaster() {
        return masterDao.getAllMaster();
    }



    @Transactional
    public AutoModel findAutoModelById(Integer id) {
        AutoModel autoModel = autoModelDao.findById(id);
        return autoModel;
    }

    @Transactional
    public AutoMarka findAutoMarkaById(Integer id) {
        AutoMarka autoMarka = autoMarkaDao.findById(id);
        return autoMarka;
    }

    @Transactional
    public Specialization findSpecializationById(Integer id) {
        Specialization specialization = specializationDao.findById(id);
        return specialization;
    }
}
