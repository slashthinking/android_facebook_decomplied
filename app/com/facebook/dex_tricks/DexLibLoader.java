package com.facebook.dex_tricks;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class DexLibLoader
{
  private static Pattern a = Pattern.compile("^program-([0-9a-f]+)\\.dex\\.(jar|dex)");
  private static final DexLibLoader.ThirdPartyDexSpec b = new DexLibLoader.ThirdPartyDexSpec("guava-10.0.1-fork.dex", 1, "com.google.common.base.Charsets", "guava", null);
  private static final DexLibLoader.ThirdPartyDexSpec c = new DexLibLoader.ThirdPartyDexSpec("jackson-core-2.0.5.dex", 1, "com.fasterxml.jackson.core.JsonParser", "jackson-core", null);
  private static final DexLibLoader.ThirdPartyDexSpec d = new DexLibLoader.ThirdPartyDexSpec("jackson-databind-2.0.5.dex", 1, "com.fasterxml.jackson.databind.JsonNode", "jackson-databind", null);
  private static final DexLibLoader.ThirdPartyDexSpec e = new DexLibLoader.ThirdPartyDexSpec("jackson-datatype-guava-2.0.4.dex", 1, "com.fasterxml.jackson.datatype.guava.GuavaModule", "jackson-datatype-guava", null);
  private static final DexLibLoader.ThirdPartyDexSpec f = new DexLibLoader.ThirdPartyDexSpec("json_simple-1.1.dex", 1, "org.json.simple.JSONValue", "json-simple", null);
  private static final DexLibLoader.ThirdPartyDexSpec g = new DexLibLoader.ThirdPartyDexSpec("json-path-0.5.4-FB-Custom.dex", 1, "com.jayway.jsonpath.JsonPath", "json-path", null);
  private static final DexLibLoader.ThirdPartyDexSpec h = new DexLibLoader.ThirdPartyDexSpec("diffutils-1.2.1.dex", 1, "difflib.Patch", "diffutils", null);
  private static final DexLibLoader.ThirdPartyDexSpec i = new DexLibLoader.ThirdPartyDexSpec("libphonenumber-4.1.dex", 1, "com.google.i18n.phonenumbers.Phonenumber", "libphonenumber", null);
  private static final DexLibLoader.ThirdPartyDexSpec j = new DexLibLoader.ThirdPartyDexSpec("nine_old_androids.dex", 3, "com.nineoldandroids.animation.Animator", "nine_old_androids", null);
  private static final List<DexLibLoader.ThirdPartyDexSpec> k;
  private static boolean n;
  private final Context l;
  private final SystemClassLoaderAdder m;

  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b);
    localArrayList.add(f);
    localArrayList.add(g);
    localArrayList.add(h);
    localArrayList.add(i);
    localArrayList.add(j);
    k = Collections.unmodifiableList(localArrayList);
  }

  private DexLibLoader(Context paramContext)
  {
    this.l = paramContext;
    this.m = new SystemClassLoaderAdder();
  }

  private File a(String paramString, int paramInt)
  {
    String str = c(paramString, paramInt);
    return new File(this.l.getDir("dex", 0), str);
  }

  private static List<String> a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
        break;
      localArrayList.add(str);
    }
    return localArrayList;
  }

  // ERROR //
  private void a()
  {
    // Byte code:
    //   0: ldc 183
    //   2: ldc 185
    //   4: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: aload_0
    //   9: getfield 137	com/facebook/dex_tricks/DexLibLoader:l	Landroid/content/Context;
    //   12: invokevirtual 195	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 197
    //   19: invokevirtual 203	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore 7
    //   24: aload 7
    //   26: invokestatic 205	com/facebook/dex_tricks/DexLibLoader:a	(Ljava/io/InputStream;)Ljava/util/List;
    //   29: astore 15
    //   31: aload 7
    //   33: invokevirtual 210	java/io/InputStream:close	()V
    //   36: ldc 183
    //   38: new 212	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   45: ldc 215
    //   47: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload 15
    //   52: invokeinterface 223 1 0
    //   57: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc 228
    //   62: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: new 117	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 119	java/util/ArrayList:<init>	()V
    //   79: astore 19
    //   81: new 233	java/util/HashSet
    //   84: dup
    //   85: invokespecial 234	java/util/HashSet:<init>	()V
    //   88: astore 20
    //   90: aload 15
    //   92: invokeinterface 238 1 0
    //   97: astore 21
    //   99: aload 21
    //   101: invokeinterface 244 1 0
    //   106: ifeq +205 -> 311
    //   109: aload 21
    //   111: invokeinterface 248 1 0
    //   116: checkcast 250	java/lang/String
    //   119: astore 47
    //   121: aload 47
    //   123: invokevirtual 253	java/lang/String:length	()I
    //   126: ifeq -27 -> 99
    //   129: ldc 183
    //   131: new 212	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   138: ldc 255
    //   140: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 47
    //   145: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload 47
    //   157: ldc_w 257
    //   160: invokevirtual 261	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   163: astore 49
    //   165: aload 49
    //   167: iconst_0
    //   168: aaload
    //   169: astore 50
    //   171: aload 49
    //   173: iconst_1
    //   174: aaload
    //   175: astore 51
    //   177: aload 19
    //   179: new 263	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec
    //   182: dup
    //   183: aload 50
    //   185: aload 51
    //   187: aload 49
    //   189: iconst_2
    //   190: aaload
    //   191: aconst_null
    //   192: invokespecial 266	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/dex_tricks/DexLibLoader$1;)V
    //   195: invokeinterface 269 2 0
    //   200: pop
    //   201: aload 20
    //   203: aload 51
    //   205: invokeinterface 272 2 0
    //   210: pop
    //   211: goto -112 -> 99
    //   214: astore 5
    //   216: ldc 183
    //   218: ldc_w 274
    //   221: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   224: pop
    //   225: return
    //   226: astore_3
    //   227: ldc 183
    //   229: ldc_w 276
    //   232: aload_3
    //   233: invokestatic 279	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   236: pop
    //   237: goto -12 -> 225
    //   240: astore 16
    //   242: ldc 183
    //   244: ldc_w 281
    //   247: invokestatic 283	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   250: pop
    //   251: goto -215 -> 36
    //   254: astore 11
    //   256: ldc 183
    //   258: ldc_w 285
    //   261: invokestatic 283	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: aload 7
    //   267: invokevirtual 210	java/io/InputStream:close	()V
    //   270: goto -45 -> 225
    //   273: astore 13
    //   275: ldc 183
    //   277: ldc_w 281
    //   280: invokestatic 283	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: goto -59 -> 225
    //   287: astore 8
    //   289: aload 7
    //   291: invokevirtual 210	java/io/InputStream:close	()V
    //   294: aload 8
    //   296: athrow
    //   297: astore 9
    //   299: ldc 183
    //   301: ldc_w 281
    //   304: invokestatic 283	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: goto -14 -> 294
    //   311: aload_0
    //   312: getfield 137	com/facebook/dex_tricks/DexLibLoader:l	Landroid/content/Context;
    //   315: ldc_w 287
    //   318: iconst_0
    //   319: invokevirtual 155	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   322: astore 22
    //   324: aload_0
    //   325: getfield 137	com/facebook/dex_tricks/DexLibLoader:l	Landroid/content/Context;
    //   328: ldc_w 289
    //   331: iconst_0
    //   332: invokevirtual 155	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   335: astore 23
    //   337: new 148	java/io/File
    //   340: dup
    //   341: aload 22
    //   343: ldc_w 291
    //   346: invokespecial 158	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   349: invokestatic 296	com/facebook/dex_tricks/DexLibLoader$FileLocker:a	(Ljava/io/File;)Lcom/facebook/dex_tricks/DexLibLoader$FileLocker;
    //   352: astore 26
    //   354: iconst_2
    //   355: anewarray 148	java/io/File
    //   358: dup
    //   359: iconst_0
    //   360: aload 22
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: aload 23
    //   367: aastore
    //   368: astore 27
    //   370: aload 27
    //   372: arraylength
    //   373: istore 29
    //   375: iconst_0
    //   376: istore 30
    //   378: iload 30
    //   380: iload 29
    //   382: if_icmpge +224 -> 606
    //   385: aload 27
    //   387: iload 30
    //   389: aaload
    //   390: invokevirtual 300	java/io/File:listFiles	()[Ljava/io/File;
    //   393: astore 39
    //   395: aload 39
    //   397: arraylength
    //   398: istore 40
    //   400: iconst_0
    //   401: istore 41
    //   403: iload 41
    //   405: iload 40
    //   407: if_icmpge +439 -> 846
    //   410: aload 39
    //   412: iload 41
    //   414: aaload
    //   415: astore 42
    //   417: getstatic 37	com/facebook/dex_tricks/DexLibLoader:a	Ljava/util/regex/Pattern;
    //   420: aload 42
    //   422: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   425: invokevirtual 307	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   428: astore 43
    //   430: aload 42
    //   432: invokevirtual 303	java/io/File:getName	()Ljava/lang/String;
    //   435: ldc_w 291
    //   438: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +6 -> 447
    //   444: goto +396 -> 840
    //   447: aload 43
    //   449: invokevirtual 315	java/util/regex/Matcher:matches	()Z
    //   452: ifne +67 -> 519
    //   455: ldc 183
    //   457: new 212	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   464: ldc_w 317
    //   467: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload 42
    //   472: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   475: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 323	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   484: pop
    //   485: goto +355 -> 840
    //   488: astore 28
    //   490: aload 26
    //   492: invokevirtual 325	com/facebook/dex_tricks/DexLibLoader$FileLocker:a	()V
    //   495: aload 28
    //   497: athrow
    //   498: astore 25
    //   500: invokestatic 331	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   503: invokevirtual 334	java/lang/Thread:interrupt	()V
    //   506: new 336	java/lang/RuntimeException
    //   509: dup
    //   510: ldc_w 338
    //   513: aload 25
    //   515: invokespecial 341	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: athrow
    //   519: aload 20
    //   521: aload 43
    //   523: iconst_1
    //   524: invokevirtual 345	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   527: invokeinterface 348 2 0
    //   532: ifne +308 -> 840
    //   535: ldc 183
    //   537: new 212	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 350
    //   547: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 42
    //   552: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   555: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   564: pop
    //   565: aload 42
    //   567: invokevirtual 353	java/io/File:delete	()Z
    //   570: ifne +270 -> 840
    //   573: ldc 183
    //   575: new 212	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 355
    //   585: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 42
    //   590: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   593: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 323	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   602: pop
    //   603: goto +237 -> 840
    //   606: aload 19
    //   608: invokeinterface 356 1 0
    //   613: astore 31
    //   615: aload 31
    //   617: invokeinterface 244 1 0
    //   622: ifeq +151 -> 773
    //   625: aload 31
    //   627: invokeinterface 248 1 0
    //   632: checkcast 263	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec
    //   635: astore 34
    //   637: new 148	java/io/File
    //   640: dup
    //   641: aload 22
    //   643: new 212	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 358
    //   653: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 34
    //   658: getfield 361	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec:b	Ljava/lang/String;
    //   661: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 363
    //   667: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokespecial 158	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   676: astore 35
    //   678: aload 34
    //   680: getfield 365	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec:a	Ljava/lang/String;
    //   683: astore 36
    //   685: ldc 183
    //   687: new 212	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 367
    //   697: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 36
    //   702: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 369
    //   708: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 35
    //   713: invokevirtual 320	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   716: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   725: pop
    //   726: aload_0
    //   727: new 212	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   734: ldc_w 371
    //   737: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 36
    //   742: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   748: aload 35
    //   750: invokespecial 374	com/facebook/dex_tricks/DexLibLoader:b	(Ljava/lang/String;Ljava/io/File;)V
    //   753: ldc 183
    //   755: ldc_w 376
    //   758: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   761: pop
    //   762: aload_0
    //   763: aload 35
    //   765: aload 23
    //   767: invokespecial 379	com/facebook/dex_tricks/DexLibLoader:a	(Ljava/io/File;Ljava/io/File;)V
    //   770: goto -155 -> 615
    //   773: aload 26
    //   775: invokevirtual 325	com/facebook/dex_tricks/DexLibLoader$FileLocker:a	()V
    //   778: ldc 183
    //   780: ldc_w 381
    //   783: invokestatic 191	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   786: pop
    //   787: aload 19
    //   789: invokeinterface 356 1 0
    //   794: astore 33
    //   796: aload 33
    //   798: invokeinterface 244 1 0
    //   803: ifeq -578 -> 225
    //   806: aload 33
    //   808: invokeinterface 248 1 0
    //   813: checkcast 263	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec
    //   816: getfield 383	com/facebook/dex_tricks/DexLibLoader$ProgramDexSpec:c	Ljava/lang/String;
    //   819: invokestatic 386	com/facebook/dex_tricks/DexLibLoader:a	(Ljava/lang/String;)V
    //   822: goto -26 -> 796
    //   825: astore 24
    //   827: new 336	java/lang/RuntimeException
    //   830: dup
    //   831: ldc_w 338
    //   834: aload 24
    //   836: invokespecial 341	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   839: athrow
    //   840: iinc 41 1
    //   843: goto -440 -> 403
    //   846: iinc 30 1
    //   849: goto -471 -> 378
    //
    // Exception table:
    //   from	to	target	type
    //   16	24	214	java/io/FileNotFoundException
    //   16	24	226	java/io/IOException
    //   31	36	240	java/io/IOException
    //   24	31	254	java/io/IOException
    //   265	270	273	java/io/IOException
    //   24	31	287	finally
    //   256	265	287	finally
    //   289	294	297	java/io/IOException
    //   354	485	488	finally
    //   519	770	488	finally
    //   337	354	498	java/lang/InterruptedException
    //   490	498	498	java/lang/InterruptedException
    //   773	778	498	java/lang/InterruptedException
    //   337	354	825	java/io/IOException
    //   490	498	825	java/io/IOException
    //   773	778	825	java/io/IOException
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      try
      {
        boolean bool = n;
        if (bool)
          return;
        if (paramBoolean)
        {
          Iterator localIterator2 = k.iterator();
          if (localIterator2.hasNext())
          {
            a((DexLibLoader.ThirdPartyDexSpec)localIterator2.next());
            continue;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      DexLibLoader localDexLibLoader = new DexLibLoader(paramContext);
      if (paramBoolean)
      {
        Iterator localIterator1 = k.iterator();
        while (localIterator1.hasNext())
          localDexLibLoader.b((DexLibLoader.ThirdPartyDexSpec)localIterator1.next());
      }
      localDexLibLoader.a();
      localDexLibLoader.b(c);
      localDexLibLoader.b(d);
      localDexLibLoader.b(e);
      n = true;
    }
  }

  private static void a(DexLibLoader.ThirdPartyDexSpec paramThirdPartyDexSpec)
  {
    try
    {
      Class.forName(paramThirdPartyDexSpec.c);
      throw new RuntimeException("Somebody added " + DexLibLoader.ThirdPartyDexSpec.a(paramThirdPartyDexSpec) + " to the main dex! Please fix.");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
  }

  private void a(DexLibLoader.ThirdPartyDexSpec paramThirdPartyDexSpec, boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      String str = paramThirdPartyDexSpec.a;
      int i1 = paramThirdPartyDexSpec.b;
      DexLibLoader.FileLocker localFileLocker = DexLibLoader.FileLocker.a(b(str));
      try
      {
        File localFile = a(str, i1);
        if ((!paramBoolean) && (localFile.exists()))
          Log.v("DexLibLoader", "Dex already copied");
        while (true)
        {
          Log.v("DexLibLoader", "Creating class loader");
          a(localFile, this.l.getDir("outdex", 0));
          long l2 = System.currentTimeMillis() - l1;
          Log.d("DexLibLoader", "DexLibLoader.ensureDex took " + l2 + " ms");
          return;
          Log.v("DexLibLoader", "About to copy " + str);
          d(str, i1);
          a(b(str, i1), localFile);
          Log.v("DexLibLoader", "Finished copying " + str);
        }
      }
      finally
      {
        localFileLocker.a();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new RuntimeException("Failed to ensure Dex", localInterruptedException);
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Failed to ensure Dex", localIOException);
  }

  private void a(File paramFile1, File paramFile2)
  {
    DexClassLoader localDexClassLoader = new DexClassLoader(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), null, this.l.getClassLoader());
    Log.v("DexLibLoader", "Finished creating class loader");
    this.m.a(localDexClassLoader, (PathClassLoader)this.l.getClassLoader());
  }

  private static void a(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    throw new RuntimeException("Dex did not load successfully", localClassNotFoundException);
  }

  // ERROR //
  private void a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: new 478	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 137	com/facebook/dex_tricks/DexLibLoader:l	Landroid/content/Context;
    //   8: invokevirtual 195	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 203	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: invokespecial 481	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_3
    //   19: new 483	java/io/BufferedOutputStream
    //   22: dup
    //   23: new 485	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 488	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 491	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 4
    //   36: sipush 8192
    //   39: newarray byte
    //   41: astore 9
    //   43: aload_3
    //   44: aload 9
    //   46: iconst_0
    //   47: sipush 8192
    //   50: invokevirtual 495	java/io/BufferedInputStream:read	([BII)I
    //   53: istore 10
    //   55: iload 10
    //   57: ifle +61 -> 118
    //   60: aload 4
    //   62: aload 9
    //   64: iconst_0
    //   65: iload 10
    //   67: invokevirtual 501	java/io/OutputStream:write	([BII)V
    //   70: goto -27 -> 43
    //   73: astore 5
    //   75: aload_3
    //   76: astore 6
    //   78: aload 4
    //   80: ifnull +8 -> 88
    //   83: aload 4
    //   85: invokevirtual 502	java/io/OutputStream:close	()V
    //   88: aload 6
    //   90: ifnull +8 -> 98
    //   93: aload 6
    //   95: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   98: aload 5
    //   100: athrow
    //   101: astore 7
    //   103: aload_2
    //   104: invokevirtual 353	java/io/File:delete	()Z
    //   107: pop
    //   108: new 336	java/lang/RuntimeException
    //   111: dup
    //   112: aload 7
    //   114: invokespecial 506	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   117: athrow
    //   118: aload 4
    //   120: ifnull +8 -> 128
    //   123: aload 4
    //   125: invokevirtual 502	java/io/OutputStream:close	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 503	java/io/BufferedInputStream:close	()V
    //   136: return
    //   137: astore 5
    //   139: aconst_null
    //   140: astore 4
    //   142: aconst_null
    //   143: astore 6
    //   145: goto -67 -> 78
    //   148: astore 5
    //   150: aload_3
    //   151: astore 6
    //   153: aconst_null
    //   154: astore 4
    //   156: goto -78 -> 78
    //
    // Exception table:
    //   from	to	target	type
    //   36	70	73	finally
    //   83	101	101	java/io/IOException
    //   123	136	101	java/io/IOException
    //   0	19	137	finally
    //   19	36	148	finally
  }

  private boolean a(File paramFile, String paramString)
  {
    AssetFileDescriptor localAssetFileDescriptor = null;
    try
    {
      localAssetFileDescriptor = this.l.getAssets().openFd(paramString);
      int i1;
      if (paramFile.length() != localAssetFileDescriptor.getLength())
      {
        Log.w("DexLibLoader", "File doesn't match asset size");
        i1 = 0;
        if (localAssetFileDescriptor == null);
      }
      while (true)
      {
        try
        {
          localAssetFileDescriptor.close();
          return i1;
        }
        catch (IOException localIOException4)
        {
          Log.e("DexLibLoader", "Failed to close asset: " + paramString);
          i1 = 0;
          continue;
        }
        i1 = 1;
        if (localAssetFileDescriptor == null)
          continue;
        try
        {
          localAssetFileDescriptor.close();
        }
        catch (IOException localIOException3)
        {
          Log.e("DexLibLoader", "Failed to close asset: " + paramString);
        }
      }
    }
    catch (IOException localIOException2)
    {
      throw new RuntimeException(localIOException2);
    }
    finally
    {
      if (localAssetFileDescriptor == null);
    }
    try
    {
      localAssetFileDescriptor.close();
      throw localObject;
    }
    catch (IOException localIOException1)
    {
      while (true)
        Log.e("DexLibLoader", "Failed to close asset: " + paramString);
    }
  }

  private File b(String paramString)
  {
    String str = paramString + ".lock";
    return new File(this.l.getDir("dex", 0), str);
  }

  private String b(String paramString, int paramInt)
  {
    return "pre-dexed-jars/" + c(paramString, paramInt);
  }

  private void b(DexLibLoader.ThirdPartyDexSpec paramThirdPartyDexSpec)
  {
    try
    {
      a(paramThirdPartyDexSpec, false);
      i1 = 1;
      if (i1 == 0);
    }
    catch (Exception localException)
    {
      while (true)
      {
        try
        {
          Class.forName(paramThirdPartyDexSpec.c);
          i2 = 1;
          if (i2 != 0)
            continue;
          a(paramThirdPartyDexSpec, true);
          a(paramThirdPartyDexSpec.c);
          return;
          localException = localException;
          Log.v("DexLibLoader", "Caught exception trying to ensure dex. Will retry with full copy", localException);
          int i1 = 0;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Log.v("DexLibLoader", "Dex did not load successfully. Will retry with full copy", localClassNotFoundException);
          i2 = 0;
          continue;
        }
        int i2 = 0;
      }
    }
  }

  private void b(String paramString, File paramFile)
  {
    if ((paramFile.exists()) && (a(paramFile, paramString)))
      Log.v("DexLibLoader", "Dex already copied");
    while (true)
    {
      return;
      Log.v("DexLibLoader", "About to extract " + paramString + " to " + paramFile.getAbsolutePath());
      a(paramString, paramFile);
      Log.v("DexLibLoader", "Finished extracting.");
    }
  }

  private String c(String paramString, int paramInt)
  {
    return paramString + "." + paramInt + ".jar";
  }

  private void d(String paramString, int paramInt)
  {
    for (int i1 = 0; i1 < paramInt; i1++)
    {
      File localFile = a(paramString, i1);
      Log.d("DexLibLoader", "Deleting old version: " + localFile);
      localFile.delete();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dex_tricks.DexLibLoader
 * JD-Core Version:    0.6.0
 */