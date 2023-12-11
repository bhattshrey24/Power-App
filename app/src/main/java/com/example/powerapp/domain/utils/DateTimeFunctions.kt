package com.example.powerapp.domain.utils

import androidx.compose.material3.ColorScheme
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Calendar


//==============================================//
fun localDateToLocalDateTime(localDate: LocalDate): LocalDateTime =
    localDate.atStartOfDay()// basically to convert Date to DateTime object , we need time as well so using atStartOfDay we basically set time to 00:00 for this object

fun localDateToLocalDateTime2(localDate: LocalDate): LocalDateTime =
    localDate.atTime(LocalTime.now()) // This way instead of passing 00:00 we can pass current time

fun localTimeToLocalDateTime(localTime: LocalTime): LocalDateTime =
    localTime.atDate(LocalDate.now())

fun localDateTimeToLocalDate(localDateTime: LocalDateTime): LocalDate = localDateTime.toLocalDate()
fun localDateTimeToLocalTime(localDateTime: LocalDateTime): LocalTime = localDateTime.toLocalTime()

//=============================================//
fun localDateToTimeStamp(localDate: LocalDate): Long =
    localDate.toEpochDay() // this is also like timeStamp only. We are converting to Long to store in Room

fun timeStampToLocalDate(date: Long): LocalDate = LocalDate.ofEpochDay(date)
fun localTimeToTimeStamp(localTime: LocalTime): Long =
    localTime.toNanoOfDay() // this is also like time stamp

fun timeStampToLocalTime(time: Long): LocalTime = LocalTime.ofNanoOfDay(time)
fun localDateTimeToTimestamp(localDateTime: LocalDateTime): Long {
    val instant: Instant = localDateTime.toInstant(ZoneOffset.UTC)
    return instant.toEpochMilli()
}

fun timestampToLocalDateTime(timestamp: Long): LocalDateTime {
    val instant: Instant = Instant.ofEpochMilli(timestamp)
    return LocalDateTime.ofInstant(instant, ZoneOffset.UTC)
}

//==========================================================//
fun localDateToFormattedDate(localDate: LocalDate, pattern: String = "MM dd yyyy"): String =
    localDate.format(DateTimeFormatter.ofPattern(pattern))// "dd-MMMM-yyyy" using this we can
// show name of month like 12 February 1999

fun localDateToFormattedDate2(localDate: LocalDate): String =
    localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))//FULL – Thursday, 17 February, 2022 ,
// LONG – 17 February 2022 , MEDIUM – 17/02/22, SHORT – 4/3/19

fun localDateTimeToFormattedDate(
    localDateTime: LocalDateTime,
    pattern: String = "dd-MM-yyyy HH:mm:ss"
): String = localDateTime.format(DateTimeFormatter.ofPattern(pattern))

fun localDateTimeToFormattedDate2(localDateTime: LocalDateTime): String =
    localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))

fun localTimeToFormattedTime(localTime: LocalTime,pattern: String = "HH:mm:ss"):String = localTime.format(DateTimeFormatter.ofPattern(pattern))
fun localTimeToFormattedTime2(localTime: LocalTime):String = localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG))
