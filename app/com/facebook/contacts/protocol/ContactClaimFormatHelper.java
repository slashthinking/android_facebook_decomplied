package com.facebook.contacts.protocol;

import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;

public class ContactClaimFormatHelper
{
  private static final Class<?> a = ContactClaimFormatHelper.class;
  private final JsonFactory b;

  public ContactClaimFormatHelper(JsonFactory paramJsonFactory)
  {
    this.b = paramJsonFactory;
  }

  public String a(String paramString, int paramInt)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      JsonGenerator localJsonGenerator = this.b.createJsonGenerator(localStringWriter);
      localJsonGenerator.writeStartObject();
      localJsonGenerator.writeObjectFieldStart("PHONE");
      localJsonGenerator.writeStringField("phone_number", paramString);
      localJsonGenerator.writeNumberField("field_label_type", paramInt);
      localJsonGenerator.writeEndObject();
      localJsonGenerator.writeEndObject();
      localJsonGenerator.flush();
      String str2 = localStringWriter.toString();
      str1 = str2;
      return str1;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        BLog.d(a, localIOException.getMessage());
        String str1 = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.ContactClaimFormatHelper
 * JD-Core Version:    0.6.0
 */