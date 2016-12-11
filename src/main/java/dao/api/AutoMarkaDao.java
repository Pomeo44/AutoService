package dao.api;

import model.AutoMarka;

/**
 * Created by Pomeo on 22.10.2016.
 */
public interface AutoMarkaDao extends Dao<AutoMarka> {
    AutoMarka findByName(String name);
}
