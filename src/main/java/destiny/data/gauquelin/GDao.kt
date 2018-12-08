/**
 * @author smallufo
 * Created on 2009/3/5 at 下午 9:53:25
 */
package destiny.data.gauquelin

import destiny.tools.spring.KRepository
import java.io.Serializable
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

interface GDaoCustom {
  fun delete(h: GPersonHouse)

  fun getCount(category: String): Long
  fun findAllByCategory(category: String): List<GPerson>
  fun findAllByCategory(category: String, start: Int, count: Int): List<GPerson>
}

interface GDao : KRepository<GPerson , Long> , GDaoCustom

//@Repository(value = "gDao2Custom")
class GDaoImpl : GDaoCustom , Serializable {

  @PersistenceContext(unitName = "gauquelin")
  private lateinit var em : EntityManager

  override fun delete(h: GPersonHouse) {
  }

  override fun getCount(category: String): Long {
    val n = em.createQuery("select count(*) from GPerson gp where gp.category = :category")
      .setParameter("category", category)
      .singleResult as Number
    return n.toLong()
  }

  override fun findAllByCategory(category: String): List<GPerson> {
    return em.createQuery("from GPerson gp where gp.category = :category", GPerson::class.java)
      .setParameter("category", category).resultList
  }

  override fun findAllByCategory(category: String, start: Int, count: Int): List<GPerson> {
    return em.createQuery("from GPerson gp where gp.category = :category", GPerson::class.java)
      .setParameter("category", category)
      .setFirstResult(start)
      .setMaxResults(count).resultList
  }

}

