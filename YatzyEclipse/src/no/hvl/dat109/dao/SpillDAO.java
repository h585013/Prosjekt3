package no.hvl.dat109.dao;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.spill.Spill;

@Stateless
public class SpillDAO {
	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public void leggTilSpill(Spill spill) {
		em.merge(spill);
	}
	
	public Spill hentFerdigSpill(String spillNavn) {
		return  em.createQuery("Select s from Spill s where s.spillNavn=:spillNavn",Spill.class).setParameter("spillNavn", spillNavn).getSingleResult();
	}
	
	
	public Spill finnSpill(int id) {
		return em.find(Spill.class, id);
	}

	public List<Spill> hentAlle(){
		return em.createQuery("Select s from Spill s",Spill.class).getResultList();
		
	}
	public void slettSpill(Spill spill) {
	em.remove(spill);
	}
	
	public List<Spill> hentSpillereMedId(int id) {
		return em.createQuery("Select spillnavn from Spill where spillid = " + id,Spill.class).getResultList();
	}
}
