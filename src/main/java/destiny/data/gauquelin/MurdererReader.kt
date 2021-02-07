/**
 * @author smallufo
 * Created on 2008/3/9 at 下午 1:46:18
 */
package destiny.data.gauquelin

/**
 * Notice:
 * 1 ... 623 = Number
 * M = Male, F = Female
 * 59 = abbreviated code of Birth place indicating County of birth or the French
 * "Departement" (here Nord, Lille)
 * 21 11819 = Birthdate: Day (21), Month (january), Year of birth (1819)
 * 154740 = Birthtime: converted to standard time, either for zone 0 (= GMT) or -1 (= CET)
 * 0 or -1 = Time zone at the place of birth and date of birth
 * 50N39 = Latitude of Birth place (here Nord, Lille)
 * 3E 5 = Longitude of Birth place (here Nord, Lille)
 */
class MurdererReader : AbstractMurderAlcoholicReader("murderer.txt", "murderer")
