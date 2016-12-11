package dao.api;

import model.WorkType;

/**
 * Created by Pomeo on 11.12.2016
 */
public interface WorkTypeDao extends Dao<WorkType> {
    WorkType findByName(String name);
}
