package com.facebook.feed.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class HideTimelineStoryMethod
  implements ApiMethod<HideTimelineStoryMethod.Params, Void>
{
  public ApiRequest a(HideTimelineStoryMethod.Params paramParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("timeline_visibility", "hidden"));
    localArrayList.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("hideStory", "POST", paramParams.a, localArrayList, ApiResponseType.JSON);
  }

  public Void a(HideTimelineStoryMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.HideTimelineStoryMethod
 * JD-Core Version:    0.6.0
 */