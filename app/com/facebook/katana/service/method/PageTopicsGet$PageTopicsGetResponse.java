package com.facebook.katana.service.method;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.katana.model.PageTopic;
import java.util.List;

class PageTopicsGet$PageTopicsGetResponse
  implements JMStaticKeysDictDestination
{

  @JMAutogen.ListType(b={PageTopic.class}, jsonFieldName="data")
  public final List<PageTopic> data = null;

  @JMAutogen.InferredType(jsonFieldName="summary")
  public final PageTopicsGet.PageTopicsGetResponse.PageTopicsGetResponseSummary summary = null;
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PageTopicsGet.PageTopicsGetResponse
 * JD-Core Version:    0.6.0
 */