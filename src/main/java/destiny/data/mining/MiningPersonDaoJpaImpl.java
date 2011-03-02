/** 2009/12/27 上午10:10:07 by smallufo */
package destiny.data.mining;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 與 DaoMiningJpaSpringImpl 不同的是，這個實作，並未 extends JpaDaoSupport , 
 * 因此沒有被 Transaction 所包住，對DB的寫入/更新動作，都會無效
 * 必須使用 tx:advice , 以及 aop:config 來設定 transaction
 * 比較麻煩，但是畢竟，此實作沒有與 Spring 的 API 綁訂
 */
public class MiningPersonDaoJpaImpl implements MiningPersonDao
{
  @PersistenceContext(unitName="mining")
  private EntityManager em;

  @Override
  public MiningPerson get(Serializable id)
  {
    return em.find(MiningPerson.class, id);
  }

  @Override
  public MiningPerson save(MiningPerson p)
  {
    return em.merge(p);
  }

  @Override
  public MiningPerson update(MiningPerson p)
  {
    return em.merge(p);
  }

  @Override
  public void delete(MiningPerson p)
  {
    em.remove(em.merge(p));
  }

  @Override
  public MiningPerson flush(MiningPerson t)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MiningPerson merge(MiningPerson t)
  {
    return em.merge(t);
  }
  
  @Override
  public void refresh(MiningPerson t)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public long getCount()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<MiningPerson> findAll(int start, int count)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<MiningPerson> findAll()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class<MiningPerson> getClassType()
  {
    return MiningPerson.class;
  }

  @Override
  public void evict(Serializable id)
  {
    // TODO Auto-generated method stub
  }

}

