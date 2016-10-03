package main.java.com.jpa.db;

import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.com.jpa.model.Track;

public class DBCall {
	protected EntityManager getEntityManager() throws NamingException {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrackPU");
	    return emf.createEntityManager();
	  }
	  private EntityManager em;
	  private List<Track> listEvents;
	  
	  public List<Track> getTrack() throws NamingException {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    listEvents = em.createQuery("SELECT t FROM Track t").getResultList();
	    em.getTransaction().commit();
	    em.close();
	    return listEvents;
	  }
	  
	  public boolean addTrack(Track track) throws NamingException {
		    em = getEntityManager();
		    em.getTransaction().begin();
		    em.persist(track);
		    em.getTransaction().commit();
		    em.close();
		    return true;
		  }
	 
	 /* @Override
	  protected List getSingleQuery(int id) throws NamingException {
	    em = getEntityManager();
	    em.getTransaction().begin();
	    listEvents = singletonList(em.find(Event.class, id));
	    em.getTransaction().commit();
	    em.close();
	    return listEvents;
	  }
	 
	  @Override
	  protected void createQuery(Event t) throws SQLException, NamingException {
	    Event event = new Event();
	    em = getEntityManager();
	    em.getTransaction().begin();
	    event.setTitle(t.getTitle());
	    event.setDesc("abcd");
	    event.setUid(t.getUid());
	    event.setCreated("1410876904");
	    em.persist(event);
	    em.getTransaction().commit();
	    em.close();
	  }
	.
	.
	.**/
	}
