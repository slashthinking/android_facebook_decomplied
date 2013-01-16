package com.facebook.orca.sms;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android_src.mms.ContentType;
import android_src.mms.MmsConfig;
import android_src.mms.MmsException;
import android_src.mms.dom.smil.parser.SmilXmlSerializer;
import android_src.mms.model.SmilHelper;
import android_src.mms.pdu.EncodedStringValue;
import android_src.mms.pdu.PduBody;
import android_src.mms.pdu.PduPart;
import android_src.mms.pdu.PduPersister;
import android_src.mms.pdu.SendReq;
import android_src.mms.ui.MessageUtils;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Mms.Outbox;
import com.facebook.orca.attachments.MediaAttachment;
import com.facebook.orca.attachments.MediaAttachmentUtil;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.media.MediaResource.Builder;
import com.facebook.orca.media.MediaResource.Type;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.Message.ChannelSource;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.users.User;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.w3c.dom.smil.SMILDocument;

class MmsContentResolverHandler
{
  private static final Class<?> a = MmsContentResolverHandler.class;
  private static final Uri b = Uri.parse("content://mms/part");
  private final Context c;
  private final MmsSmsUserUtils d;
  private final MediaAttachmentUtil e;

  MmsContentResolverHandler(Context paramContext, MmsSmsUserUtils paramMmsSmsUserUtils, MediaAttachmentUtil paramMediaAttachmentUtil)
  {
    this.c = paramContext;
    this.d = paramMmsSmsUserUtils;
    this.e = paramMediaAttachmentUtil;
  }

  private PduBody a(Message paramMessage)
  {
    PduBody localPduBody = new PduBody();
    int i = Math.max(MmsConfig.i(), MmsConfig.h());
    int j = -5000 + MmsConfig.a();
    int k = paramMessage.y().size();
    Iterator localIterator = paramMessage.y().iterator();
    int m = 1;
    int n = j;
    int i1 = k;
    if (localIterator.hasNext())
    {
      MediaResource localMediaResource = (MediaResource)localIterator.next();
      int i2 = n / i1;
      if (localMediaResource.b().equals(MediaResource.Type.PHOTO))
      {
        PduPart localPduPart2 = new PduPart();
        MediaAttachment localMediaAttachment = new MediaAttachment(this.c, localMediaResource);
        byte[] arrayOfByte = this.e.a(localMediaAttachment, i, i, i2);
        int i3 = arrayOfByte.length;
        localPduPart2.a(arrayOfByte);
        localPduPart2.e("image/jpeg".getBytes());
        localPduPart2.c(("IMG_" + i3 + "_" + m + ".jpg").getBytes());
        localPduPart2.b(("IMG_" + i3 + "_" + m).getBytes());
        localPduBody.a(localPduPart2);
        n -= i3;
      }
      while (true)
      {
        int i4 = i1 - 1;
        m++;
        i1 = i4;
        break;
        if ((localMediaResource.b().equals(MediaResource.Type.AUDIO)) || (!localMediaResource.b().equals(MediaResource.Type.VIDEO)))
          continue;
      }
    }
    if (!StringUtil.a(paramMessage.h()))
    {
      String str = paramMessage.h();
      (m + 1);
      localPduBody.a(a(str, m));
    }
    SMILDocument localSMILDocument = SmilHelper.a(localPduBody);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    SmilXmlSerializer.a(localSMILDocument, localByteArrayOutputStream);
    PduPart localPduPart1 = new PduPart();
    localPduPart1.b("smil".getBytes());
    localPduPart1.c("smil.xml".getBytes());
    localPduPart1.e("application/smil".getBytes());
    localPduPart1.a(localByteArrayOutputStream.toByteArray());
    localPduBody.a(0, localPduPart1);
    return localPduBody;
  }

  private PduPart a(String paramString, int paramInt)
  {
    PduPart localPduPart = new PduPart();
    localPduPart.a(106);
    localPduPart.e("text/plain".getBytes());
    localPduPart.c(("text_" + paramInt + ".txt").getBytes());
    localPduPart.b(("text_" + paramInt).getBytes());
    localPduPart.a(paramString.getBytes());
    return localPduPart;
  }

  private SendReq a(Set<String> paramSet)
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = MessageUtils.b((String)localIterator.next());
      if (StringUtil.a(str))
        continue;
      localArrayList.add(str);
    }
    String[] arrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    SendReq localSendReq = new SendReq();
    EncodedStringValue[] arrayOfEncodedStringValue = EncodedStringValue.a(arrayOfString);
    if (arrayOfEncodedStringValue != null)
      localSendReq.a(arrayOfEncodedStringValue);
    localSendReq.a(System.currentTimeMillis() / 1000L);
    return localSendReq;
  }

  private Message a(Cursor paramCursor, ImmutableMultimap<Long, MmsContentResolverHandler.MmsPart> paramImmutableMultimap)
  {
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("thread_id"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("sub"));
    String str2 = MessagingIdUtil.a(l1);
    String str3 = MessagingIdUtil.c(l2);
    long l3 = 1000L * paramCursor.getLong(paramCursor.getColumnIndex("date"));
    long l4 = 1000000L * l3;
    ImmutableCollection localImmutableCollection = paramImmutableMultimap.c(Long.valueOf(l2));
    ArrayList localArrayList1 = Lists.a();
    ArrayList localArrayList2 = Lists.a();
    Iterator localIterator = localImmutableCollection.iterator();
    while (localIterator.hasNext())
    {
      MmsContentResolverHandler.MmsPart localMmsPart = (MmsContentResolverHandler.MmsPart)localIterator.next();
      if (localMmsPart.b != null)
      {
        localArrayList2.add(localMmsPart.b);
        continue;
      }
      if (StringUtil.a(localMmsPart.a))
        continue;
      localArrayList1.add(localMmsPart.a);
    }
    String str4 = Joiner.on("\n\n").join(localArrayList1);
    int i = paramCursor.getInt(paramCursor.getColumnIndex("msg_box"));
    ParticipantInfo localParticipantInfo;
    if (i == 2)
      localParticipantInfo = this.d.a();
    while (true)
    {
      return new MessageBuilder().a(str3).b(str2).a(0).c(str1).d(str4).a(l3).c(l4).a(localParticipantInfo).a(localArrayList2).a(false).f("mms").a(Message.ChannelSource.MMS).v();
      localParticipantInfo = null;
      if (i != 1)
        continue;
      localParticipantInfo = c(l2);
    }
  }

  static String a(String paramString)
  {
    if (StringUtil.a(paramString));
    Object[] arrayOfObject;
    for (String str = StringLocaleUtil.a("SELECT MAX(date)*1000 AS normalized_date, thread_id AS thread_id, MAX(_id) AS _id FROM pdu WHERE %1$s GROUP BY thread_id", new Object[] { "m_type IN (128, 132) AND msg_box IN (1, 2)" }); ; str = StringLocaleUtil.a("SELECT MAX(date)*1000 AS normalized_date, thread_id AS thread_id, MAX(_id) AS _id FROM pdu WHERE %1$s GROUP BY thread_id", arrayOfObject))
    {
      return str;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = ("m_type IN (128, 132) AND msg_box IN (1, 2) AND " + paramString);
    }
  }

  // ERROR //
  private String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 128	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 391
    //   10: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_1
    //   14: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 27	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore_3
    //   24: aload_0
    //   25: getfield 35	com/facebook/orca/sms/MmsContentResolverHandler:c	Landroid/content/Context;
    //   28: invokevirtual 397	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_3
    //   32: invokevirtual 403	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   35: astore 7
    //   37: new 405	java/io/InputStreamReader
    //   40: dup
    //   41: aload 7
    //   43: aload_2
    //   44: invokespecial 408	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: invokestatic 413	com/google/common/io/CharStreams:a	(Ljava/lang/Readable;)Ljava/lang/String;
    //   50: astore 9
    //   52: aload 9
    //   54: astore 5
    //   56: aload 7
    //   58: invokevirtual 418	java/io/InputStream:close	()V
    //   61: aload 5
    //   63: areturn
    //   64: astore 8
    //   66: aload 7
    //   68: invokevirtual 418	java/io/InputStream:close	()V
    //   71: aload 8
    //   73: athrow
    //   74: astore 4
    //   76: ldc_w 420
    //   79: astore 5
    //   81: aload 4
    //   83: astore 6
    //   85: getstatic 19	com/facebook/orca/sms/MmsContentResolverHandler:a	Ljava/lang/Class;
    //   88: ldc_w 422
    //   91: aload 6
    //   93: invokestatic 427	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: goto -35 -> 61
    //   99: astore 6
    //   101: goto -16 -> 85
    //
    // Exception table:
    //   from	to	target	type
    //   37	52	64	finally
    //   24	37	74	java/io/IOException
    //   66	74	74	java/io/IOException
    //   56	61	99	java/io/IOException
  }

  private String a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 == null);
    for (String str = ""; ; str = paramString2 + " AND ")
      return "_id IN (SELECT mms._id FROM (" + a(paramString1) + ") mms " + "LEFT JOIN " + "(" + SmsContentResolverHandler.a(paramString1) + ") sms " + "ON sms.thread_id=mms.thread_id " + "WHERE " + str + "(sms.normalized_date<mms.normalized_date OR sms.normalized_date IS NULL) " + "ORDER BY mms.normalized_date DESC " + "LIMIT " + paramInt + ")";
  }

  private void a(SendReq paramSendReq)
  {
    paramSendReq.b(604800L);
    paramSendReq.c(129);
    paramSendReq.d(129);
    paramSendReq.e(129);
  }

  private ImmutableList<FetchMmsSmsThreadSummaryResult> b(String paramString)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Cursor localCursor = this.c.getContentResolver().query(Telephony.Mms.a, MmsSmsProjections.e, paramString, null, "date DESC");
    while (true)
    {
      boolean bool;
      try
      {
        int i = localCursor.getColumnIndex("thread_id");
        int j = localCursor.getColumnIndex("_id");
        int k = localCursor.getColumnIndex("date");
        int m = localCursor.getColumnIndex("read");
        int n = localCursor.getColumnIndex("sub");
        if (!localCursor.moveToNext())
          break;
        long l1 = localCursor.getLong(i);
        long l2 = localCursor.getLong(j);
        long l3 = 1000L * localCursor.getLong(k);
        int i1 = localCursor.getInt(m);
        String str = localCursor.getString(n);
        if (i1 != 0)
          continue;
        bool = true;
        localBuilder.b(new FetchMmsSmsThreadSummaryResult(l1, l2, l3, bool, str));
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    return localBuilder.b();
  }

  private String b(FetchMmsSmsThreadListParams paramFetchMmsSmsThreadListParams)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mms.normalized_date");
    if (paramFetchMmsSmsThreadListParams.b() != null)
    {
      localStringBuilder.append(">");
      localStringBuilder.append(paramFetchMmsSmsThreadListParams.b());
    }
    while (true)
    {
      return a(null, localStringBuilder.toString(), 1 + paramFetchMmsSmsThreadListParams.a());
      localStringBuilder.append("<=");
      localStringBuilder.append(paramFetchMmsSmsThreadListParams.c());
    }
  }

  private ParticipantInfo c(long paramLong)
  {
    Uri localUri = Uri.withAppendedPath(ContentUris.withAppendedId(Telephony.Mms.a, paramLong), "addr");
    Cursor localCursor = this.c.getContentResolver().query(localUri, null, "type=137", null, null);
    try
    {
      if (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("address"));
        User localUser = this.d.a(str);
        ParticipantInfo localParticipantInfo2 = this.d.a(localUser);
        localParticipantInfo1 = localParticipantInfo2;
        return localParticipantInfo1;
      }
      localCursor.close();
      ParticipantInfo localParticipantInfo1 = null;
    }
    finally
    {
      localCursor.close();
    }
  }

  private String c(List<Long> paramList)
  {
    return a("thread_id IN " + SqlUtil.a(paramList), null, paramList.size());
  }

  private ImmutableMultimap<Long, MmsContentResolverHandler.MmsPart> d(List<Long> paramList)
  {
    ImmutableMultimap.Builder localBuilder = ImmutableMultimap.j();
    String str1 = "mid IN " + SqlUtil.a(paramList);
    Cursor localCursor = this.c.getContentResolver().query(b, null, str1, null, null);
    while (true)
    {
      String str2;
      String str4;
      MediaResource.Builder localBuilder1;
      try
      {
        if (!localCursor.moveToNext())
          break;
        long l = localCursor.getLong(localCursor.getColumnIndex("mid"));
        str2 = localCursor.getString(localCursor.getColumnIndex("ct"));
        String str3 = localCursor.getString(localCursor.getColumnIndex("name"));
        str4 = localCursor.getString(localCursor.getColumnIndex("fn"));
        String str5 = localCursor.getString(localCursor.getColumnIndex("_id"));
        String str6 = localCursor.getString(localCursor.getColumnIndex("chset"));
        String str7 = localCursor.getString(localCursor.getColumnIndex("_data"));
        String str8 = localCursor.getString(localCursor.getColumnIndex("text"));
        localBuilder1 = MediaResource.a();
        if ("text/plain".equals(str2))
        {
          if (str7 == null)
            continue;
          str8 = a(str5, str6);
          localMmsPart = MmsContentResolverHandler.MmsPart.a(str8);
          if (localBuilder1.a() == null)
            continue;
          MediaResource.Builder localBuilder2 = localBuilder1.a(Uri.parse("content://mms/part/" + str5)).a(str2);
          if (!StringUtil.a(str4))
            break label418;
          str9 = str3;
          localMmsPart = MmsContentResolverHandler.MmsPart.a(localBuilder2.b(str9).f());
          if (localMmsPart == null)
            continue;
          localBuilder.a(Long.valueOf(l), localMmsPart);
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      if (ContentType.b(str2))
      {
        localBuilder1.a(MediaResource.Type.PHOTO);
        localMmsPart = null;
        continue;
      }
      if (ContentType.c(str2))
      {
        localBuilder1.a(MediaResource.Type.AUDIO);
        localMmsPart = null;
        continue;
      }
      if (ContentType.d(str2))
        localBuilder1.a(MediaResource.Type.VIDEO);
      MmsContentResolverHandler.MmsPart localMmsPart = null;
      continue;
      label418: String str9 = str4;
    }
    localCursor.close();
    return localBuilder.a();
  }

  long a(Message paramMessage, Set<String> paramSet)
  {
    SendReq localSendReq = a(paramSet);
    localSendReq.a(a(paramMessage));
    a(localSendReq);
    localSendReq.b("personal".getBytes());
    localSendReq.a(System.currentTimeMillis() / 1000L);
    return Long.parseLong(PduPersister.a(this.c).a(localSendReq, Telephony.Mms.Outbox.a).getLastPathSegment());
  }

  Message a(long paramLong)
  {
    Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(paramLong);
    ImmutableList localImmutableList = b(Lists.a(arrayOfLong));
    if (localImmutableList.size() > 0);
    for (Message localMessage = (Message)localImmutableList.get(0); ; localMessage = null)
      return localMessage;
  }

  ImmutableList<Long> a(FetchMmsSmsMessagesParams paramFetchMmsSmsMessagesParams)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    SqlQueryBuilder.Expression localExpression;
    if (paramFetchMmsSmsMessagesParams.c() != null)
      localExpression = SqlQueryBuilder.d("date", Long.toString(paramFetchMmsSmsMessagesParams.c().longValue() / 1000L));
    Cursor localCursor;
    while (true)
    {
      SqlQueryBuilder.Expression[] arrayOfExpression = new SqlQueryBuilder.Expression[3];
      arrayOfExpression[0] = SqlQueryBuilder.a("thread_id", Long.toString(paramFetchMmsSmsMessagesParams.a()));
      arrayOfExpression[1] = SqlQueryBuilder.a("m_type IN (128, 132) AND msg_box IN (1, 2)");
      arrayOfExpression[2] = localExpression;
      SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a(arrayOfExpression);
      localCursor = this.c.getContentResolver().query(Telephony.Mms.a, MmsSmsProjections.d, localAndExpression.a(), localAndExpression.b(), "date DESC LIMIT " + (1 + paramFetchMmsSmsMessagesParams.b()));
      try
      {
        int i = localCursor.getColumnIndex("_id");
        if (!localCursor.moveToNext())
          break;
        localBuilder.b(Long.valueOf(localCursor.getLong(i)));
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
    return localBuilder.b();
  }

  ImmutableList<FetchMmsSmsThreadSummaryResult> a(FetchMmsSmsThreadListParams paramFetchMmsSmsThreadListParams)
  {
    return b(b(paramFetchMmsSmsThreadListParams));
  }

  ImmutableList<FetchMmsSmsThreadSummaryResult> a(ImmutableList<FetchMmsSmsThreadSummaryResult> paramImmutableList)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(Long.valueOf(((FetchMmsSmsThreadSummaryResult)localIterator.next()).b()));
    ImmutableList localImmutableList = b(localArrayList);
    for (int i = 0; i < paramImmutableList.size(); i++)
    {
      FetchMmsSmsThreadSummaryResult localFetchMmsSmsThreadSummaryResult = (FetchMmsSmsThreadSummaryResult)paramImmutableList.get(i);
      Message localMessage = (Message)localImmutableList.get(i);
      localBuilder.b(FetchMmsSmsThreadSummaryResult.a(localFetchMmsSmsThreadSummaryResult, localMessage.h(), localMessage.f()));
    }
    return localBuilder.b();
  }

  ImmutableList<FetchMmsSmsThreadSummaryResult> a(List<Long> paramList)
  {
    return b(c(paramList));
  }

  void a(Collection<Long> paramCollection)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Integer.valueOf(1));
    this.c.getContentResolver().update(Telephony.Mms.a, localContentValues, "thread_id IN " + SqlUtil.a(paramCollection), null);
  }

  ImmutableList<Message> b(List<Long> paramList)
  {
    if (paramList.isEmpty());
    ImmutableList.Builder localBuilder;
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = localBuilder.b())
    {
      return localImmutableList;
      localBuilder = ImmutableList.e();
      ImmutableMultimap localImmutableMultimap = d(paramList);
      String str = "_id IN " + SqlUtil.a(paramList);
      Cursor localCursor = this.c.getContentResolver().query(Telephony.Mms.a, MmsSmsProjections.f, str, null, null);
      try
      {
        while (true)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool)
            break;
          try
          {
            localBuilder.b(a(localCursor, localImmutableMultimap));
          }
          catch (MmsException localMmsException)
          {
            BLog.e(a, "Error making Mms message", localMmsException);
          }
        }
      }
      finally
      {
        localCursor.close();
      }
      localCursor.close();
    }
  }

  void b(long paramLong)
  {
    Uri localUri1 = Uri.parse("content://mms/" + paramLong);
    Uri localUri2 = Uri.withAppendedPath(localUri1, "part");
    Uri localUri3 = Uri.withAppendedPath(localUri1, "addr");
    this.c.getContentResolver().delete(localUri1, null, null);
    this.c.getContentResolver().delete(localUri2, null, null);
    this.c.getContentResolver().delete(localUri3, null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsContentResolverHandler
 * JD-Core Version:    0.6.0
 */