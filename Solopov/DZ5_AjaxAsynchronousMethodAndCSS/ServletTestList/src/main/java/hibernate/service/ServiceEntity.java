package hibernate.service;

import hibernate.dao.DAOEntity;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;
@Service
 abstract class ServiceEntity<T, Id extends Serializable> {//Wnen: T- is type of Entity, iD- Type of ID
                                                      // and DAOEntity- inheritor type of DAOEntity
    protected DAOEntity daoEntity;

    public ServiceEntity() {
        this.daoEntity = getDaoEntity();
    }
    abstract DAOEntity getDaoEntity();

    public DAOEntity userDao() {
        return daoEntity;
    }

    public void persist(T entity) {
        daoEntity.openCurrentSessionwithTransaction();
        daoEntity.persist(entity);
        daoEntity.closeCurrentSessionwithTransaction();
    }
    public void update(T entity) {
        daoEntity.openCurrentSessionwithTransaction();
        daoEntity.update(entity);
        daoEntity.closeCurrentSessionwithTransaction();
    }

    public T findById(Id id) {
        daoEntity.openCurrentSession();
        T entity = (T) daoEntity.findById(id);
        daoEntity.closeCurrentSession();
        return entity;
    }
    public void delete(Id id) {
        daoEntity.openCurrentSessionwithTransaction();
        T entity = (T) daoEntity.findById(id);
        daoEntity.delete(entity);
        daoEntity.closeCurrentSessionwithTransaction();
    }
    public List<T> findAll() {
        daoEntity.openCurrentSession();
        List<T> collection = daoEntity.findAll();
        daoEntity.closeCurrentSession();
        return collection;
    }
    public void deleteAll() {
        daoEntity.openCurrentSessionwithTransaction();
        daoEntity.deleteAll();
        daoEntity.closeCurrentSessionwithTransaction();
    }
}
