package dao.api;

import model.OwnerAuto;

/**
 * Created by Pomeo on 11.12.2016
 */
public interface OwnerAutoDao extends Dao<OwnerAuto> {
    OwnerAuto findByName(String name);
}
