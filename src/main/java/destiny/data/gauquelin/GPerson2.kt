/**
 * Created by smallufo on 2018-04-06.
 */
package destiny.data.gauquelin

import destiny.core.Gender
import destiny.core.calendar.ILocation
import destiny.core.calendar.Location
import java.io.Serializable
import java.time.LocalDateTime

data class GPerson2(
  val id: Long?,
  /* 原始的 number ，每種職業會有獨一的 number . 不同職業的 number 會重複，不可拿來做 index */
  val number: Int,
  val name: String?,
  /* 男生 = 1 , 女生 = 0 , 未定義則為 -1 */
  val gender: Gender?,
  /* 「未調整過時區」的原始出生時間 */
  val lmt: LocalDateTime,
  val loc: Location,
  val place: String?,
  val raw:String?
                   ) : ILocation by loc, Serializable