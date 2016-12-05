package dao.api;

import model.AutoType;

/**
 * Created by Pomeo on 22.10.2016.
 */
public interface AutoTypeDao extends Dao<AutoType> {
    AutoType findByName(String name);
}
