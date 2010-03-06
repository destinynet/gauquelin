package destiny.data.mining;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import destiny.utils.AbstractDaoJpaImpl;

public class MiningPersonDaoImpl extends AbstractDaoJpaImpl<MiningPerson> implements MiningPersonDao
{
  public MiningPersonDaoImpl()
  {
  }

  @PersistenceContext(unitName="mining")
  @Override
  public void setEntityManager(EntityManager em)
  {
    this.em = em;
  }
  
}
