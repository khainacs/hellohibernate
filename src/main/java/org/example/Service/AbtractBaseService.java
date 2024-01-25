package org.example.Service;

import org.example.Entites.Classes;
import org.example.Util.HiberanteUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AbtractBaseService<T> implements BaseService<T>{
    @Override
    public boolean save(T entity) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.getMessage();
            transaction.rollback();
            return false;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public T getById(Long id) {
        Session session = null;
        Transaction transaction = null;
        Classes classes = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            classes = session.get(Classes.class, id);
            return (T) classes;
        }catch (Exception e){
            transaction.rollback();
            return null;
        }
        finally {
            if (session != null){
                session.close();
            }
        }

    }

    @Override
    public List<T> getAll(String sql) {
        Session session = null;
        Transaction transaction = null;
        List<T> listObject = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            listObject = session.createQuery(sql). list();
            return listObject;
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
            return null;
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
        finally {
            if (session != null){
                session.close();
            }
        }

    }
}
