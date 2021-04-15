package no.hvl.dat109.dao;

/**
 * 
 * @author Magnus
 *
 */

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import no.hvl.dat109.main.Resultat;



@Stateless
public class ResultatDAO {
	

	@PersistenceContext(name = "resultatPU")
	private EntityManager em;
	
//	public int hentEnere(Resultat r) {
//		return (int) em.createQuery("select enere from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentToere(Resultat r) {
//		return (int) em.createQuery("select toere from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentFirere(Resultat r) {
//		return (int) em.createQuery("select firere from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentFemere(Resultat r) {
//		return (int) em.createQuery("select femere from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentSeksere(Resultat r) {
//		return (int) em.createQuery("select seksere from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentSum1(Resultat r) {
//		return (int) em.createQuery("select sum1 from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentBonus(Resultat r) {
//		return (int) em.createQuery("select bonus from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentEtpar(Resultat r) {
//		return (int) em.createQuery("select etPar from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentTopar(Resultat r) {
//		return (int) em.createQuery("select toPar from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentTrelike(Resultat r) {
//		return (int) em.createQuery("select treLike from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentFirelike(Resultat r) {
//		return (int) em.createQuery("select fireLike from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentLitenstraight(Resultat r) {
//		return (int) em.createQuery("select litenStraight from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentStorstraight(Resultat r) {
//		return (int) em.createQuery("select storStraight from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentHus(Resultat r) {
//		return (int) em.createQuery("select hus from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentSjanse(Resultat r) {
//		return (int) em.createQuery("select sjanse from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentYatzy(Resultat r) {
//		return (int) em.createQuery("select yatzy from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
//	public int hentTotalsum(Resultat r) {
//		return (int) em.createQuery("select totalSum from Resultat where SpillerID=" + r.getId()).getSingleResult();
//	}
	
	//noe sånt?
	@Transactional
	public void sendData(Resultat r) {
		em.merge(r);	
	}
	
	
	

}

	
