package dao.api;

import model.AutoModel;

/**
 * Created by Pomeo on 22.10.2016.
 */
public interface AutoModelDao extends Dao<AutoModel> {
    AutoModel findByName(String name);
}
