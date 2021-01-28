/**
 * https://exercism.io/my/tracks/kotlin
 * Gigasecond
 */

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.time.temporal.TemporalQueries

class Gigasecond_1(moment: Temporal) {

    private val moment: LocalDateTime = LocalDateTime.of(
        LocalDate.from(moment), moment.query(TemporalQueries.localTime()) ?: LocalTime.of(0, 0)
    )

    val date: LocalDateTime = LocalDateTime.from(this.moment.plus(1_000_000_000, ChronoUnit.SECONDS))
}

class Gigasecond_2(moment: LocalDateTime) {

    constructor(moment: LocalDate) : this(moment.atTime(0, 0))

    val date: LocalDateTime = moment.plusSeconds(1_000_000_000)
}
