package dao.api;

import model.Master;

import java.util.List;

/**
 * Created by Pomeo on 22.10.2016.
 */
public interface MasterDao extends Dao<Master> {
    List<Master> getAll();
}
