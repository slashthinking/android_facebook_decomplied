package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.util.Log;
import com.fasterxml.jackson.core.JsonParser;

public class FacebookApiException extends Exception
{
  protected Throwable mCause;
  protected FacebookApiException.ServerExceptionData mData;

  protected FacebookApiException()
  {
  }

  public FacebookApiException(int paramInt, String paramString)
  {
    this.mData = new FacebookApiException.ServerExceptionData(paramInt, paramString);
  }

  public FacebookApiException(int paramInt, String paramString1, String paramString2)
  {
    this.mData = new FacebookApiException.ServerExceptionData(paramInt, paramString1, paramString2);
  }

  public FacebookApiException(JsonParser paramJsonParser)
  {
    try
    {
      this.mData = ((FacebookApiException.ServerExceptionData)JMParser.a(paramJsonParser, FacebookApiException.ServerExceptionData.class));
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.d("FacebookApiException", "cannot parse response object", localException);
        this.mData = new FacebookApiException.ServerExceptionData(-1, "cannot parse error response");
        this.mCause = localException;
      }
    }
  }

  public int a()
  {
    return this.mData.mErrorCode;
  }

  public String b()
  {
    return this.mData.mErrorMsg;
  }

  public String c()
  {
    return this.mData.mErrorData;
  }

  public Throwable getCause()
  {
    return this.mCause;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookApiException
 * JD-Core Version:    0.6.0
 */