package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.IgnoreUnexpectedJsonFields;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

@JMAutogen.IgnoreUnexpectedJsonFields
public class GraphFeedPublishResponse
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="error")
  public final GraphFeedPublishError error = null;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final String id = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.GraphFeedPublishResponse
 * JD-Core Version:    0.6.0
 */