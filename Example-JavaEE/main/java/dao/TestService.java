package dao;

import model.AutoMarka;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by aantipin on 16/08/2017.
 */
@Stateless
public class TestService {

    // Будет инициализирован контейнером Glassfish
    // unitName = "DEVMODE" - это имя persistence-unit
    // EntityManager дает возможность выполнять CRUD запросы в БД
    @PersistenceContext(unitName = "MainDB")
    private EntityManager em;

    // Добавляем User-а В базу данных
    public AutoMarka add(AutoMarka user){
        return em.merge(user);
    }

    // Получаем пользователя по id
    public AutoMarka get(long id){
        return em.find(AutoMarka.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(AutoMarka user){
        add(user);
    }

    // удаляем User по id
    public void delete(long id){
        em.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<AutoMarka> getAll(){
        TypedQuery<AutoMarka> namedQuery = em.createNamedQuery("User.getAll", AutoMarka.class);
        return namedQuery.getResultList();
    }
}
