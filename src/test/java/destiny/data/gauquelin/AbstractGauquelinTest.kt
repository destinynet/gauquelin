/**
 * Created by smallufo on 2018-11-12.
 */
package destiny.data.gauquelin

import destiny.core.DestinyCoreContext
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import javax.inject.Inject

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(locations = ["classpath:core.xml" , "classpath:gauquelin.xml"])
@Transactional(transactionManager = "txManagerGauquelin")
class AbstractGauquelinTest : DestinyCoreContext() {

  @Inject
  protected lateinit var gDao: GDao
}
