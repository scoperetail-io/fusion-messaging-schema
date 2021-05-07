package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
  @Override
  public LocalTime unmarshal(String v) throws Exception {
    return LocalTime.parse(v);
  }

  @Override
  public String marshal(LocalTime v) throws Exception {
    return Objects.nonNull(v) ? v.format(DateTimeFormatter.ISO_TIME) : null;
  }
}
