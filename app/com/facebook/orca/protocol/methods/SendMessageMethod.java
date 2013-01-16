package com.facebook.orca.protocol.methods;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.audio.AudioFormBodyPart;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.ContentBody;
import com.facebook.orca.threads.Message;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SendMessageMethod
  implements ApiMethod<SendMessageMethod.Params, String>
{
  private static final Class<?> a = SendMessageMethod.class;
  private final SendMessageParameterHelper b;

  public SendMessageMethod(SendMessageParameterHelper paramSendMessageParameterHelper)
  {
    this.b = paramSendMessageParameterHelper;
  }

  public ApiRequest a(SendMessageMethod.Params paramParams)
  {
    ArrayList localArrayList1 = Lists.a();
    Message localMessage = SendMessageMethod.Params.a(paramParams);
    localArrayList1.add(new BasicNameValuePair("id", localMessage.b()));
    this.b.a(localArrayList1, localMessage, SendMessageMethod.Params.b(paramParams));
    ArrayList localArrayList2 = Lists.a();
    if ((localMessage.z()) && (SendMessageMethod.Params.b(paramParams) == null))
    {
      Iterator localIterator = localMessage.y().iterator();
      int i = 0;
      int j = 0;
      int k = 0;
      if (localIterator.hasNext())
      {
        MediaResource localMediaResource = (MediaResource)localIterator.next();
        ContentBody localContentBody = this.b.a(localMediaResource);
        if (localContentBody != null)
          switch (SendMessageMethod.1.a[localMediaResource.b().ordinal()])
          {
          default:
          case 1:
          case 2:
          case 3:
          }
        while (true)
        {
          int m = i;
          int n = j;
          int i1 = k;
          while (true)
          {
            k = i1;
            j = n;
            i = m;
            break;
            StringBuilder localStringBuilder3 = new StringBuilder().append("photo");
            int i3 = k + 1;
            localArrayList2.add(new FormBodyPart(i3, localContentBody));
            m = i;
            n = j;
            i1 = i3;
            continue;
            StringBuilder localStringBuilder2 = new StringBuilder().append("video");
            int i2 = j + 1;
            localArrayList2.add(new FormBodyPart(i2, localContentBody));
            m = i;
            n = i2;
            i1 = k;
          }
          StringBuilder localStringBuilder1 = new StringBuilder().append("audio");
          i++;
          localArrayList2.add(new AudioFormBodyPart(i, localContentBody, localMediaResource.f()));
        }
      }
    }
    return new ApiRequest("sendMessage", "POST", "", localArrayList1, ApiResponseType.JSON, localArrayList2);
  }

  public String a(SendMessageMethod.Params paramParams, ApiResponse paramApiResponse)
  {
    return JSONUtil.b(paramApiResponse.c().get("id"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SendMessageMethod
 * JD-Core Version:    0.6.0
 */