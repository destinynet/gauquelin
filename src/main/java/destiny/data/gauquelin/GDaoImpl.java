/**
 * @author smallufo 
 * Created on 2009/3/5 at 下午 10:08:44
 */ 
package destiny.data.gauquelin;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class GDaoImpl extends HibernateDaoSupport implements GDao
{
  public GDaoImpl()
  {
  }
  
  @Override
  public Serializable create(GPerson p)
  {
    return getHibernateTemplate().save(p);
  }
  
  @Override
  public GPerson getById(Serializable key)
  {
    return (GPerson) getHibernateTemplate().get(GPerson.class, key);
  }
  
  @Override
  public void update(GPerson p)
  {
    getHibernateTemplate().saveOrUpdate(p);
  }
  
  @Override
  public void delete(GPerson p)
  {
    getHibernateTemplate().delete(p);
  }
  
  public void delete(GPersonHouse h)
  {
    getHibernateTemplate().delete(h);
  }
  
  @Override
  public long getCount()
  {
    return (Long) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Query q = session.createQuery("select count(*) from GPerson as p");
        return q.uniqueResult(); 
      }
    });
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAll(final int start, final int count)
  {
    return (List<GPerson>) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Criteria c = session.createCriteria(GPerson.class);
        c.setFirstResult(start);
        c.setMaxResults(count);
        c.addOrder(Order.asc("id"));
        c.setCacheable(true);
        return c.list();
      }
    });
  }
  
  @Override
  public long getCount(final String category)
  {
    return (Long) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Query q = session.createQuery("select count(*) from GPerson as p where p.category = :cat");
        q.setParameter("cat" , category);
        return q.uniqueResult(); 
      }
    });
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAllByCategory(final String category)
  {
    return (List<GPerson>) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Criteria c = session.createCriteria(GPerson.class);
        c.add(Restrictions.eq("category", category));
        c.setCacheable(true);
        return c.list();
      }
    });
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAllByCategory(final String category, final int start, final int count)
  {
    return (List<GPerson>) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Criteria c = session.createCriteria(GPerson.class);
        c.add(Restrictions.eq("category", category));
        c.setFirstResult(start);
        c.setMaxResults(count);
        c.addOrder(Order.asc("id"));
        c.setCacheable(true);
        return c.list();
      }
    });
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<GPerson> findAll()
  {
    return (List<GPerson>) getHibernateTemplate().execute( new HibernateCallback()
    {
      @Override
      public Object doInHibernate(Session session) throws HibernateException, SQLException
      {
        Criteria c = session.createCriteria(GPerson.class);
        c.setCacheable(true);
        return c.list();
      }
    });
  }



}
