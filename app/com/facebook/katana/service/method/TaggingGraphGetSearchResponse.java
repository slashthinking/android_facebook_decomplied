package com.facebook.katana.service.method;

import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.fasterxml.jackson.core.JsonParser;
import java.util.List;

public class TaggingGraphGetSearchResponse
  implements JMStaticKeysDictDestination
{
  private static final String DATA_KEY = "data";

  @JMAutogen.ListType(b={TaggingGraphGetTaggeeResponse.class}, jsonFieldName="data")
  private List<TaggingGraphGetTaggeeResponse> mTaggeeResults = null;

  public static TaggingGraphGetSearchResponse a(JsonParser paramJsonParser)
  {
    return (TaggingGraphGetSearchResponse)JMParser.a(paramJsonParser, TaggingGraphGetSearchResponse.class);
  }

  public List<TaggingGraphGetTaggeeResponse> a()
  {
    return this.mTaggeeResults;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.TaggingGraphGetSearchResponse
 * JD-Core Version:    0.6.0
 */