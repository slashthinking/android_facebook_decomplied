package android_src.mms.transaction;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android_src.mms.MmsConfig;
import com.facebook.orca.debug.BLog;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpUtils
{
  private static final String a = a(Locale.getDefault());

  private static AndroidHttpClient a(Context paramContext)
  {
    String str = MmsConfig.c();
    AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance(str, paramContext);
    HttpParams localHttpParams = localAndroidHttpClient.getParams();
    HttpProtocolParams.setContentCharset(localHttpParams, "UTF-8");
    int i = MmsConfig.j();
    if (BLog.b(3))
      BLog.b("fb-mms:HttpUtils", "[HttpUtils] createHttpClient w/ socket timeout " + i + " ms, " + ", UA=" + str);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    return localAndroidHttpClient;
  }

  private static String a(String paramString)
  {
    if (paramString == null)
      paramString = null;
    while (true)
    {
      return paramString;
      if ("iw".equals(paramString))
      {
        paramString = "he";
        continue;
      }
      if ("in".equals(paramString))
      {
        paramString = "id";
        continue;
      }
      if (!"ji".equals(paramString))
        continue;
      paramString = "yi";
    }
  }

  public static String a(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, paramLocale);
    if (!Locale.US.equals(paramLocale))
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append("en-US");
    }
    return localStringBuilder.toString();
  }

  private static void a(Exception paramException, String paramString)
  {
    BLog.e("fb-mms:HttpUtils", "Url: " + paramString + "\n" + paramException.getMessage());
    IOException localIOException = new IOException(paramException.getMessage());
    localIOException.initCause(paramException);
    throw localIOException;
  }

  private static void a(StringBuilder paramStringBuilder, Locale paramLocale)
  {
    String str1 = a(paramLocale.getLanguage());
    if (str1 != null)
    {
      paramStringBuilder.append(str1);
      String str2 = paramLocale.getCountry();
      if (str2 != null)
      {
        paramStringBuilder.append("-");
        paramStringBuilder.append(str2);
      }
    }
  }

  // ERROR //
  protected static byte[] a(Context paramContext, long paramLong, String paramString1, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull +13 -> 14
    //   4: new 160	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 164
    //   10: invokespecial 165	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: iconst_2
    //   15: invokestatic 57	com/facebook/orca/debug/BLog:b	(I)Z
    //   18: ifeq +172 -> 190
    //   21: ldc 59
    //   23: ldc 167
    //   25: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc 59
    //   30: new 61	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   37: ldc 171
    //   39: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: lload_1
    //   43: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 59
    //   54: new 61	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   61: ldc 176
    //   63: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: new 61	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   83: ldc 178
    //   85: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 54
    //   90: iload 5
    //   92: iconst_1
    //   93: if_icmpne +227 -> 320
    //   96: ldc 180
    //   98: astore 55
    //   100: ldc 59
    //   102: aload 54
    //   104: aload 55
    //   106: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 59
    //   117: new 61	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   124: ldc 182
    //   126: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload 6
    //   131: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 59
    //   142: new 61	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   149: ldc 187
    //   151: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 7
    //   156: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc 59
    //   167: new 61	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   174: ldc 189
    //   176: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 8
    //   181: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aconst_null
    //   191: astore 9
    //   193: new 191	java/net/URI
    //   196: dup
    //   197: aload_3
    //   198: invokespecial 192	java/net/URI:<init>	(Ljava/lang/String;)V
    //   201: astore 10
    //   203: new 194	org/apache/http/HttpHost
    //   206: dup
    //   207: aload 10
    //   209: invokevirtual 197	java/net/URI:getHost	()Ljava/lang/String;
    //   212: aload 10
    //   214: invokevirtual 200	java/net/URI:getPort	()I
    //   217: ldc 202
    //   219: invokespecial 205	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: astore 11
    //   224: aload_0
    //   225: invokestatic 207	android_src/mms/transaction/HttpUtils:a	(Landroid/content/Context;)Landroid/net/http/AndroidHttpClient;
    //   228: astore 9
    //   230: iload 5
    //   232: tableswitch	default:+24 -> 256, 1:+108->340, 2:+398->630
    //   257: istore_0
    //   258: new 61	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   265: ldc 209
    //   267: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: iload 5
    //   272: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc 211
    //   277: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iconst_1
    //   281: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc 213
    //   286: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iconst_2
    //   290: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc 215
    //   295: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aconst_null
    //   305: astore 14
    //   307: aload 9
    //   309: ifnull +8 -> 317
    //   312: aload 9
    //   314: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   317: aload 14
    //   319: areturn
    //   320: iload 5
    //   322: iconst_2
    //   323: if_icmpne +10 -> 333
    //   326: ldc 220
    //   328: astore 55
    //   330: goto -230 -> 100
    //   333: ldc 222
    //   335: astore 55
    //   337: goto -237 -> 100
    //   340: new 224	android_src/mms/transaction/ProgressCallbackEntity
    //   343: dup
    //   344: aload_0
    //   345: lload_1
    //   346: aload 4
    //   348: invokespecial 227	android_src/mms/transaction/ProgressCallbackEntity:<init>	(Landroid/content/Context;J[B)V
    //   351: astore 52
    //   353: aload 52
    //   355: ldc 229
    //   357: invokevirtual 232	android_src/mms/transaction/ProgressCallbackEntity:setContentType	(Ljava/lang/String;)V
    //   360: new 234	org/apache/http/client/methods/HttpPost
    //   363: dup
    //   364: aload_3
    //   365: invokespecial 235	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   368: astore 53
    //   370: aload 53
    //   372: aload 52
    //   374: invokevirtual 239	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   377: aload 53
    //   379: astore 19
    //   381: aload 9
    //   383: invokevirtual 39	android/net/http/AndroidHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   386: astore 20
    //   388: iload 6
    //   390: ifeq +19 -> 409
    //   393: aload 20
    //   395: new 194	org/apache/http/HttpHost
    //   398: dup
    //   399: aload 7
    //   401: iload 8
    //   403: invokespecial 242	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   406: invokestatic 248	org/apache/http/conn/params/ConnRouteParams:setDefaultProxy	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/HttpHost;)V
    //   409: aload 19
    //   411: aload 20
    //   413: invokeinterface 254 2 0
    //   418: aload 19
    //   420: ldc_w 256
    //   423: ldc_w 258
    //   426: invokeinterface 261 3 0
    //   431: invokestatic 264	android_src/mms/MmsConfig:d	()Ljava/lang/String;
    //   434: astore 21
    //   436: invokestatic 266	android_src/mms/MmsConfig:e	()Ljava/lang/String;
    //   439: astore 22
    //   441: aload 22
    //   443: ifnull +47 -> 490
    //   446: iconst_2
    //   447: invokestatic 57	com/facebook/orca/debug/BLog:b	(I)Z
    //   450: ifeq +29 -> 479
    //   453: ldc 59
    //   455: new 61	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 268
    //   465: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 22
    //   470: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 81	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload 19
    //   481: aload 21
    //   483: aload 22
    //   485: invokeinterface 261 3 0
    //   490: invokestatic 271	android_src/mms/MmsConfig:f	()Ljava/lang/String;
    //   493: astore 23
    //   495: aload 23
    //   497: ifnull +146 -> 643
    //   500: aload_0
    //   501: ldc_w 273
    //   504: invokevirtual 279	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   507: checkcast 281	android/telephony/TelephonyManager
    //   510: invokevirtual 284	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   513: astore 44
    //   515: invokestatic 287	android_src/mms/MmsConfig:g	()Ljava/lang/String;
    //   518: astore 45
    //   520: aload 23
    //   522: ldc_w 289
    //   525: invokevirtual 293	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   528: astore 46
    //   530: aload 46
    //   532: arraylength
    //   533: istore 47
    //   535: iconst_0
    //   536: istore 48
    //   538: iload 48
    //   540: iload 47
    //   542: if_icmpge +101 -> 643
    //   545: aload 46
    //   547: iload 48
    //   549: aaload
    //   550: ldc_w 295
    //   553: iconst_2
    //   554: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   557: astore 49
    //   559: aload 49
    //   561: arraylength
    //   562: iconst_2
    //   563: if_icmpne +781 -> 1344
    //   566: aload 49
    //   568: iconst_0
    //   569: aaload
    //   570: invokevirtual 301	java/lang/String:trim	()Ljava/lang/String;
    //   573: astore 50
    //   575: aload 49
    //   577: iconst_1
    //   578: aaload
    //   579: invokevirtual 301	java/lang/String:trim	()Ljava/lang/String;
    //   582: astore 51
    //   584: aload 45
    //   586: ifnull +14 -> 600
    //   589: aload 51
    //   591: aload 45
    //   593: aload 44
    //   595: invokevirtual 305	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   598: astore 51
    //   600: aload 50
    //   602: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifne +739 -> 1344
    //   608: aload 51
    //   610: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   613: ifne +731 -> 1344
    //   616: aload 19
    //   618: aload 50
    //   620: aload 51
    //   622: invokeinterface 261 3 0
    //   627: goto +717 -> 1344
    //   630: new 313	org/apache/http/client/methods/HttpGet
    //   633: dup
    //   634: aload_3
    //   635: invokespecial 314	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   638: astore 19
    //   640: goto -259 -> 381
    //   643: aload 19
    //   645: ldc_w 316
    //   648: getstatic 19	android_src/mms/transaction/HttpUtils:a	Ljava/lang/String;
    //   651: invokeinterface 261 3 0
    //   656: aload 9
    //   658: aload 11
    //   660: aload 19
    //   662: invokevirtual 320	android/net/http/AndroidHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   665: astore 24
    //   667: aload 24
    //   669: invokeinterface 326 1 0
    //   674: astore 25
    //   676: aload 25
    //   678: invokeinterface 331 1 0
    //   683: sipush 200
    //   686: if_icmpeq +61 -> 747
    //   689: new 136	java/io/IOException
    //   692: dup
    //   693: new 61	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 333
    //   703: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 25
    //   708: invokeinterface 336 1 0
    //   713: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokespecial 139	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   722: athrow
    //   723: astore 18
    //   725: aload 18
    //   727: aload_3
    //   728: invokestatic 338	android_src/mms/transaction/HttpUtils:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   731: aload 9
    //   733: ifnull +8 -> 741
    //   736: aload 9
    //   738: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   741: aconst_null
    //   742: astore 14
    //   744: goto -427 -> 317
    //   747: aload 24
    //   749: invokeinterface 342 1 0
    //   754: astore 26
    //   756: aconst_null
    //   757: astore 14
    //   759: aload 26
    //   761: ifnull +250 -> 1011
    //   764: aload 26
    //   766: invokeinterface 348 1 0
    //   771: lconst_0
    //   772: lcmp
    //   773: istore 28
    //   775: aconst_null
    //   776: astore 14
    //   778: iload 28
    //   780: ifle +43 -> 823
    //   783: aload 26
    //   785: invokeinterface 348 1 0
    //   790: l2i
    //   791: newarray byte
    //   793: astore 14
    //   795: new 350	java/io/DataInputStream
    //   798: dup
    //   799: aload 26
    //   801: invokeinterface 354 1 0
    //   806: invokespecial 357	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   809: astore 40
    //   811: aload 40
    //   813: aload 14
    //   815: invokevirtual 361	java/io/DataInputStream:readFully	([B)V
    //   818: aload 40
    //   820: invokevirtual 362	java/io/DataInputStream:close	()V
    //   823: aload 26
    //   825: invokeinterface 366 1 0
    //   830: ifeq +169 -> 999
    //   833: ldc 59
    //   835: ldc_w 368
    //   838: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: invokestatic 370	android_src/mms/MmsConfig:a	()I
    //   844: istore 29
    //   846: iload 29
    //   848: newarray byte
    //   850: astore 30
    //   852: new 350	java/io/DataInputStream
    //   855: dup
    //   856: aload 26
    //   858: invokeinterface 354 1 0
    //   863: invokespecial 357	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   866: astore 31
    //   868: iconst_0
    //   869: istore 32
    //   871: iconst_0
    //   872: istore 33
    //   874: aload 31
    //   876: aload 30
    //   878: iload 33
    //   880: iload 29
    //   882: invokevirtual 374	java/io/DataInputStream:read	([BII)I
    //   885: istore 39
    //   887: iload 39
    //   889: istore 32
    //   891: iload 32
    //   893: ifle +17 -> 910
    //   896: iload 29
    //   898: iload 32
    //   900: isub
    //   901: istore 29
    //   903: iload 33
    //   905: iload 32
    //   907: iadd
    //   908: istore 33
    //   910: iconst_0
    //   911: istore 37
    //   913: iload 32
    //   915: iflt +11 -> 926
    //   918: iconst_0
    //   919: istore 37
    //   921: iload 29
    //   923: ifgt -49 -> 874
    //   926: iload 32
    //   928: iconst_m1
    //   929: if_icmpne +258 -> 1187
    //   932: iload 33
    //   934: ifle +253 -> 1187
    //   937: iload 37
    //   939: ifne +248 -> 1187
    //   942: iload 33
    //   944: newarray byte
    //   946: astore 14
    //   948: aload 30
    //   950: iconst_0
    //   951: aload 14
    //   953: iconst_0
    //   954: iload 33
    //   956: invokestatic 380	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   959: ldc 59
    //   961: new 61	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   968: ldc_w 382
    //   971: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: iload 33
    //   976: invokestatic 387	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   979: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: ldc_w 389
    //   985: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 169	com/facebook/orca/debug/BLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload 31
    //   996: invokevirtual 362	java/io/DataInputStream:close	()V
    //   999: aload 26
    //   1001: ifnull +10 -> 1011
    //   1004: aload 26
    //   1006: invokeinterface 392 1 0
    //   1011: aload 9
    //   1013: ifnull -696 -> 317
    //   1016: aload 9
    //   1018: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1021: goto -704 -> 317
    //   1024: astore 43
    //   1026: ldc 59
    //   1028: new 61	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 394
    //   1038: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: aload 43
    //   1043: invokevirtual 395	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1046: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1055: goto -232 -> 823
    //   1058: astore 27
    //   1060: aload 26
    //   1062: ifnull +10 -> 1072
    //   1065: aload 26
    //   1067: invokeinterface 392 1 0
    //   1072: aload 27
    //   1074: athrow
    //   1075: astore 17
    //   1077: aload 17
    //   1079: aload_3
    //   1080: invokestatic 338	android_src/mms/transaction/HttpUtils:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1083: aload 9
    //   1085: ifnull -344 -> 741
    //   1088: aload 9
    //   1090: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1093: goto -352 -> 741
    //   1096: astore 41
    //   1098: aload 40
    //   1100: invokevirtual 362	java/io/DataInputStream:close	()V
    //   1103: aload 41
    //   1105: athrow
    //   1106: astore 42
    //   1108: ldc 59
    //   1110: new 61	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1117: ldc_w 394
    //   1120: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: aload 42
    //   1125: invokevirtual 395	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1128: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1137: goto -34 -> 1103
    //   1140: astore 36
    //   1142: iconst_1
    //   1143: istore 37
    //   1145: ldc 59
    //   1147: new 61	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1154: ldc_w 397
    //   1157: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: aload 36
    //   1162: invokevirtual 395	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1165: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: goto -248 -> 926
    //   1177: astore 34
    //   1179: aload 31
    //   1181: invokevirtual 362	java/io/DataInputStream:close	()V
    //   1184: aload 34
    //   1186: athrow
    //   1187: ldc 59
    //   1189: ldc_w 399
    //   1192: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1195: goto -201 -> 994
    //   1198: astore 38
    //   1200: ldc 59
    //   1202: new 61	java/lang/StringBuilder
    //   1205: dup
    //   1206: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1209: ldc_w 394
    //   1212: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: aload 38
    //   1217: invokevirtual 395	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1220: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1226: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1229: goto -230 -> 999
    //   1232: astore 35
    //   1234: ldc 59
    //   1236: new 61	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   1243: ldc_w 394
    //   1246: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: aload 35
    //   1251: invokevirtual 395	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1254: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: invokestatic 134	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1263: goto -79 -> 1184
    //   1266: astore 16
    //   1268: aload 16
    //   1270: aload_3
    //   1271: invokestatic 338	android_src/mms/transaction/HttpUtils:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1274: aload 9
    //   1276: ifnull -535 -> 741
    //   1279: aload 9
    //   1281: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1284: goto -543 -> 741
    //   1287: astore 15
    //   1289: aload 15
    //   1291: aload_3
    //   1292: invokestatic 338	android_src/mms/transaction/HttpUtils:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1295: aload 9
    //   1297: ifnull -556 -> 741
    //   1300: aload 9
    //   1302: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1305: goto -564 -> 741
    //   1308: astore 13
    //   1310: aload 13
    //   1312: aload_3
    //   1313: invokestatic 338	android_src/mms/transaction/HttpUtils:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1316: aload 9
    //   1318: ifnull -577 -> 741
    //   1321: aload 9
    //   1323: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1326: goto -585 -> 741
    //   1329: astore 12
    //   1331: aload 9
    //   1333: ifnull +8 -> 1341
    //   1336: aload 9
    //   1338: invokevirtual 218	android/net/http/AndroidHttpClient:close	()V
    //   1341: aload 12
    //   1343: athrow
    //   1344: iinc 48 1
    //   1347: goto -809 -> 538
    //
    // Exception table:
    //   from	to	target	type
    //   193	304	723	java/net/URISyntaxException
    //   340	723	723	java/net/URISyntaxException
    //   747	756	723	java/net/URISyntaxException
    //   1004	1011	723	java/net/URISyntaxException
    //   1065	1075	723	java/net/URISyntaxException
    //   818	823	1024	java/io/IOException
    //   764	811	1058	finally
    //   818	823	1058	finally
    //   823	868	1058	finally
    //   994	999	1058	finally
    //   1026	1055	1058	finally
    //   1098	1103	1058	finally
    //   1103	1137	1058	finally
    //   1179	1184	1058	finally
    //   1184	1187	1058	finally
    //   1200	1263	1058	finally
    //   193	304	1075	java/lang/IllegalStateException
    //   340	723	1075	java/lang/IllegalStateException
    //   747	756	1075	java/lang/IllegalStateException
    //   1004	1011	1075	java/lang/IllegalStateException
    //   1065	1075	1075	java/lang/IllegalStateException
    //   811	818	1096	finally
    //   1098	1103	1106	java/io/IOException
    //   874	887	1140	java/io/IOException
    //   874	887	1177	finally
    //   942	994	1177	finally
    //   1145	1174	1177	finally
    //   1187	1195	1177	finally
    //   994	999	1198	java/io/IOException
    //   1179	1184	1232	java/io/IOException
    //   193	304	1266	java/lang/IllegalArgumentException
    //   340	723	1266	java/lang/IllegalArgumentException
    //   747	756	1266	java/lang/IllegalArgumentException
    //   1004	1011	1266	java/lang/IllegalArgumentException
    //   1065	1075	1266	java/lang/IllegalArgumentException
    //   193	304	1287	java/net/SocketException
    //   340	723	1287	java/net/SocketException
    //   747	756	1287	java/net/SocketException
    //   1004	1011	1287	java/net/SocketException
    //   1065	1075	1287	java/net/SocketException
    //   193	304	1308	java/lang/Exception
    //   340	723	1308	java/lang/Exception
    //   747	756	1308	java/lang/Exception
    //   1004	1011	1308	java/lang/Exception
    //   1065	1075	1308	java/lang/Exception
    //   193	304	1329	finally
    //   340	723	1329	finally
    //   725	731	1329	finally
    //   747	756	1329	finally
    //   1004	1011	1329	finally
    //   1065	1075	1329	finally
    //   1077	1083	1329	finally
    //   1268	1274	1329	finally
    //   1289	1295	1329	finally
    //   1310	1316	1329	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.HttpUtils
 * JD-Core Version:    0.6.0
 */