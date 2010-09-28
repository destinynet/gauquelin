package destiny.data.mining;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import destiny.utils.AbstractDaoJpaImpl;

@Repository
public class MiningPersonDaoImpl extends AbstractDaoJpaImpl<MiningPerson> implements MiningPersonDao
{
  @PersistenceContext(unitName="mining")
  @Override
  public void setEntityManager(EntityManager em)
  {
    this.em = em;
  }
  
  public MiningPersonDaoImpl()
  {
  }
}
