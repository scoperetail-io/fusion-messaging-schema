package com.scoperetail.fusion.messaging.schema.xjb.adapter;

/*-
 * *****
 * fusion-messaging-schema
 * -----
 * Copyright (C) 2018 - 2021 Scope Retail Systems Inc.
 * -----
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====
 */

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
