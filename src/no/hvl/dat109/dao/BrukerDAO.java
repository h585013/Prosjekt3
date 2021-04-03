package no.hvl.dat109.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import no.hvl.dat109.databaseEmmaTest.Bruker;
import no.hvl.dat109.spiller.Spiller;

@Stateless
public class BrukerDAO {

	@PersistenceContext(name = "brukerPU")
	private EntityManager em;

	public boolean brukernavnLedig(String navn) {

		Bruker b = em.find(Bruker.class, navn);
		return b == null;
	}

	public boolean epostLedig(String epost) {

		Bruker b = em.createQuery("select b from Bruker b where epost=" + epost, Bruker.class).getSingleResult();
		return b == null;
	}

	public Bruker finnBruker(String brukernavn) {
		return em.find(Bruker.class, brukernavn);
	}

	public boolean matcherPassord(Bruker b, String pass) {
		return b.getPassord().equals(pass);
	}

	// burde nok ikke være her

	@Transactional
	public void leggTilBruker(Bruker b) {
		em.persist(b);
	}

	public List<Spiller> hentAlle() {
		return em.createQuery("select s from Spiller d", Spiller.class).getResultList();
	}

}
