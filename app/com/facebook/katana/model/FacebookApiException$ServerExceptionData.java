package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookApiException$ServerExceptionData
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="error_code")
  final int mErrorCode;

  @JMAutogen.InferredType(jsonFieldName="error_data")
  final String mErrorData;

  @JMAutogen.InferredType(jsonFieldName="error_msg")
  final String mErrorMsg;

  protected FacebookApiException$ServerExceptionData()
  {
    this.mErrorCode = -1;
    this.mErrorMsg = null;
    this.mErrorData = null;
  }

  public FacebookApiException$ServerExceptionData(int paramInt, String paramString)
  {
    this.mErrorCode = paramInt;
    this.mErrorMsg = paramString;
    this.mErrorData = null;
  }

  public FacebookApiException$ServerExceptionData(int paramInt, String paramString1, String paramString2)
  {
    this.mErrorCode = paramInt;
    this.mErrorMsg = paramString1;
    this.mErrorData = paramString2;
  }

  public String a()
  {
    return this.mErrorData;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookApiException.ServerExceptionData
 * JD-Core Version:    0.6.0
 */