package com.facebook.contacts.data;

import android.content.res.Resources;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.EntrySection;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.orca.debug.Tracer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

public class ContactSerialization
{
  private final Resources a;
  private final ObjectMapper b;

  public ContactSerialization(Resources paramResources, ObjectMapper paramObjectMapper)
  {
    this.a = paramResources;
    this.b = paramObjectMapper;
  }

  public EntrySection a(ImmutableList<Entry> paramImmutableList)
  {
    return new EntrySection(this.a.getString(2131362438), paramImmutableList, ImmutableList.d());
  }

  public EntrySection a(String paramString)
  {
    return a(ImmutableList.a(new PhoneEntry(null, true, null, -1L, paramString, 2)));
  }

  public String a(ContactDetails paramContactDetails)
  {
    Tracer localTracer = Tracer.a("serializeContactDetails (" + paramContactDetails.getContactId() + ")");
    String str = this.b.writeValueAsString(paramContactDetails);
    localTracer.a();
    return str;
  }

  public String a(ContactSummary paramContactSummary)
  {
    Tracer localTracer = Tracer.a("serializeContactSummary (" + paramContactSummary.getContactId() + ")");
    String str = this.b.writeValueAsString(paramContactSummary);
    localTracer.a();
    return str;
  }

  public ContactSummary b(String paramString)
  {
    Tracer localTracer = Tracer.a("deserializeContactSummary");
    ContactSummary localContactSummary = (ContactSummary)this.b.readValue(paramString, ContactSummary.class);
    localTracer.a();
    return localContactSummary;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.ContactSerialization
 * JD-Core Version:    0.6.0
 */