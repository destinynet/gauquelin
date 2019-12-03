/**
 * Created by smallufo at 2009/3/17 下午 10:41:31
 */
package destiny.data.gauquelin

import destiny.tools.location.IGeocoding
import destiny.tools.location.TimeZoneService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.inject.Inject

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = ["classpath:core.xml"])
class SuccessfulFrench2154ReaderTest {

  @Inject
  private lateinit var geocodingGoogleImpl: IGeocoding

  @Inject
  private lateinit var timeZoneService: TimeZoneService

  @Test
  fun testSuccessfulFrench2154Reader() {
    val reader: TextDataReader = SuccessfulFrench2154Reader(geocodingGoogleImpl, timeZoneService)
    reader.persons
  }
}
