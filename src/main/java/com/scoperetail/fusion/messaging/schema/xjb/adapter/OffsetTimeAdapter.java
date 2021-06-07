package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OffsetTimeAdapter extends XmlAdapter<String, OffsetTime> {
  @Override
  public OffsetTime unmarshal(final String v) throws Exception {
    return OffsetTime.parse(v);
  }

  @Override
  public String marshal(final OffsetTime v) throws Exception {
    return Objects.nonNull(v) ? v.format(DateTimeFormatter.ISO_TIME) : null;
  }
}
