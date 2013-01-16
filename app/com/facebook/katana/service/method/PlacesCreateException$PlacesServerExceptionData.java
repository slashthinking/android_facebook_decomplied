package com.facebook.katana.service.method;

import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.facebook.katana.model.FacebookApiException.ServerExceptionData;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import java.util.List;

public class PlacesCreateException$PlacesServerExceptionData extends FacebookApiException.ServerExceptionData
{
  PlacesCreateException.ErrorData mPlaceErrorData = null;

  private void e()
  {
    if ((this.mPlaceErrorData == null) && (a() != null));
    try
    {
      this.mPlaceErrorData = ((PlacesCreateException.ErrorData)JMParser.a(FBJsonFactory.a.createJsonParser(a()), JMAutogen.a(PlacesCreateException.ErrorData.class)));
      Throwable localThrowable = null;
      label41: if (localThrowable != null)
        Log.a(PlacesCreateException.a, "Exception parsing creation exception", localThrowable);
      return;
    }
    catch (JMException localJMException)
    {
      break label41;
    }
    catch (IOException localIOException)
    {
      break label41;
    }
    catch (JsonParseException localJsonParseException)
    {
      break label41;
    }
  }

  public List<PlacesCreateException.SimilarPlace> b()
  {
    e();
    if (this.mPlaceErrorData != null);
    for (List localList = this.mPlaceErrorData.mSimilarPlaces; ; localList = null)
      return localList;
  }

  public String c()
  {
    e();
    if (this.mPlaceErrorData != null);
    for (String str = this.mPlaceErrorData.mSuggestedName; ; str = null)
      return str;
  }

  public String d()
  {
    e();
    if (this.mPlaceErrorData != null);
    for (String str = this.mPlaceErrorData.mInvalidNameReason; ; str = null)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesCreateException.PlacesServerExceptionData
 * JD-Core Version:    0.6.0
 */