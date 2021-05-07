package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class OffsetTimeAdapter extends XmlAdapter<String, OffsetTime> {
  @Override
  public OffsetTime unmarshal(String v) throws Exception {
    return OffsetTime.parse(v);
  }

  @Override
  public String marshal(OffsetTime v) throws Exception {
    return Objects.nonNull(v) ? v.format(DateTimeFormatter.ISO_TIME) : null;
  }
}
