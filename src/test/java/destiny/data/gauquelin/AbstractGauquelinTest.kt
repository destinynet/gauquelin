/**
 * Created by smallufo on 2018-11-12.
 */
package destiny.data.gauquelin

import destiny.DestinyCoreContext
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import javax.inject.Inject

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = ["classpath:core.xml" , "classpath:gauquelin.xml"])
@Transactional(transactionManager = "txManagerGauquelin")
class AbstractGauquelinTest : DestinyCoreContext() {

  @Inject
  protected lateinit var gDao: GDao
}
