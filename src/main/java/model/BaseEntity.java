package model;

import java.io.Serializable;

/**
 * Created by Pomeo on 19.10.2016.
 */
public abstract class BaseEntity implements Serializable {
    public static final String ENTITY_TYPE = "";

    public String getEntityType() {
        return ENTITY_TYPE;
    }

}
