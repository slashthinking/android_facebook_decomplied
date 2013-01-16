package android_src.mms.pdu;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android_src.database.sqlite.SqliteWrapper;
import android_src.mms.MmsException;
import android_src.mms.ui.MessageUtils;
import android_src.mms.util.PduCache;
import android_src.mms.util.PduCacheEntry;
import android_src.provider.Telephony.Mms.Draft;
import android_src.provider.Telephony.Mms.Inbox;
import android_src.provider.Telephony.Mms.Outbox;
import android_src.provider.Telephony.Mms.Sent;
import android_src.provider.Telephony.MmsSms.PendingMessages;
import android_src.provider.Telephony.Threads;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PduPersister
{
  private static PduPersister a;
  private static final PduCache b;
  private static final int[] c = { 129, 130, 137, 151 };
  private static final String[] d = { "_id", "msg_box", "thread_id", "retr_txt", "sub", "ct_l", "ct_t", "m_cls", "m_id", "resp_txt", "tr_id", "ct_cls", "d_rpt", "m_type", "v", "pri", "rr", "read_status", "rpt_a", "retr_st", "st", "date", "d_tm", "exp", "m_size", "sub_cs", "retr_txt_cs" };
  private static final String[] e = { "_id", "chset", "cd", "cid", "cl", "ct", "fn", "name", "text" };
  private static final HashMap<Uri, Integer> f = new HashMap();
  private static final HashMap<Integer, Integer> g;
  private static final HashMap<Integer, Integer> h;
  private static final HashMap<Integer, Integer> i;
  private static final HashMap<Integer, Integer> j;
  private static final HashMap<Integer, Integer> k;
  private static final HashMap<Integer, String> l;
  private static final HashMap<Integer, String> m;
  private static final HashMap<Integer, String> n;
  private static final HashMap<Integer, String> o;
  private static final HashMap<Integer, String> p;
  private final Context q;
  private final ContentResolver r;

  static
  {
    f.put(Telephony.Mms.Inbox.a, Integer.valueOf(1));
    f.put(Telephony.Mms.Sent.a, Integer.valueOf(2));
    f.put(Telephony.Mms.Draft.a, Integer.valueOf(3));
    f.put(Telephony.Mms.Outbox.a, Integer.valueOf(4));
    g = new HashMap();
    g.put(Integer.valueOf(150), Integer.valueOf(25));
    g.put(Integer.valueOf(154), Integer.valueOf(26));
    l = new HashMap();
    l.put(Integer.valueOf(150), "sub_cs");
    l.put(Integer.valueOf(154), "retr_txt_cs");
    h = new HashMap();
    h.put(Integer.valueOf(154), Integer.valueOf(3));
    h.put(Integer.valueOf(150), Integer.valueOf(4));
    m = new HashMap();
    m.put(Integer.valueOf(154), "retr_txt");
    m.put(Integer.valueOf(150), "sub");
    i = new HashMap();
    i.put(Integer.valueOf(131), Integer.valueOf(5));
    i.put(Integer.valueOf(132), Integer.valueOf(6));
    i.put(Integer.valueOf(138), Integer.valueOf(7));
    i.put(Integer.valueOf(139), Integer.valueOf(8));
    i.put(Integer.valueOf(147), Integer.valueOf(9));
    i.put(Integer.valueOf(152), Integer.valueOf(10));
    n = new HashMap();
    n.put(Integer.valueOf(131), "ct_l");
    n.put(Integer.valueOf(132), "ct_t");
    n.put(Integer.valueOf(138), "m_cls");
    n.put(Integer.valueOf(139), "m_id");
    n.put(Integer.valueOf(147), "resp_txt");
    n.put(Integer.valueOf(152), "tr_id");
    j = new HashMap();
    j.put(Integer.valueOf(186), Integer.valueOf(11));
    j.put(Integer.valueOf(134), Integer.valueOf(12));
    j.put(Integer.valueOf(140), Integer.valueOf(13));
    j.put(Integer.valueOf(141), Integer.valueOf(14));
    j.put(Integer.valueOf(143), Integer.valueOf(15));
    j.put(Integer.valueOf(144), Integer.valueOf(16));
    j.put(Integer.valueOf(155), Integer.valueOf(17));
    j.put(Integer.valueOf(145), Integer.valueOf(18));
    j.put(Integer.valueOf(153), Integer.valueOf(19));
    j.put(Integer.valueOf(149), Integer.valueOf(20));
    o = new HashMap();
    o.put(Integer.valueOf(186), "ct_cls");
    o.put(Integer.valueOf(134), "d_rpt");
    o.put(Integer.valueOf(140), "m_type");
    o.put(Integer.valueOf(141), "v");
    o.put(Integer.valueOf(143), "pri");
    o.put(Integer.valueOf(144), "rr");
    o.put(Integer.valueOf(155), "read_status");
    o.put(Integer.valueOf(145), "rpt_a");
    o.put(Integer.valueOf(153), "retr_st");
    o.put(Integer.valueOf(149), "st");
    k = new HashMap();
    k.put(Integer.valueOf(133), Integer.valueOf(21));
    k.put(Integer.valueOf(135), Integer.valueOf(22));
    k.put(Integer.valueOf(136), Integer.valueOf(23));
    k.put(Integer.valueOf(142), Integer.valueOf(24));
    p = new HashMap();
    p.put(Integer.valueOf(133), "date");
    p.put(Integer.valueOf(135), "d_tm");
    p.put(Integer.valueOf(136), "exp");
    p.put(Integer.valueOf(142), "m_size");
    b = PduCache.b();
  }

  private PduPersister(Context paramContext)
  {
    this.q = paramContext;
    this.r = paramContext.getContentResolver();
  }

  public static PduPersister a(Context paramContext)
  {
    if ((a == null) || (!paramContext.equals(a.q)))
      a = new PduPersister(paramContext);
    return a;
  }

  private Integer a(Cursor paramCursor, int paramInt)
  {
    if (!paramCursor.isNull(paramInt));
    for (Integer localInteger = Integer.valueOf(paramCursor.getInt(paramInt)); ; localInteger = null)
      return localInteger;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      str = new String(paramArrayOfByte, "iso-8859-1");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        BLog.d("PduPersister", "ISO_8859_1 must be supported!", localUnsupportedEncodingException);
        String str = "";
      }
    }
  }

  private void a(long paramLong, int paramInt, EncodedStringValue[] paramArrayOfEncodedStringValue)
  {
    ContentValues localContentValues = new ContentValues(3);
    int i1 = paramArrayOfEncodedStringValue.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      EncodedStringValue localEncodedStringValue = paramArrayOfEncodedStringValue[i2];
      localContentValues.clear();
      localContentValues.put("address", a(localEncodedStringValue.b()));
      localContentValues.put("charset", Integer.valueOf(localEncodedStringValue.a()));
      localContentValues.put("type", Integer.valueOf(paramInt));
      Uri localUri = Uri.parse("content://mms/" + paramLong + "/addr");
      SqliteWrapper.a(this.q, this.r, localUri, localContentValues);
    }
  }

  private void a(long paramLong, PduHeaders paramPduHeaders)
  {
    Cursor localCursor = SqliteWrapper.a(this.q, this.r, Uri.parse("content://mms/" + paramLong + "/addr"), new String[] { "address", "charset", "type" }, null, null, null);
    if (localCursor != null)
    {
      while (true)
      {
        String str;
        int i1;
        try
        {
          if (!localCursor.moveToNext())
            break;
          str = localCursor.getString(0);
          if (TextUtils.isEmpty(str))
            continue;
          i1 = localCursor.getInt(2);
          switch (i1)
          {
          default:
            BLog.e("PduPersister", "Unknown address type: " + i1);
            continue;
          case 137:
          case 129:
          case 130:
          case 151:
          }
        }
        finally
        {
          localCursor.close();
        }
        paramPduHeaders.a(new EncodedStringValue(localCursor.getInt(1), a(str)), i1);
        continue;
        paramPduHeaders.b(new EncodedStringValue(localCursor.getInt(1), a(str)), i1);
      }
      localCursor.close();
    }
  }

  private void a(Cursor paramCursor, int paramInt1, PduHeaders paramPduHeaders, int paramInt2)
  {
    String str = paramCursor.getString(paramInt1);
    if ((str != null) && (str.length() > 0))
      paramPduHeaders.a(new EncodedStringValue(paramCursor.getInt(((Integer)g.get(Integer.valueOf(paramInt2))).intValue()), a(str)), paramInt2);
  }

  // ERROR //
  private void a(PduPart paramPduPart, Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 342	android_src/mms/pdu/PduPart:a	()[B
    //   7: astore 11
    //   9: ldc_w 344
    //   12: aload_3
    //   13: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifne +23 -> 39
    //   19: ldc_w 347
    //   22: aload_3
    //   23: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +13 -> 39
    //   29: ldc_w 349
    //   32: aload_3
    //   33: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +152 -> 188
    //   39: new 224	android/content/ContentValues
    //   42: dup
    //   43: invokespecial 350	android/content/ContentValues:<init>	()V
    //   46: astore 12
    //   48: aload 12
    //   50: ldc 110
    //   52: new 234	android_src/mms/pdu/EncodedStringValue
    //   55: dup
    //   56: aload 11
    //   58: invokespecial 353	android_src/mms/pdu/EncodedStringValue:<init>	([B)V
    //   61: invokevirtual 355	android_src/mms/pdu/EncodedStringValue:c	()Ljava/lang/String;
    //   64: invokevirtual 242	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 182	android_src/mms/pdu/PduPersister:r	Landroid/content/ContentResolver;
    //   71: aload_2
    //   72: aload 12
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 361	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   79: iconst_1
    //   80: if_icmpeq +84 -> 164
    //   83: new 363	android_src/mms/MmsException
    //   86: dup
    //   87: new 254	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 365
    //   97: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 366	android/net/Uri:toString	()Ljava/lang/String;
    //   104: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 369	android_src/mms/MmsException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    //   114: astore 10
    //   116: aconst_null
    //   117: astore 6
    //   119: ldc 212
    //   121: ldc_w 371
    //   124: aload 10
    //   126: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: new 363	android_src/mms/MmsException
    //   132: dup
    //   133: aload 10
    //   135: invokespecial 374	android_src/mms/MmsException:<init>	(Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: astore 7
    //   141: aload 6
    //   143: ifnull +8 -> 151
    //   146: aload 6
    //   148: invokevirtual 377	java/io/OutputStream:close	()V
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 380	java/io/InputStream:close	()V
    //   161: aload 7
    //   163: athrow
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull +8 -> 177
    //   172: aload 6
    //   174: invokevirtual 377	java/io/OutputStream:close	()V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 380	java/io/InputStream:close	()V
    //   187: return
    //   188: aload_0
    //   189: getfield 182	android_src/mms/pdu/PduPersister:r	Landroid/content/ContentResolver;
    //   192: aload_2
    //   193: invokevirtual 384	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   196: astore 15
    //   198: aload 15
    //   200: astore 6
    //   202: aload 11
    //   204: ifnonnull +166 -> 370
    //   207: aload_1
    //   208: invokevirtual 387	android_src/mms/pdu/PduPart:b	()Landroid/net/Uri;
    //   211: astore 16
    //   213: aconst_null
    //   214: astore 4
    //   216: aload 16
    //   218: ifnull +12 -> 230
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 16
    //   226: aload_2
    //   227: if_acmpne +97 -> 324
    //   230: ldc 212
    //   232: ldc_w 389
    //   235: invokestatic 391	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload 6
    //   240: ifnull +8 -> 248
    //   243: aload 6
    //   245: invokevirtual 377	java/io/OutputStream:close	()V
    //   248: iconst_0
    //   249: ifeq -62 -> 187
    //   252: aconst_null
    //   253: invokevirtual 380	java/io/InputStream:close	()V
    //   256: goto -69 -> 187
    //   259: astore 19
    //   261: ldc 212
    //   263: new 254	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 393
    //   273: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aconst_null
    //   277: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: aload 19
    //   285: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -101 -> 187
    //   291: astore 20
    //   293: ldc 212
    //   295: new 254	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 393
    //   305: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 6
    //   310: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aload 20
    //   318: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   321: goto -73 -> 248
    //   324: aload_0
    //   325: getfield 182	android_src/mms/pdu/PduPersister:r	Landroid/content/ContentResolver;
    //   328: aload 16
    //   330: invokevirtual 400	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   333: astore 4
    //   335: sipush 256
    //   338: newarray byte
    //   340: astore 17
    //   342: aload 4
    //   344: aload 17
    //   346: invokevirtual 404	java/io/InputStream:read	([B)I
    //   349: istore 18
    //   351: iload 18
    //   353: iconst_m1
    //   354: if_icmpeq -187 -> 167
    //   357: aload 6
    //   359: aload 17
    //   361: iconst_0
    //   362: iload 18
    //   364: invokevirtual 408	java/io/OutputStream:write	([BII)V
    //   367: goto -25 -> 342
    //   370: aload 6
    //   372: aload 11
    //   374: invokevirtual 410	java/io/OutputStream:write	([B)V
    //   377: aconst_null
    //   378: astore 4
    //   380: goto -213 -> 167
    //   383: astore 5
    //   385: ldc 212
    //   387: ldc_w 412
    //   390: aload 5
    //   392: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: new 363	android_src/mms/MmsException
    //   398: dup
    //   399: aload 5
    //   401: invokespecial 374	android_src/mms/MmsException:<init>	(Ljava/lang/Throwable;)V
    //   404: athrow
    //   405: astore 14
    //   407: ldc 212
    //   409: new 254	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 393
    //   419: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 6
    //   424: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload 14
    //   432: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   435: goto -258 -> 177
    //   438: astore 13
    //   440: ldc 212
    //   442: new 254	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 393
    //   452: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: aload 13
    //   465: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: goto -281 -> 187
    //   471: astore 9
    //   473: ldc 212
    //   475: new 254	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 393
    //   485: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 6
    //   490: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: aload 9
    //   498: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: goto -350 -> 151
    //   504: astore 8
    //   506: ldc 212
    //   508: new 254	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 393
    //   518: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload 4
    //   523: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: aload 8
    //   531: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   534: goto -373 -> 161
    //   537: astore 7
    //   539: aconst_null
    //   540: astore 4
    //   542: aconst_null
    //   543: astore 6
    //   545: goto -404 -> 141
    //   548: astore 5
    //   550: aconst_null
    //   551: astore 4
    //   553: aconst_null
    //   554: astore 6
    //   556: goto -171 -> 385
    //   559: astore 10
    //   561: goto -442 -> 119
    //
    // Exception table:
    //   from	to	target	type
    //   3	114	114	java/io/FileNotFoundException
    //   188	198	114	java/io/FileNotFoundException
    //   119	139	139	finally
    //   207	238	139	finally
    //   324	377	139	finally
    //   385	405	139	finally
    //   252	256	259	java/io/IOException
    //   243	248	291	java/io/IOException
    //   207	238	383	java/io/IOException
    //   324	377	383	java/io/IOException
    //   172	177	405	java/io/IOException
    //   182	187	438	java/io/IOException
    //   146	151	471	java/io/IOException
    //   156	161	504	java/io/IOException
    //   3	114	537	finally
    //   188	198	537	finally
    //   3	114	548	java/io/IOException
    //   188	198	548	java/io/IOException
    //   207	238	559	java/io/FileNotFoundException
    //   324	377	559	java/io/FileNotFoundException
  }

  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("iso-8859-1");
      arrayOfByte1 = arrayOfByte2;
      return arrayOfByte1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        BLog.d("PduPersister", "ISO_8859_1 must be supported!", localUnsupportedEncodingException);
        byte[] arrayOfByte1 = new byte[0];
      }
    }
  }

  private void b(Cursor paramCursor, int paramInt1, PduHeaders paramPduHeaders, int paramInt2)
  {
    String str = paramCursor.getString(paramInt1);
    if (str != null)
      paramPduHeaders.a(a(str), paramInt2);
  }

  private byte[] b(Cursor paramCursor, int paramInt)
  {
    if (!paramCursor.isNull(paramInt));
    for (byte[] arrayOfByte = a(paramCursor.getString(paramInt)); ; arrayOfByte = null)
      return arrayOfByte;
  }

  // ERROR //
  private PduPart[] b(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 174	android_src/mms/pdu/PduPersister:q	Landroid/content/Context;
    //   6: aload_0
    //   7: getfield 182	android_src/mms/pdu/PduPersister:r	Landroid/content/ContentResolver;
    //   10: new 254	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 257
    //   20: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc_w 422
    //   30: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 276	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: getstatic 112	android_src/mms/pdu/PduPersister:e	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokestatic 285	android_src/database/sqlite/SqliteWrapper:a	(Landroid/content/Context;Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnull +17 -> 69
    //   55: aload 4
    //   57: invokeinterface 425 1 0
    //   62: istore 7
    //   64: iload 7
    //   66: ifne +21 -> 87
    //   69: aconst_null
    //   70: astore 5
    //   72: aload 4
    //   74: ifnull +10 -> 84
    //   77: aload 4
    //   79: invokeinterface 309 1 0
    //   84: aload 5
    //   86: areturn
    //   87: aload 4
    //   89: invokeinterface 425 1 0
    //   94: anewarray 340	android_src/mms/pdu/PduPart
    //   97: astore 8
    //   99: iconst_0
    //   100: istore 9
    //   102: aload 4
    //   104: invokeinterface 289 1 0
    //   109: ifeq +529 -> 638
    //   112: new 340	android_src/mms/pdu/PduPart
    //   115: dup
    //   116: invokespecial 426	android_src/mms/pdu/PduPart:<init>	()V
    //   119: astore 10
    //   121: aload_0
    //   122: aload 4
    //   124: iconst_1
    //   125: invokespecial 428	android_src/mms/pdu/PduPersister:a	(Landroid/database/Cursor;I)Ljava/lang/Integer;
    //   128: astore 11
    //   130: aload 11
    //   132: ifnull +13 -> 145
    //   135: aload 10
    //   137: aload 11
    //   139: invokevirtual 333	java/lang/Integer:intValue	()I
    //   142: invokevirtual 430	android_src/mms/pdu/PduPart:a	(I)V
    //   145: aload_0
    //   146: aload 4
    //   148: iconst_2
    //   149: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   152: astore 12
    //   154: aload 12
    //   156: ifnull +10 -> 166
    //   159: aload 10
    //   161: aload 12
    //   163: invokevirtual 434	android_src/mms/pdu/PduPart:d	([B)V
    //   166: aload_0
    //   167: aload 4
    //   169: iconst_3
    //   170: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   173: astore 13
    //   175: aload 13
    //   177: ifnull +10 -> 187
    //   180: aload 10
    //   182: aload 13
    //   184: invokevirtual 436	android_src/mms/pdu/PduPart:b	([B)V
    //   187: aload_0
    //   188: aload 4
    //   190: iconst_4
    //   191: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   194: astore 14
    //   196: aload 14
    //   198: ifnull +10 -> 208
    //   201: aload 10
    //   203: aload 14
    //   205: invokevirtual 438	android_src/mms/pdu/PduPart:c	([B)V
    //   208: aload_0
    //   209: aload 4
    //   211: iconst_5
    //   212: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   215: astore 15
    //   217: aload 15
    //   219: ifnull +241 -> 460
    //   222: aload 10
    //   224: aload 15
    //   226: invokevirtual 440	android_src/mms/pdu/PduPart:e	([B)V
    //   229: aload_0
    //   230: aload 4
    //   232: bipush 6
    //   234: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   237: astore 16
    //   239: aload 16
    //   241: ifnull +10 -> 251
    //   244: aload 10
    //   246: aload 16
    //   248: invokevirtual 442	android_src/mms/pdu/PduPart:h	([B)V
    //   251: aload_0
    //   252: aload 4
    //   254: bipush 7
    //   256: invokespecial 432	android_src/mms/pdu/PduPersister:b	(Landroid/database/Cursor;I)[B
    //   259: astore 17
    //   261: aload 17
    //   263: ifnull +10 -> 273
    //   266: aload 10
    //   268: aload 17
    //   270: invokevirtual 444	android_src/mms/pdu/PduPart:g	([B)V
    //   273: aload 4
    //   275: iconst_0
    //   276: invokeinterface 448 2 0
    //   281: lstore 18
    //   283: new 254	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 450
    //   293: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: lload 18
    //   298: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 276	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   307: astore 20
    //   309: aload 10
    //   311: aload 20
    //   313: invokevirtual 453	android_src/mms/pdu/PduPart:a	(Landroid/net/Uri;)V
    //   316: aload 15
    //   318: invokestatic 239	android_src/mms/pdu/PduPersister:a	([B)Ljava/lang/String;
    //   321: astore 21
    //   323: aload 21
    //   325: invokestatic 458	android_src/mms/ContentType:e	(Ljava/lang/String;)Z
    //   328: ifne +112 -> 440
    //   331: aload 21
    //   333: invokestatic 460	android_src/mms/ContentType:f	(Ljava/lang/String;)Z
    //   336: ifne +104 -> 440
    //   339: aload 21
    //   341: invokestatic 462	android_src/mms/ContentType:g	(Ljava/lang/String;)Z
    //   344: ifne +96 -> 440
    //   347: new 464	java/io/ByteArrayOutputStream
    //   350: dup
    //   351: invokespecial 465	java/io/ByteArrayOutputStream:<init>	()V
    //   354: astore 23
    //   356: ldc_w 344
    //   359: aload 21
    //   361: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   364: ifne +25 -> 389
    //   367: ldc_w 347
    //   370: aload 21
    //   372: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   375: ifne +14 -> 389
    //   378: ldc_w 349
    //   381: aload 21
    //   383: invokevirtual 345	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   386: ifeq +109 -> 495
    //   389: aload 4
    //   391: bipush 8
    //   393: invokeinterface 293 2 0
    //   398: astore 24
    //   400: aload 24
    //   402: ifnull +86 -> 488
    //   405: new 234	android_src/mms/pdu/EncodedStringValue
    //   408: dup
    //   409: aload 24
    //   411: invokespecial 466	android_src/mms/pdu/EncodedStringValue:<init>	(Ljava/lang/String;)V
    //   414: invokevirtual 237	android_src/mms/pdu/EncodedStringValue:b	()[B
    //   417: astore 25
    //   419: aload 23
    //   421: aload 25
    //   423: iconst_0
    //   424: aload 25
    //   426: arraylength
    //   427: invokevirtual 467	java/io/ByteArrayOutputStream:write	([BII)V
    //   430: aload 10
    //   432: aload 23
    //   434: invokevirtual 470	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   437: invokevirtual 472	android_src/mms/pdu/PduPart:a	([B)V
    //   440: iload 9
    //   442: iconst_1
    //   443: iadd
    //   444: istore 22
    //   446: aload 8
    //   448: iload 9
    //   450: aload 10
    //   452: aastore
    //   453: iload 22
    //   455: istore 9
    //   457: goto -355 -> 102
    //   460: new 363	android_src/mms/MmsException
    //   463: dup
    //   464: ldc_w 474
    //   467: invokespecial 369	android_src/mms/MmsException:<init>	(Ljava/lang/String;)V
    //   470: athrow
    //   471: astore 6
    //   473: aload 4
    //   475: ifnull +10 -> 485
    //   478: aload 4
    //   480: invokeinterface 309 1 0
    //   485: aload 6
    //   487: athrow
    //   488: ldc 221
    //   490: astore 24
    //   492: goto -87 -> 405
    //   495: aload_0
    //   496: getfield 182	android_src/mms/pdu/PduPersister:r	Landroid/content/ContentResolver;
    //   499: aload 20
    //   501: invokevirtual 400	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   504: astore 29
    //   506: sipush 256
    //   509: newarray byte
    //   511: astore 30
    //   513: aload 29
    //   515: aload 30
    //   517: invokevirtual 404	java/io/InputStream:read	([B)I
    //   520: istore 31
    //   522: iload 31
    //   524: iflt +29 -> 553
    //   527: aload 23
    //   529: aload 30
    //   531: iconst_0
    //   532: iload 31
    //   534: invokevirtual 467	java/io/ByteArrayOutputStream:write	([BII)V
    //   537: aload 29
    //   539: aload 30
    //   541: invokevirtual 404	java/io/InputStream:read	([B)I
    //   544: istore 33
    //   546: iload 33
    //   548: istore 31
    //   550: goto -28 -> 522
    //   553: aload 29
    //   555: ifnull -125 -> 430
    //   558: aload 29
    //   560: invokevirtual 380	java/io/InputStream:close	()V
    //   563: goto -133 -> 430
    //   566: astore 32
    //   568: ldc 212
    //   570: ldc_w 476
    //   573: aload 32
    //   575: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   578: goto -148 -> 430
    //   581: astore 28
    //   583: ldc 212
    //   585: ldc_w 478
    //   588: aload 28
    //   590: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   593: aload 4
    //   595: invokeinterface 309 1 0
    //   600: new 363	android_src/mms/MmsException
    //   603: dup
    //   604: aload 28
    //   606: invokespecial 374	android_src/mms/MmsException:<init>	(Ljava/lang/Throwable;)V
    //   609: athrow
    //   610: astore 26
    //   612: aload_3
    //   613: ifnull +7 -> 620
    //   616: aload_3
    //   617: invokevirtual 380	java/io/InputStream:close	()V
    //   620: aload 26
    //   622: athrow
    //   623: astore 27
    //   625: ldc 212
    //   627: ldc_w 476
    //   630: aload 27
    //   632: invokestatic 219	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   635: goto -15 -> 620
    //   638: aload 4
    //   640: ifnull +10 -> 650
    //   643: aload 4
    //   645: invokeinterface 309 1 0
    //   650: aload 8
    //   652: astore 5
    //   654: goto -570 -> 84
    //   657: astore 26
    //   659: aload 29
    //   661: astore_3
    //   662: goto -50 -> 612
    //   665: astore 28
    //   667: aload 29
    //   669: astore_3
    //   670: goto -87 -> 583
    //
    // Exception table:
    //   from	to	target	type
    //   55	64	471	finally
    //   87	471	471	finally
    //   558	563	471	finally
    //   568	578	471	finally
    //   616	620	471	finally
    //   620	635	471	finally
    //   558	563	566	java/io/IOException
    //   495	506	581	java/io/IOException
    //   495	506	610	finally
    //   583	610	610	finally
    //   616	620	623	java/io/IOException
    //   506	546	657	finally
    //   506	546	665	java/io/IOException
  }

  private void c(Cursor paramCursor, int paramInt1, PduHeaders paramPduHeaders, int paramInt2)
  {
    if (!paramCursor.isNull(paramInt1))
      paramPduHeaders.a(paramCursor.getInt(paramInt1), paramInt2);
  }

  private void d(Cursor paramCursor, int paramInt1, PduHeaders paramPduHeaders, int paramInt2)
  {
    if (!paramCursor.isNull(paramInt1))
      paramPduHeaders.a(paramCursor.getLong(paramInt1), paramInt2);
  }

  public Cursor a(long paramLong)
  {
    Uri.Builder localBuilder = Telephony.MmsSms.PendingMessages.a.buildUpon();
    localBuilder.appendQueryParameter("protocol", "mms");
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(10);
    arrayOfString[1] = String.valueOf(paramLong);
    return SqliteWrapper.a(this.q, this.r, localBuilder.build(), null, "err_type < ? AND due_time <= ?", arrayOfString, "due_time");
  }

  public Uri a(Uri paramUri1, Uri paramUri2)
  {
    long l1 = ContentUris.parseId(paramUri1);
    if (l1 == -1L)
      throw new MmsException("Error! ID of the message: -1.");
    Integer localInteger = (Integer)f.get(paramUri2);
    if (localInteger == null)
      throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("msg_box", localInteger);
    SqliteWrapper.a(this.q, this.r, paramUri1, localContentValues, null, null);
    return ContentUris.withAppendedId(paramUri2, l1);
  }

  public Uri a(GenericPdu paramGenericPdu, Uri paramUri)
  {
    if (paramUri == null)
      throw new MmsException("Uri may not be null.");
    if ((Integer)f.get(paramUri) == null)
      throw new MmsException("Bad destination, must be one of content://mms/inbox, content://mms/sent, content://mms/drafts, content://mms/outbox, content://mms/temp.");
    b.a(paramUri);
    PduHeaders localPduHeaders = paramGenericPdu.e();
    ContentValues localContentValues1 = new ContentValues();
    Iterator localIterator1 = m.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry4 = (Map.Entry)localIterator1.next();
      int i15 = ((Integer)localEntry4.getKey()).intValue();
      EncodedStringValue localEncodedStringValue4 = localPduHeaders.c(i15);
      if (localEncodedStringValue4 == null)
        continue;
      String str3 = (String)l.get(Integer.valueOf(i15));
      localContentValues1.put((String)localEntry4.getValue(), a(localEncodedStringValue4.b()));
      localContentValues1.put(str3, Integer.valueOf(localEncodedStringValue4.a()));
    }
    Iterator localIterator2 = n.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry3 = (Map.Entry)localIterator2.next();
      byte[] arrayOfByte = localPduHeaders.b(((Integer)localEntry3.getKey()).intValue());
      if (arrayOfByte == null)
        continue;
      localContentValues1.put((String)localEntry3.getValue(), a(arrayOfByte));
    }
    Iterator localIterator3 = o.entrySet().iterator();
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator3.next();
      int i14 = localPduHeaders.a(((Integer)localEntry2.getKey()).intValue());
      if (i14 == 0)
        continue;
      localContentValues1.put((String)localEntry2.getValue(), Integer.valueOf(i14));
    }
    Iterator localIterator4 = p.entrySet().iterator();
    while (localIterator4.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator4.next();
      long l4 = localPduHeaders.e(((Integer)localEntry1.getKey()).intValue());
      if (l4 == -1L)
        continue;
      localContentValues1.put((String)localEntry1.getValue(), Long.valueOf(l4));
    }
    HashMap localHashMap = new HashMap(c.length);
    int[] arrayOfInt1 = c;
    int i1 = arrayOfInt1.length;
    int i2 = 0;
    if (i2 < i1)
    {
      int i13 = arrayOfInt1[i2];
      EncodedStringValue localEncodedStringValue3;
      if (i13 == 137)
      {
        localEncodedStringValue3 = localPduHeaders.c(i13);
        arrayOfEncodedStringValue4 = null;
        if (localEncodedStringValue3 == null);
      }
      for (EncodedStringValue[] arrayOfEncodedStringValue4 = { localEncodedStringValue3 }; ; arrayOfEncodedStringValue4 = localPduHeaders.d(i13))
      {
        localHashMap.put(Integer.valueOf(i13), arrayOfEncodedStringValue4);
        i2++;
        break;
      }
    }
    HashSet localHashSet = new HashSet();
    long l1 = 9223372036854775807L;
    int i3 = paramGenericPdu.f();
    if ((i3 == 130) || (i3 == 132) || (i3 == 128))
    {
      String str1 = MessageUtils.a(this.q);
      EncodedStringValue[] arrayOfEncodedStringValue1;
      switch (i3)
      {
      case 129:
      case 131:
      default:
        arrayOfEncodedStringValue1 = null;
      case 132:
      case 130:
      case 128:
      }
      while (arrayOfEncodedStringValue1 != null)
      {
        int i9 = arrayOfEncodedStringValue1.length;
        for (int i10 = 0; i10 < i9; i10++)
        {
          EncodedStringValue localEncodedStringValue1 = arrayOfEncodedStringValue1[i10];
          if (localEncodedStringValue1 == null)
            continue;
          localHashSet.add(localEncodedStringValue1.c());
        }
        if (!StringUtil.a(str1))
        {
          EncodedStringValue[] arrayOfEncodedStringValue3 = (EncodedStringValue[])localHashMap.get(Integer.valueOf(151));
          if (arrayOfEncodedStringValue3 != null)
          {
            int i11 = arrayOfEncodedStringValue3.length;
            for (int i12 = 0; i12 < i11; i12++)
            {
              EncodedStringValue localEncodedStringValue2 = arrayOfEncodedStringValue3[i12];
              if (localEncodedStringValue2 == null)
                continue;
              String str2 = localEncodedStringValue2.c();
              if (MessageUtils.a(this.q, str2))
                continue;
              localHashSet.add(str2);
            }
          }
        }
        arrayOfEncodedStringValue1 = (EncodedStringValue[])localHashMap.get(Integer.valueOf(137));
        continue;
        arrayOfEncodedStringValue1 = (EncodedStringValue[])localHashMap.get(Integer.valueOf(151));
      }
      l1 = Telephony.Threads.a(this.q, localHashSet);
    }
    localContentValues1.put("thread_id", Long.valueOf(l1));
    localContentValues1.put("seen", Integer.valueOf(1));
    localContentValues1.put("read", Integer.valueOf(1));
    long l2 = System.currentTimeMillis();
    if ((paramGenericPdu instanceof MultimediaMessagePdu))
    {
      PduBody localPduBody = ((MultimediaMessagePdu)paramGenericPdu).a();
      if (localPduBody != null)
      {
        int i7 = localPduBody.b();
        for (int i8 = 0; i8 < i7; i8++)
          a(localPduBody.a(i8), l2);
      }
    }
    Uri localUri1 = SqliteWrapper.a(this.q, this.r, paramUri, localContentValues1);
    if (localUri1 == null)
      throw new MmsException("persist() failed: return null.");
    long l3 = ContentUris.parseId(localUri1);
    ContentValues localContentValues2 = new ContentValues(1);
    localContentValues2.put("mid", Long.valueOf(l3));
    SqliteWrapper.a(this.q, this.r, Uri.parse("content://mms/" + l2 + "/part"), localContentValues2, null, null);
    Uri localUri2 = Uri.parse(paramUri + "/" + l3);
    for (int i6 : c)
    {
      EncodedStringValue[] arrayOfEncodedStringValue2 = (EncodedStringValue[])localHashMap.get(Integer.valueOf(i6));
      if (arrayOfEncodedStringValue2 == null)
        continue;
      a(l3, i6, arrayOfEncodedStringValue2);
    }
    return localUri2;
  }

  public Uri a(PduPart paramPduPart, long paramLong)
  {
    Uri localUri1 = Uri.parse("content://mms/" + paramLong + "/part");
    ContentValues localContentValues = new ContentValues(8);
    int i1 = paramPduPart.d();
    if (i1 != 0)
      localContentValues.put("chset", Integer.valueOf(i1));
    String str1;
    if (paramPduPart.g() != null)
    {
      str1 = a(paramPduPart.g());
      if (!"image/jpg".equals(str1))
        break label313;
    }
    label313: for (String str2 = "image/jpeg"; ; str2 = str1)
    {
      localContentValues.put("ct", str2);
      if ("application/smil".equals(str2))
        localContentValues.put("seq", Integer.valueOf(-1));
      if (paramPduPart.j() != null)
        localContentValues.put("fn", new String(paramPduPart.j()));
      if (paramPduPart.i() != null)
        localContentValues.put("name", new String(paramPduPart.i()));
      if (paramPduPart.f() != null)
        localContentValues.put("cd", (String)a(paramPduPart.f()));
      if (paramPduPart.c() != null)
        localContentValues.put("cid", (String)a(paramPduPart.c()));
      if (paramPduPart.e() != null)
        localContentValues.put("cl", (String)a(paramPduPart.e()));
      Uri localUri2 = SqliteWrapper.a(this.q, this.r, localUri1, localContentValues);
      if (localUri2 == null)
      {
        throw new MmsException("Failed to persist part, return null.");
        throw new MmsException("MIME type of the part must be set.");
      }
      a(paramPduPart, localUri2, str2);
      paramPduPart.a(localUri2);
      return localUri2;
    }
  }

  public GenericPdu a(Uri paramUri)
  {
    PduCacheEntry localPduCacheEntry1 = (PduCacheEntry)b.a(paramUri);
    Object localObject2;
    if (localPduCacheEntry1 != null)
    {
      localObject2 = localPduCacheEntry1.a();
      return localObject2;
    }
    Cursor localCursor = SqliteWrapper.a(this.q, this.r, paramUri, d, null, null, null);
    PduHeaders localPduHeaders = new PduHeaders();
    long l1 = ContentUris.parseId(paramUri);
    if (localCursor != null);
    try
    {
      if ((localCursor.getCount() != 1) || (!localCursor.moveToFirst()))
        throw new MmsException("Bad uri: " + paramUri);
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
    int i1 = localCursor.getInt(1);
    long l2 = localCursor.getLong(2);
    Iterator localIterator1 = h.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry4 = (Map.Entry)localIterator1.next();
      a(localCursor, ((Integer)localEntry4.getValue()).intValue(), localPduHeaders, ((Integer)localEntry4.getKey()).intValue());
    }
    Iterator localIterator2 = i.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry3 = (Map.Entry)localIterator2.next();
      b(localCursor, ((Integer)localEntry3.getValue()).intValue(), localPduHeaders, ((Integer)localEntry3.getKey()).intValue());
    }
    Iterator localIterator3 = j.entrySet().iterator();
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator3.next();
      c(localCursor, ((Integer)localEntry2.getValue()).intValue(), localPduHeaders, ((Integer)localEntry2.getKey()).intValue());
    }
    Iterator localIterator4 = k.entrySet().iterator();
    while (localIterator4.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator4.next();
      d(localCursor, ((Integer)localEntry1.getValue()).intValue(), localPduHeaders, ((Integer)localEntry1.getKey()).intValue());
    }
    if (localCursor != null)
      localCursor.close();
    if (l1 == -1L)
      throw new MmsException("Error! ID of the message: -1.");
    a(l1, localPduHeaders);
    int i2 = localPduHeaders.a(140);
    PduBody localPduBody = new PduBody();
    if ((i2 == 132) || (i2 == 128))
    {
      PduPart[] arrayOfPduPart = b(l1);
      if (arrayOfPduPart != null)
      {
        int i3 = arrayOfPduPart.length;
        for (int i4 = 0; i4 < i3; i4++)
          localPduBody.a(arrayOfPduPart[i4]);
      }
    }
    switch (i2)
    {
    default:
      throw new MmsException("Unrecognized PDU type: " + Integer.toHexString(i2));
    case 130:
      localObject2 = new NotificationInd(localPduHeaders);
    case 134:
    case 136:
    case 132:
    case 128:
    case 133:
    case 131:
    case 135:
      while (true)
      {
        PduCacheEntry localPduCacheEntry2 = new PduCacheEntry((GenericPdu)localObject2, i1, l2);
        b.a(paramUri, localPduCacheEntry2);
        break;
        localObject2 = new DeliveryInd(localPduHeaders);
        continue;
        localObject2 = new ReadOrigInd(localPduHeaders);
        continue;
        localObject2 = new RetrieveConf(localPduHeaders, localPduBody);
        continue;
        localObject2 = new SendReq(localPduHeaders, localPduBody);
        continue;
        localObject2 = new AcknowledgeInd(localPduHeaders);
        continue;
        localObject2 = new NotifyRespInd(localPduHeaders);
        continue;
        localObject2 = new ReadRecInd(localPduHeaders);
      }
    case 129:
    case 137:
    case 138:
    case 139:
    case 140:
    case 141:
    case 142:
    case 143:
    case 144:
    case 145:
    case 146:
    case 147:
    case 148:
    case 149:
    case 150:
    case 151:
    }
    throw new MmsException("Unsupported PDU type: " + Integer.toHexString(i2));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.pdu.PduPersister
 * JD-Core Version:    0.6.0
 */