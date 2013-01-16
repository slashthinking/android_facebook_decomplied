package com.facebook.orca.protocol.methods;

import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentFactory;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.base.ContentBody;
import com.facebook.orca.threads.Message;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SendMessageParameterHelper
{
  private final Class<?> a = SendMessageParameterHelper.class;
  private final MediaAttachmentFactory b;
  private final MediaAttachmentUtil c;

  public SendMessageParameterHelper(MediaAttachmentFactory paramMediaAttachmentFactory, MediaAttachmentUtil paramMediaAttachmentUtil)
  {
    this.b = paramMediaAttachmentFactory;
    this.c = paramMediaAttachmentUtil;
  }

  ContentBody a(MediaResource paramMediaResource)
  {
    ContentBody localContentBody = null;
    if (paramMediaResource == null)
      BLog.b(this.a, "No attachment found! Returning null...");
    while (true)
    {
      return localContentBody;
      MediaAttachment localMediaAttachment = this.b.b(paramMediaResource);
      if (localMediaAttachment == null)
      {
        BLog.b(this.a, "Unable to create an attachment from given resource");
        localContentBody = null;
        continue;
      }
      localContentBody = this.c.a(localMediaAttachment);
    }
  }

  ObjectNode a(Message paramMessage)
  {
    Coordinates localCoordinates = paramMessage.k();
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("latitude", localCoordinates.b());
    localObjectNode.put("longitude", localCoordinates.c());
    if (localCoordinates.e())
      localObjectNode.put("altitude", localCoordinates.d());
    if (localCoordinates.g())
      localObjectNode.put("accuracy", localCoordinates.f());
    if (localCoordinates.k())
      localObjectNode.put("heading", localCoordinates.j());
    if (localCoordinates.m())
      localObjectNode.put("speed", localCoordinates.l());
    return localObjectNode;
  }

  void a(List<NameValuePair> paramList, Message paramMessage, String paramString)
  {
    if (paramMessage.i())
      paramList.add(new BasicNameValuePair("message", paramMessage.h()));
    if (paramMessage.o())
      paramList.add(new BasicNameValuePair("coordinates", a(paramMessage).toString()));
    if (paramMessage.u())
      paramList.add(new BasicNameValuePair("offline_threading_id", paramMessage.t()));
    if (paramString != null)
      paramList.add(new BasicNameValuePair("object_attachment", paramString));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SendMessageParameterHelper
 * JD-Core Version:    0.6.0
 */