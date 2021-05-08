/* ScopeRetail (C)2021 */
package com.scoperetail.fusion.messaging.schema.xjb.adapter;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/** Convert XML <code>xs:date</code> to <code>java.time.LocalDate</code> */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
  @Override
  public LocalDate unmarshal(final String v) throws Exception {
    return LocalDate.parse(v);
  }

  @Override
  public String marshal(final LocalDate v) throws Exception {
    if (v != null) {
      return v.toString();
    }
    return null;
  }
}
