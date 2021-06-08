package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MILLI_OF_SECOND;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OffsetDateTimeAdapter extends XmlAdapter<String, OffsetDateTime> {

  private static final DateTimeFormatter SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS_AND_OFFSET;

  static {
    SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS_AND_OFFSET =
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
            .appendOffsetId()
            .parseStrict()
            .toFormatter();
  }

  @Override
  public String marshal(final OffsetDateTime v) throws Exception {
    return Objects.nonNull(v) ? v.format(SCOPE_DATE_TIME_FORMATTER_WITH_MILLIS_AND_OFFSET) : null;
  }

  @Override
  public OffsetDateTime unmarshal(final String v) throws Exception {
    return OffsetDateTime.parse(v);
  }
}
