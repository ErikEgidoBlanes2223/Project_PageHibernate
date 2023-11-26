package DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import Model.Autor;
import app.HibernateUtil;

public class AutorDao {

	public AutorDao() {
	    }

    public void insertAutor(Autor aut) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(aut);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); 
        }
    }
    public void updateAutor(Autor aut) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(aut);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }
    public void deleteAutor(Autor aut) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(aut);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }
    public List getAutorsPaginados(int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Autor> query = session.createQuery("FROM autors", Autor.class);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return (List) query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener Autors paginados: ");
            e.printStackTrace();
            return null;
        }
    }
    
}