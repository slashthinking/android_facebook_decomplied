package com.facebook.orca.protocol.methods;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.ContentBody;
import com.facebook.orca.server.ModifyThreadParams;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SetThreadImageMethod
  implements ApiMethod<ModifyThreadParams, Void>
{
  private final MediaAttachmentFactory a;
  private final MediaAttachmentUtil b;

  public SetThreadImageMethod(MediaAttachmentFactory paramMediaAttachmentFactory, MediaAttachmentUtil paramMediaAttachmentUtil)
  {
    this.a = paramMediaAttachmentFactory;
    this.b = paramMediaAttachmentUtil;
  }

  private FormBodyPart b(ModifyThreadParams paramModifyThreadParams)
  {
    MediaResource localMediaResource = paramModifyThreadParams.e();
    MediaAttachment localMediaAttachment = this.a.b(localMediaResource);
    if (localMediaAttachment == null)
      throw new Exception("Failed to attach image");
    ContentBody localContentBody = this.b.a(localMediaAttachment);
    if (localContentBody == null)
      throw new Exception("Failed to attach image");
    return new FormBodyPart("image", localContentBody);
  }

  public ApiRequest a(ModifyThreadParams paramModifyThreadParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("format", "json"));
    localArrayList.add(new BasicNameValuePair("tid", paramModifyThreadParams.a()));
    if (paramModifyThreadParams.e() != null);
    for (FormBodyPart localFormBodyPart = b(paramModifyThreadParams); ; localFormBodyPart = null)
    {
      return new ApiRequest("setThreadImage", "POST", "method/messaging.setthreadimage", localArrayList, ApiResponseType.STRING, localFormBodyPart);
      localArrayList.add(new BasicNameValuePair("delete", "1"));
    }
  }

  public Void a(ModifyThreadParams paramModifyThreadParams, ApiResponse paramApiResponse)
  {
    paramApiResponse.g();
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SetThreadImageMethod
 * JD-Core Version:    0.6.0
 */