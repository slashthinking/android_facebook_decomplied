package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.IgnoreUnexpectedJsonFields;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

@JMAutogen.IgnoreUnexpectedJsonFields
public class FacebookVideo
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="display_url")
  private String mDisplayUrl;
  private FacebookVideo.VideoSource mSourceType;

  @JMAutogen.InferredType(jsonFieldName="source_type")
  private String mSourceType_internal;

  @JMAutogen.InferredType(jsonFieldName="source_url")
  private String mSourceUrl;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookVideo
 * JD-Core Version:    0.6.0
 */