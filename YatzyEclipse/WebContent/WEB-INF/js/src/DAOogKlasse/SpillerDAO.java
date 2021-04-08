package DAOogKlasse;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpillerDAO {
	
	@PersistenceContext(name ="VenteromPU")
	private EntityManager em;
	
	public List<Spiller> hentAlle() {
		return em.createQuery("select d from Spiller d", Spiller.class).getResultList();
	}
	
	
}
