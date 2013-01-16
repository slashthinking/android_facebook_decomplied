package com.facebook.katana.service.method;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.debug.Assert;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.model.FacebookApiException.ServerExceptionData;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

public class PlacesCreateException extends FacebookApiException
{
  static final Class<?> a = PlacesCreateException.class;

  public PlacesCreateException(JsonParser paramJsonParser)
  {
    this.mData = ((FacebookApiException.ServerExceptionData)JMParser.a(paramJsonParser, PlacesCreateException.PlacesServerExceptionData.class));
    Assert.a(this.mData);
  }

  public List<PlacesCreateException.SimilarPlace> d()
  {
    return ((PlacesCreateException.PlacesServerExceptionData)this.mData).b();
  }

  public String e()
  {
    return ((PlacesCreateException.PlacesServerExceptionData)this.mData).c();
  }

  public String f()
  {
    return ((PlacesCreateException.PlacesServerExceptionData)this.mData).d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreateException
 * JD-Core Version:    0.6.0
 */