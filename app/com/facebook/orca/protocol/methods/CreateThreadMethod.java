package com.facebook.orca.protocol.methods;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.ContentBody;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.threads.Message;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class CreateThreadMethod
  implements ApiMethod<CreateThreadMethod.Params, String>
{
  private final PickedUserUtils a;
  private final SendMessageParameterHelper b;

  public CreateThreadMethod(PickedUserUtils paramPickedUserUtils, SendMessageParameterHelper paramSendMessageParameterHelper)
  {
    this.a = paramPickedUserUtils;
    this.b = paramSendMessageParameterHelper;
  }

  public ApiRequest a(CreateThreadMethod.Params paramParams)
  {
    ArrayList localArrayList1 = Lists.a();
    CreateThreadParams localCreateThreadParams = CreateThreadMethod.Params.a(paramParams);
    if (localCreateThreadParams.c())
      localArrayList1.add(new BasicNameValuePair("name", localCreateThreadParams.b()));
    Message localMessage = localCreateThreadParams.a();
    this.b.a(localArrayList1, localMessage, CreateThreadMethod.Params.b(paramParams));
    ArrayList localArrayList2 = Lists.a();
    int i;
    int j;
    if ((localMessage.z()) && (CreateThreadMethod.Params.b(paramParams) == null))
    {
      Iterator localIterator = localMessage.y().iterator();
      i = 1;
      if (localIterator.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator.next();
        ContentBody localContentBody = this.b.a(localMediaResource);
        if (localContentBody == null)
          break label233;
        StringBuilder localStringBuilder = new StringBuilder().append("image");
        j = i + 1;
        localArrayList2.add(new FormBodyPart(i, localContentBody));
      }
    }
    while (true)
    {
      i = j;
      break;
      localArrayList1.add(new BasicNameValuePair("to", this.a.a(localCreateThreadParams.d()).toString()));
      return new ApiRequest("createThread", "POST", "me/threads", localArrayList1, ApiResponseType.JSON, localArrayList2);
      label233: j = i;
    }
  }

  public String a(CreateThreadMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    return JSONUtil.b(paramApiResponse.c().get("tid"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.CreateThreadMethod
 * JD-Core Version:    0.6.0
 */