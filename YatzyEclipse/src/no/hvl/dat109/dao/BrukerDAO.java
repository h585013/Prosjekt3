package no.hvl.dat109.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import no.hvl.dat109.registreringOgLogin.Bruker;
import no.hvl.dat109.spill.Spill;


@Stateless
public class BrukerDAO {

	@PersistenceContext(name = "yatzyPU")
	private EntityManager em;

	public boolean brukernavnLedig(String navn) {

//		Bruker b = em.find(Bruker.class, navn);

		Bruker b = em.createQuery("select b from Bruker b where b.brukernavn LIKE :name", Bruker.class).setParameter("name", navn).getSingleResult();
		
		
		return b == null;
	}

	public boolean epostLedig(String epost) {

		Bruker b = em.createQuery("select b from Bruker b where b.epost LIKE :epost", Bruker.class).setParameter("epost", epost).getSingleResult();
		return b == null;
	}

	public Bruker finnBruker(String brukernavn) {
		return em.find(Bruker.class, brukernavn);
	}

	@Transactional
	public boolean leggTilBruker(Bruker b) {
		
		if(brukernavnLedig(b.getBrukernavn())) {
			em.persist(b);
			return true;
		}
		else {
			return false;
		}
	}

	public List<Bruker> hentAlle() {
		return em.createQuery("select b from Bruker b", Bruker.class).getResultList();
	}
	public void leggTilSpill(Bruker bruker,Spill spill) {
	
	bruker.setSpill(spill);
	em.persist(bruker);
	}

}
