package org.example.Util;

import org.example.Entites.Classes;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClassesDao<T> implements BaseService<T>{

    @Override
    public boolean save(T entity) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(entity);
            transaction.commit();
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
        return true;
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
        }catch (Exception e){
            transaction.rollback();
            return null;
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return (T) classes;
    }

    @Override
    public List<T> getAll() {
        Session session = null;
        Transaction transaction = null;
        List<T> classes = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            classes = session.createQuery("from Classes "). list();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
            return classes;
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return classes;
    }

    @Override
    public boolean delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return true;
    }
}
