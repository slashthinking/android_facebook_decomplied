package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.IgnoreUnexpectedJsonFields;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.fasterxml.jackson.core.JsonParser;

@JMAutogen.IgnoreUnexpectedJsonFields
public class FacebookVideoUploadResponse
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="link")
  public final String link = null;

  @JMAutogen.InferredType(jsonFieldName="vid")
  public final String vid = null;

  public static FacebookVideoUploadResponse a(JsonParser paramJsonParser)
  {
    return (FacebookVideoUploadResponse)JMParser.a(paramJsonParser, FacebookVideoUploadResponse.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookVideoUploadResponse
 * JD-Core Version:    0.6.0
 */