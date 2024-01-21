package org.example.Util;

import org.example.Entites.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class StudentDao<T> implements BaseService<T>{
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
        Student student = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);

        }catch (Exception e){
            transaction.rollback();
            return null;
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return (T) student;
    }

    @Override
    public List<T> getAll() {
        Session session = null;
        Transaction transaction = null;
        List<T> students = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            students = session.createQuery("from Student").list();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
            return students;
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return students;
    }

    @Override
    public boolean delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HiberanteUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
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
