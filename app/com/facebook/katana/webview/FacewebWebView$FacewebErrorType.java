package com.facebook.katana.webview;

public enum FacewebWebView$FacewebErrorType
{
  private int mErrorMessageId;

  static
  {
    AUTHENTICATION_ERROR = new FacewebErrorType("AUTHENTICATION_ERROR", 1);
    UNKNOWN_ERROR = new FacewebErrorType("UNKNOWN_ERROR", 2, 2131362886);
    SSL_ERROR = new FacewebErrorType("SSL_ERROR", 3, 2131362887);
    CONNECTION_ERROR = new FacewebErrorType("CONNECTION_ERROR", 4, 2131362885);
    SITE_ERROR = new FacewebErrorType("SITE_ERROR", 5, 2131362886);
    INVALID_HTML_ERROR = new FacewebErrorType("INVALID_HTML_ERROR", 6, 2131362886);
    FacewebErrorType[] arrayOfFacewebErrorType = new FacewebErrorType[7];
    arrayOfFacewebErrorType[0] = AUTHENTICATION_NETWORK_ERROR;
    arrayOfFacewebErrorType[1] = AUTHENTICATION_ERROR;
    arrayOfFacewebErrorType[2] = UNKNOWN_ERROR;
    arrayOfFacewebErrorType[3] = SSL_ERROR;
    arrayOfFacewebErrorType[4] = CONNECTION_ERROR;
    arrayOfFacewebErrorType[5] = SITE_ERROR;
    arrayOfFacewebErrorType[6] = INVALID_HTML_ERROR;
    $VALUES = arrayOfFacewebErrorType;
  }

  private FacewebWebView$FacewebErrorType()
  {
  }

  private FacewebWebView$FacewebErrorType(int paramInt)
  {
    this.mErrorMessageId = paramInt;
  }

  public int getErrorMessageId()
  {
    return this.mErrorMessageId;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.FacewebWebView.FacewebErrorType
 * JD-Core Version:    0.6.0
 */