/** 2009/12/26 下午8:59:44 by smallufo */
package destiny.data.mining;

import org.springframework.transaction.annotation.Transactional;

import destiny.utils.AbstractDaoJpaSpringImpl;

@Transactional
public class MiningPersonDaoJpaSpringImpl extends AbstractDaoJpaSpringImpl<MiningPerson> implements MiningPersonDao
{
  public MiningPersonDaoJpaSpringImpl()
  {
    //super(MiningPerson.class);
  }

/*
  @Override
  public Person get(Serializable id)
  {
    return (Person) getJpaTemplate().find(Person.class, id);
  }

  @Override
  public Person save(Person p)
  {
    return getJpaTemplate().merge(p);
  }

  @Override
  public void delete(Person p)
  {
    //getJpaTemplate().remove(getJpaTemplate().getReference(Person.class, p.getId())); //可行
    //getJpaTemplate().remove(getJpaTemplate().find(Person.class, p.getId())); //可行
    getJpaTemplate().remove(getJpaTemplate().merge(p)); //也可行
  }

  @Override
  public Person update(Person p)
  {
    return getJpaTemplate().merge(p);
  }
*/
}

