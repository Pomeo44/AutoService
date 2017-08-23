package service.impl;

import model.Work;
import service.AbstractService;
import service.api.WorkService;

import javax.ejb.Stateless;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Stateless
public class WorkServiceImpl extends AbstractService<Work> implements WorkService {
}
