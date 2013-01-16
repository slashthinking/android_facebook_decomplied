package com.facebook.composer.protocol;

import android.os.Parcelable;
import com.facebook.composer.model.ImplicitLocation;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class PublishLocationMethod
  implements ApiMethod<PublishLocationParams, Parcelable>
{
  public Parcelable a(PublishLocationParams paramPublishLocationParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.c();
    return null;
  }

  public ApiRequest a(PublishLocationParams paramPublishLocationParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("project", paramPublishLocationParams.a));
    localArrayList.add(new BasicNameValuePair("setting", paramPublishLocationParams.b));
    localArrayList.add(new BasicNameValuePair("value", Integer.toString(paramPublishLocationParams.c.getCode())));
    return new ApiRequest("graphObjectLocation", "POST", "me/settings", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishLocationMethod
 * JD-Core Version:    0.6.2
 */