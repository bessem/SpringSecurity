/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.dao;

import aka.pirana.springsecurity.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aka
 */
@Repository
@Transactional
public class JpaUserDaoImpl implements UserDao{
    @PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
            System.out.println("aka.pirana.springsecurity.dao.JpaUserDaoImpl.findAll()");
		return em.createQuery("select u from users u", User.class).getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public User findUserById(int id) {
            System.out.println("aka.pirana.springsecurity.dao.JpaUserDaoImpl.findUserById("+id+")");
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
		if(user.getId() <= 0){
			em.persist(user);
		} else {
			user = em.merge(user);
		}
		return user;
	}

	@Override
	public User login(String email, String password) {
            System.out.println("aka.pirana.springsecurity.dao.JpaUserDaoImpl.login("+email+","+password+")");
		TypedQuery<User> query = em.createQuery("select u from users u where u.email=?1 and u.password=?2", User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException|NoResultException e) {
			return null;
		}
		
	}
}
