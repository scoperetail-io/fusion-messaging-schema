package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;


/** Convert XML <code>xs:date</code> to <code>java.time.LocalDate</code> */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
  @Override
  public LocalDate unmarshal(String v) throws Exception {
    return LocalDate.parse(v);
  }

  @Override
  public String marshal(LocalDate v) throws Exception {
    if (v != null) {
      return v.toString();
    } else {
      return null;
    }
  }
}
