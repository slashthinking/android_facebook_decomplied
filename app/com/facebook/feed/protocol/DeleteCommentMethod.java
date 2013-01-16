package com.facebook.feed.protocol;

import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class DeleteCommentMethod
  implements ApiMethod<DeleteCommentParams, Void>
{
  public ApiRequest a(DeleteCommentParams paramDeleteCommentParams)
  {
    ArrayList localArrayList = Lists.a();
    if (paramDeleteCommentParams.b != null)
    {
      localArrayList.add(new BasicNameValuePair("tracking", paramDeleteCommentParams.b));
      localArrayList.add(new BasicNameValuePair("format", "json"));
    }
    return new ApiRequest("graphCommentDelete", "DELETE", paramDeleteCommentParams.a, localArrayList, ApiResponseType.JSON);
  }

  public Void a(DeleteCommentParams paramDeleteCommentParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.DeleteCommentMethod
 * JD-Core Version:    0.6.0
 */