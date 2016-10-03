package test.java.com.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestDBCalls {
	private static EntityManager em;
	 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrackPU");
        em = emf.createEntityManager();
 
        createTrack(1, "Avi", "one");
        createTrack(2, "Raj", "two");
        createTrack(3, "Nilu", "three");
    }
 
    private static void createTrack(int id, String title, String singer) {
        em.getTransaction().begin();
        //Track emp = new Track(id, title, singer);
        //em.persist(emp);
        em.getTransaction().commit();
    }
}
