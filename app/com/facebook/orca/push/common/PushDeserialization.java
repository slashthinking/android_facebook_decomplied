package com.facebook.orca.push.common;

import android.telephony.SmsMessage;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.JSONUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.location.CoordinatesDeserializer;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.protocol.methods.SourceDeserializer;
import com.facebook.orca.sms.MmsSmsUserUtils;
import com.facebook.orca.sms.SmsContentResolverHandler;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Provider;

public class PushDeserialization
{
  private static final Class<?> a = PushDeserialization.class;
  private static AtomicLong h = new AtomicLong(0L);
  private final Provider<User> b;
  private final CoordinatesDeserializer c;
  private final SourceDeserializer d;
  private final Clock e;
  private final SmsContentResolverHandler f;
  private final MmsSmsUserUtils g;

  public PushDeserialization(Provider<User> paramProvider, CoordinatesDeserializer paramCoordinatesDeserializer, SourceDeserializer paramSourceDeserializer, Clock paramClock, SmsContentResolverHandler paramSmsContentResolverHandler, MmsSmsUserUtils paramMmsSmsUserUtils)
  {
    this.b = paramProvider;
    this.c = paramCoordinatesDeserializer;
    this.d = paramSourceDeserializer;
    this.e = paramClock;
    this.f = paramSmsContentResolverHandler;
    this.g = paramMmsSmsUserUtils;
  }

  public Message a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Coordinates paramCoordinates, List<MediaResource> paramList)
  {
    long l1 = this.e.a();
    if (paramLong1 == -1L)
      paramLong1 = l1;
    if (paramLong2 == -1L)
      paramLong2 = l1;
    User localUser = (User)this.b.b();
    ParticipantInfo localParticipantInfo = new ParticipantInfo(new UserKey(User.Type.FACEBOOK, localUser.b()), localUser.g(), localUser.b() + "@facebook.com");
    long l2 = 1000000L * paramLong1 + h.incrementAndGet();
    String str = "sent." + paramString2;
    return new MessageBuilder().a(paramInt).a(str).b(paramString1).e(paramString2).d(paramString3).a(paramLong1).b(paramLong2).c(l2).a(localParticipantInfo).a(paramCoordinates).a(true).a(Message.ChannelSource.SEND).f("mobile").e(paramList).v();
  }

  public Message a(SmsMessage paramSmsMessage, long paramLong1, long paramLong2)
  {
    String str1 = paramSmsMessage.getOriginatingAddress();
    paramSmsMessage.getPseudoSubject().trim();
    String str2 = paramSmsMessage.getDisplayMessageBody().trim();
    long l1 = this.f.a(paramLong1);
    User localUser = this.g.a(str1);
    ParticipantInfo localParticipantInfo = this.g.a(localUser);
    String str3 = MessagingIdUtil.a(l1);
    String str4 = MessagingIdUtil.b(paramLong1);
    long l2 = 1000000L * paramSmsMessage.getTimestampMillis() + h.incrementAndGet();
    return new MessageBuilder().a(str4).b(str3).c(paramSmsMessage.getPseudoSubject()).d(str2).a(paramLong2).d(paramLong2).c(l2).a(localParticipantInfo).a(true).a(Message.ChannelSource.SMS).f("sms").v();
  }

  public Message a(JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("sender_fbid"));
    boolean bool1 = Objects.equal(str1, "0");
    Message localMessage = null;
    if (bool1);
    while (true)
    {
      return localMessage;
      String str2 = JSONUtil.b(paramJsonNode.get("body"));
      String str3 = JSONUtil.b(paramJsonNode.get("tid"));
      String str4 = JSONUtil.b(paramJsonNode.get("mid"));
      String str5 = StringUtil.c(JSONUtil.b(paramJsonNode.get("offline_threading_id")));
      String str6 = JSONUtil.b(paramJsonNode.path("sender_name"));
      ParticipantInfo localParticipantInfo = new ParticipantInfo(new UserKey(User.Type.FACEBOOK, str1), str6, str1 + "@facebook.com");
      boolean bool2 = paramJsonNode.has("coordinates");
      Coordinates localCoordinates = null;
      if (bool2)
      {
        boolean bool3 = paramJsonNode.get("coordinates").isNull();
        localCoordinates = null;
        if (!bool3)
        {
          boolean bool4 = paramJsonNode.get("coordinates").isObject();
          localCoordinates = null;
          if (bool4)
            localCoordinates = this.c.a(paramJsonNode.get("coordinates"));
        }
      }
      String str7 = this.d.a(paramJsonNode.get("api_tags"));
      long l1 = JSONUtil.c(paramJsonNode.get("timestamp"));
      long l2 = 1000000L * l1 + h.incrementAndGet();
      localMessage = new MessageBuilder().a(str4).b(str3).e(str5).d(str2).a(l1).c(l2).a(localParticipantInfo).a(localCoordinates).a(true).f(str7).a(Message.ChannelSource.MQTT).v();
    }
  }

  public Message a(String paramString, JsonNode paramJsonNode)
  {
    String str1 = JSONUtil.b(paramJsonNode.get("uid"));
    boolean bool = Objects.equal(str1, "0");
    Message localMessage = null;
    if (!bool)
    {
      localMessage = null;
      if (str1 != null);
    }
    else
    {
      return localMessage;
    }
    String str2;
    label75: String str3;
    String str4;
    ParticipantInfo localParticipantInfo;
    String str5;
    if (paramString != null)
    {
      String[] arrayOfString = paramString.split(":", 2);
      if (arrayOfString.length == 2)
      {
        str2 = arrayOfString[0].trim();
        paramString = arrayOfString[1].trim();
        str3 = MessagingIdUtil.a(JSONUtil.b(paramJsonNode.get("unified_tid")));
        str4 = MessagingIdUtil.b(JSONUtil.b(paramJsonNode.get("n")));
        localParticipantInfo = new ParticipantInfo(new UserKey(User.Type.FACEBOOK, str1), str2, str1 + "@facebook.com");
        if (paramJsonNode.has("o"));
        switch (JSONUtil.d(paramJsonNode.get("o")))
        {
        default:
          str5 = null;
        case 1:
        case 2:
        case 3:
        }
      }
    }
    while (true)
    {
      long l1 = JSONUtil.c(paramJsonNode.get("s"));
      long l2 = 1000000L * l1 + h.incrementAndGet();
      localMessage = new MessageBuilder().a(str4).b(str3).d(paramString).a(l1).c(l2).a(localParticipantInfo).a(true).a(Message.ChannelSource.C2DM).f(str5).v();
      break;
      str2 = "";
      break label75;
      str2 = "";
      paramString = "";
      break label75;
      str5 = "web";
      continue;
      str5 = "mobile";
      continue;
      str5 = "messenger";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.common.PushDeserialization
 * JD-Core Version:    0.6.0
 */