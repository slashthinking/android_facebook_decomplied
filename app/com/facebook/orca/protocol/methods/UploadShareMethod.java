package com.facebook.orca.protocol.methods;

import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.ContentBody;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import org.apache.http.message.BasicNameValuePair;

public class UploadShareMethod
  implements ApiMethod<MediaResource, String>
{
  private final MediaAttachmentFactory a;
  private final MediaAttachmentUtil b;

  public UploadShareMethod(MediaAttachmentFactory paramMediaAttachmentFactory, MediaAttachmentUtil paramMediaAttachmentUtil)
  {
    this.a = paramMediaAttachmentFactory;
    this.b = paramMediaAttachmentUtil;
  }

  public ApiRequest a(MediaResource paramMediaResource)
  {
    MediaAttachment localMediaAttachment = this.a.a(paramMediaResource);
    ContentBody localContentBody = this.b.a(localMediaAttachment);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    localBuilder.b(new BasicNameValuePair("attached_files", "attach"));
    localBuilder.b(new BasicNameValuePair("messaging_attachment", "true"));
    return new ApiRequest("attachment-upload", "POST", localMediaAttachment.d(), localBuilder.b(), ApiResponseType.JSON, new FormBodyPart("attach", localContentBody));
  }

  public String a(MediaResource paramMediaResource, ApiResponse paramApiResponse)
  {
    return JSONUtil.b(paramApiResponse.c().get("id"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.UploadShareMethod
 * JD-Core Version:    0.6.0
 */