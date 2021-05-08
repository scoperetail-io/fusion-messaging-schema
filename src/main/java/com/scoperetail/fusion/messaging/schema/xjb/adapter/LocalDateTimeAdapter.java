/* ScopeRetail (C)2021 */
package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MILLI_OF_SECOND;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/** Convert XML <code>xs:dateTime</code> to <code>java.time.LocalDateTime</code> */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
  private static final DateTimeFormatter SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS;

  static {
    SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS =
        new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .appendValue(HOUR_OF_DAY, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .optionalStart()
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .optionalStart()
            .appendLiteral('.')
            .appendValue(MILLI_OF_SECOND, 3)
            .toFormatter();
  }

  @Override
  public LocalDateTime unmarshal(final String v) throws Exception {
    return LocalDateTime.parse(v);
  }

  @Override
  public String marshal(final LocalDateTime v) throws Exception {
    if (v != null) {
      return v.format(SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS);
    }
    return null;
  }
}
