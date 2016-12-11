package dao.api;

import model.Lift;

/**
 * Created by Pomeo on 11.12.2016
 */
public interface LiftDao extends Dao<Lift> {
    Lift findByNumber(Integer number);
}
