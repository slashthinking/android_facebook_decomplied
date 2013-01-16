package com.facebook.common.json.jsonmirror;

import com.facebook.base.BuildConstants;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.json.jsonmirror.types.JMBase;
import com.facebook.common.json.jsonmirror.types.JMBoolean;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.common.json.jsonmirror.types.JMDouble;
import com.facebook.common.json.jsonmirror.types.JMEscaped;
import com.facebook.common.json.jsonmirror.types.JMList;
import com.facebook.common.json.jsonmirror.types.JMLong;
import com.facebook.common.json.jsonmirror.types.JMString;
import com.facebook.debug.Assert;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JMParser
{
  private static Class<?> a = JMParser.class;

  protected static JMBase a(Class<? extends JMBase> paramClass, Set<JMBase> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    JMBase localJMBase;
    do
    {
      if (!localIterator.hasNext())
        break;
      localJMBase = (JMBase)localIterator.next();
    }
    while (!a(paramClass, localJMBase));
    while (true)
    {
      return localJMBase;
      localJMBase = null;
    }
  }

  protected static Boolean a(JsonParser paramJsonParser, Set<JMBase> paramSet)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    boolean bool;
    if (a(JMBoolean.class, paramSet) != null)
      if (localJsonToken == JsonToken.VALUE_TRUE)
        bool = true;
    for (Boolean localBoolean = new Boolean(bool); ; localBoolean = null)
    {
      return localBoolean;
      bool = false;
      break;
      a(localJsonToken, paramSet);
    }
  }

  public static Object a(JsonParser paramJsonParser, JMBase paramJMBase)
  {
    HashSet localHashSet = Sets.a();
    localHashSet.add(paramJMBase);
    return d(paramJsonParser, localHashSet);
  }

  public static <typeClass> typeClass a(JsonParser paramJsonParser, Class<typeClass> paramClass)
  {
    Object localObject = a(paramJsonParser, JMAutogen.a(paramClass));
    if ((localObject == null) || (localObject.getClass() == paramClass));
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      return localObject;
    }
  }

  protected static Object a(JsonToken paramJsonToken, JsonParser paramJsonParser, Set<JMBase> paramSet)
  {
    if (((paramJsonToken == JsonToken.VALUE_NUMBER_INT) || (paramJsonToken == JsonToken.VALUE_STRING)) && (a(JMLong.class, paramSet) != null));
    while (true)
    {
      Object localObject1;
      try
      {
        Long localLong = Long.valueOf(Long.parseLong(paramJsonParser.getText()));
        localObject1 = localLong;
        return localObject1;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
      }
      if (a(JMDouble.class, paramSet) != null)
        try
        {
          Double localDouble = Double.valueOf(Double.parseDouble(paramJsonParser.getText()));
          localObject1 = localDouble;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
        }
      if (((paramJsonToken == JsonToken.VALUE_NUMBER_INT) || (paramJsonToken == JsonToken.VALUE_STRING)) && (a(JMBoolean.class, paramSet) != null))
      {
        if (paramJsonParser.getText().equals("0"))
        {
          localObject1 = Boolean.valueOf(false);
          continue;
        }
        if (paramJsonParser.getText().equals("1"))
        {
          localObject1 = Boolean.valueOf(true);
          continue;
        }
      }
      JMEscaped localJMEscaped;
      JsonParser localJsonParser;
      if (paramJsonToken == JsonToken.VALUE_STRING)
      {
        JMBase localJMBase2 = a(JMEscaped.class, paramSet);
        if (localJMBase2 != null)
        {
          Assert.b(localJMBase2 instanceof JMEscaped);
          localJMEscaped = (JMEscaped)localJMBase2;
          localJsonParser = localJMEscaped.h.createJsonParser(paramJsonParser.getText());
          FbJsonChecker.a(localJsonParser);
        }
      }
      try
      {
        Object localObject2 = a(localJsonParser, localJMEscaped.g);
        localObject1 = localObject2;
        if (localObject1 != null)
          continue;
        label208: if (paramJsonToken == JsonToken.VALUE_STRING)
        {
          JMBase localJMBase1 = a(JMString.class, paramSet);
          if (localJMBase1 != null)
          {
            Assert.b(localJMBase1 instanceof JMString);
            localObject1 = ((JMString)localJMBase1).a(paramJsonParser.getText());
            continue;
          }
        }
        a(paramJsonParser.getCurrentToken(), paramSet);
        localObject1 = null;
      }
      catch (JMException localJMException)
      {
        break label208;
      }
    }
  }

  protected static void a(JsonToken paramJsonToken, JMBase paramJMBase)
  {
    if (!BuildConstants.a());
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder("Unexpected token ");
      localStringBuilder.append(paramJsonToken.toString());
      if (paramJMBase != null)
      {
        localStringBuilder.append("; expecting a ");
        localStringBuilder.append(paramJMBase.toString());
        BLog.e(a, localStringBuilder.toString());
        continue;
      }
      localStringBuilder.append("; field not defined.");
      BLog.d(a, localStringBuilder.toString());
    }
  }

  protected static void a(JsonToken paramJsonToken, Set<JMBase> paramSet)
  {
    if (!BuildConstants.a());
    while (true)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder("Unexpected token ");
      localStringBuilder.append(paramJsonToken.toString());
      localStringBuilder.append("; expecting one of the following: (");
      Iterator localIterator = paramSet.iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        JMBase localJMBase = (JMBase)localIterator.next();
        if (i == 1)
          i = 0;
        while (true)
        {
          localStringBuilder.append(localJMBase.toString());
          break;
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append(")");
      BLog.e(a, localStringBuilder.toString());
    }
  }

  protected static boolean a(Class<? extends JMBase> paramClass, JMBase paramJMBase)
  {
    return paramClass.isInstance(paramJMBase);
  }

  public static <typeClass> List<typeClass> b(JsonParser paramJsonParser, Class<typeClass> paramClass)
  {
    JMDict localJMDict = JMAutogen.a(paramClass);
    HashSet localHashSet = Sets.a();
    localHashSet.add(localJMDict);
    Object localObject = a(paramJsonParser, new JMList(localHashSet));
    if ((localObject == null) || ((localObject instanceof List)));
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      return (List)localObject;
    }
  }

  protected static List<Object> b(JsonParser paramJsonParser, Set<JMBase> paramSet)
  {
    JMList localJMList = (JMList)a(JMList.class, paramSet);
    ImmutableList.Builder localBuilder;
    if (localJMList != null)
    {
      localBuilder = ImmutableList.e();
      Set localSet = localJMList.a();
      for (JsonToken localJsonToken = FbJsonChecker.a(paramJsonParser); localJsonToken != JsonToken.END_ARRAY; localJsonToken = FbJsonChecker.a(paramJsonParser))
      {
        Object localObject = d(paramJsonParser, localSet);
        if (localObject == null)
          continue;
        localBuilder.b(localObject);
      }
    }
    for (ImmutableList localImmutableList = localBuilder.b(); ; localImmutableList = null)
    {
      return localImmutableList;
      a(paramJsonParser.getCurrentToken(), paramSet);
      paramJsonParser.skipChildren();
    }
  }

  // ERROR //
  protected static Object c(JsonParser paramJsonParser, Set<JMBase> paramSet)
  {
    // Byte code:
    //   0: ldc 247
    //   2: aload_1
    //   3: invokestatic 47	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Ljava/util/Set;)Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +918 -> 926
    //   11: aload_2
    //   12: checkcast 247	com/facebook/common/json/jsonmirror/types/JMDict
    //   15: astore 20
    //   17: aload 20
    //   19: invokevirtual 250	com/facebook/common/json/jsonmirror/types/JMDict:b	()Lcom/facebook/common/json/jsonmirror/JMDictDestination;
    //   22: astore 4
    //   24: aload_0
    //   25: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   28: astore 21
    //   30: aconst_null
    //   31: astore 22
    //   33: aload 21
    //   35: getstatic 253	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   38: if_acmpeq +865 -> 903
    //   41: aload 21
    //   43: getstatic 256	com/fasterxml/jackson/core/JsonToken:FIELD_NAME	Lcom/fasterxml/jackson/core/JsonToken;
    //   46: if_acmpne +22 -> 68
    //   49: aload_0
    //   50: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   53: astore 28
    //   55: aload_0
    //   56: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   59: astore 21
    //   61: aload 28
    //   63: astore 22
    //   65: goto -32 -> 33
    //   68: aload 22
    //   70: invokestatic 259	com/facebook/debug/Assert:a	(Ljava/lang/Object;)V
    //   73: aload 20
    //   75: aload 22
    //   77: invokevirtual 262	com/facebook/common/json/jsonmirror/types/JMDict:a	(Ljava/lang/String;)Lcom/facebook/common/util/Tuple;
    //   80: astore 23
    //   82: aload 23
    //   84: ifnull +1229 -> 1313
    //   87: aload 23
    //   89: getfield 267	com/facebook/common/util/Tuple:a	Ljava/lang/Object;
    //   92: checkcast 134	java/lang/String
    //   95: astore 42
    //   97: aload 23
    //   99: getfield 269	com/facebook/common/util/Tuple:b	Ljava/lang/Object;
    //   102: checkcast 33	com/facebook/common/json/jsonmirror/types/JMBase
    //   105: astore 24
    //   107: aload 42
    //   109: astore 25
    //   111: ldc_w 271
    //   114: aload 24
    //   116: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   119: ifeq +75 -> 194
    //   122: aload 21
    //   124: invokevirtual 274	com/fasterxml/jackson/core/JsonToken:isScalarValue	()Z
    //   127: ifeq +27 -> 154
    //   130: aload_0
    //   131: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   134: astore 41
    //   136: aload 20
    //   138: aload 4
    //   140: aload 25
    //   142: aload 41
    //   144: invokevirtual 277	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 22
    //   149: astore 28
    //   151: goto -96 -> 55
    //   154: new 279	java/io/CharArrayWriter
    //   157: dup
    //   158: invokespecial 280	java/io/CharArrayWriter:<init>	()V
    //   161: astore 39
    //   163: getstatic 285	com/facebook/common/json/FBJsonFactory:a	Lcom/facebook/common/json/FBJsonFactory;
    //   166: aload 39
    //   168: invokevirtual 289	com/facebook/common/json/FBJsonFactory:createJsonGenerator	(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;
    //   171: astore 40
    //   173: aload 40
    //   175: aload_0
    //   176: invokevirtual 295	com/fasterxml/jackson/core/JsonGenerator:copyCurrentStructure	(Lcom/fasterxml/jackson/core/JsonParser;)V
    //   179: aload 40
    //   181: invokevirtual 298	com/fasterxml/jackson/core/JsonGenerator:close	()V
    //   184: aload 39
    //   186: invokevirtual 299	java/io/CharArrayWriter:toString	()Ljava/lang/String;
    //   189: astore 41
    //   191: goto -55 -> 136
    //   194: aload 21
    //   196: getstatic 100	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_INT	Lcom/fasterxml/jackson/core/JsonToken;
    //   199: if_acmpeq +19 -> 218
    //   202: aload 21
    //   204: getstatic 302	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_FLOAT	Lcom/fasterxml/jackson/core/JsonToken;
    //   207: if_acmpeq +11 -> 218
    //   210: aload 21
    //   212: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   215: if_acmpne +409 -> 624
    //   218: aload 21
    //   220: getstatic 100	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_INT	Lcom/fasterxml/jackson/core/JsonToken;
    //   223: if_acmpeq +11 -> 234
    //   226: aload 21
    //   228: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   231: if_acmpne +1076 -> 1307
    //   234: ldc 105
    //   236: aload 24
    //   238: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   241: ifeq +1066 -> 1307
    //   244: aload 20
    //   246: aload 4
    //   248: aload 25
    //   250: aload_0
    //   251: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   254: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   257: invokevirtual 305	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;J)V
    //   260: iconst_1
    //   261: istore 26
    //   263: iload 26
    //   265: ifne +63 -> 328
    //   268: aload 21
    //   270: getstatic 100	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_INT	Lcom/fasterxml/jackson/core/JsonToken;
    //   273: if_acmpeq +11 -> 284
    //   276: aload 21
    //   278: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   281: if_acmpne +47 -> 328
    //   284: ldc 45
    //   286: aload 24
    //   288: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   291: ifeq +37 -> 328
    //   294: aload_0
    //   295: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   298: ldc 132
    //   300: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   303: ifeq +238 -> 541
    //   306: iconst_0
    //   307: istore 34
    //   309: iconst_1
    //   310: istore 26
    //   312: iload 26
    //   314: ifeq +14 -> 328
    //   317: aload 20
    //   319: aload 4
    //   321: aload 25
    //   323: iload 34
    //   325: invokevirtual 308	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Z)V
    //   328: iload 26
    //   330: ifne +32 -> 362
    //   333: ldc 121
    //   335: aload 24
    //   337: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   340: ifeq +22 -> 362
    //   343: aload 20
    //   345: aload 4
    //   347: aload 25
    //   349: aload_0
    //   350: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   353: invokestatic 127	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   356: invokevirtual 311	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;D)V
    //   359: iconst_1
    //   360: istore 26
    //   362: iload 26
    //   364: ifne +930 -> 1294
    //   367: aload 21
    //   369: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   372: if_acmpne +922 -> 1294
    //   375: ldc 144
    //   377: aload 24
    //   379: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   382: ifeq +912 -> 1294
    //   385: aload 24
    //   387: checkcast 144	com/facebook/common/json/jsonmirror/types/JMEscaped
    //   390: astore 29
    //   392: aload 29
    //   394: getfield 148	com/facebook/common/json/jsonmirror/types/JMEscaped:h	Lcom/fasterxml/jackson/core/JsonFactory;
    //   397: aload_0
    //   398: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   401: invokevirtual 154	com/fasterxml/jackson/core/JsonFactory:createJsonParser	(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;
    //   404: astore 30
    //   406: aload 30
    //   408: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   411: pop
    //   412: aload 30
    //   414: aload 29
    //   416: getfield 163	com/facebook/common/json/jsonmirror/types/JMEscaped:g	Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   419: invokestatic 83	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Ljava/lang/Object;
    //   422: astore 32
    //   424: aload 32
    //   426: ifnull +868 -> 1294
    //   429: aload 29
    //   431: getfield 163	com/facebook/common/json/jsonmirror/types/JMEscaped:g	Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   434: instanceof 215
    //   437: ifeq +125 -> 562
    //   440: aload 20
    //   442: aload 4
    //   444: aload 25
    //   446: aload 32
    //   448: checkcast 220	java/util/List
    //   451: invokevirtual 314	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/util/List;)V
    //   454: iconst_1
    //   455: istore 27
    //   457: iload 27
    //   459: ifne +45 -> 504
    //   462: aload 21
    //   464: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   467: if_acmpne +37 -> 504
    //   470: ldc 165
    //   472: aload 24
    //   474: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   477: ifeq +27 -> 504
    //   480: aload 20
    //   482: aload 4
    //   484: aload 25
    //   486: aload 24
    //   488: checkcast 165	com/facebook/common/json/jsonmirror/types/JMString
    //   491: aload_0
    //   492: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   495: invokevirtual 168	com/facebook/common/json/jsonmirror/types/JMString:a	(Ljava/lang/String;)Ljava/lang/String;
    //   498: invokevirtual 277	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/lang/String;)V
    //   501: iconst_1
    //   502: istore 27
    //   504: iload 27
    //   506: ifne +20 -> 526
    //   509: aload 20
    //   511: invokevirtual 316	com/facebook/common/json/jsonmirror/types/JMDict:c	()Z
    //   514: ifne +12 -> 526
    //   517: aload_0
    //   518: invokevirtual 43	com/fasterxml/jackson/core/JsonParser:getCurrentToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   521: aload 24
    //   523: invokestatic 318	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonToken;Lcom/facebook/common/json/jsonmirror/types/JMBase;)V
    //   526: aload 22
    //   528: astore 28
    //   530: goto -475 -> 55
    //   533: astore 35
    //   535: iconst_0
    //   536: istore 26
    //   538: goto -275 -> 263
    //   541: aload_0
    //   542: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   545: ldc 142
    //   547: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   550: ifeq +751 -> 1301
    //   553: iconst_1
    //   554: istore 34
    //   556: iconst_1
    //   557: istore 26
    //   559: goto -247 -> 312
    //   562: aload 29
    //   564: getfield 163	com/facebook/common/json/jsonmirror/types/JMEscaped:g	Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   567: instanceof 247
    //   570: ifeq +23 -> 593
    //   573: aload 20
    //   575: aload 4
    //   577: aload 25
    //   579: aload 32
    //   581: checkcast 320	com/facebook/common/json/jsonmirror/JMDictDestination
    //   584: invokevirtual 323	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Lcom/facebook/common/json/jsonmirror/JMDictDestination;)V
    //   587: iconst_1
    //   588: istore 27
    //   590: goto -133 -> 457
    //   593: aload 29
    //   595: getfield 163	com/facebook/common/json/jsonmirror/types/JMEscaped:g	Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   598: instanceof 325
    //   601: ifeq +693 -> 1294
    //   604: aload 20
    //   606: aload 4
    //   608: aload 25
    //   610: aload 32
    //   612: checkcast 327	java/util/Map
    //   615: invokevirtual 330	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/util/Map;)V
    //   618: iconst_1
    //   619: istore 27
    //   621: goto -164 -> 457
    //   624: aload 21
    //   626: getstatic 53	com/fasterxml/jackson/core/JsonToken:VALUE_TRUE	Lcom/fasterxml/jackson/core/JsonToken;
    //   629: if_acmpeq +11 -> 640
    //   632: aload 21
    //   634: getstatic 333	com/fasterxml/jackson/core/JsonToken:VALUE_FALSE	Lcom/fasterxml/jackson/core/JsonToken;
    //   637: if_acmpne +62 -> 699
    //   640: ldc 45
    //   642: aload 24
    //   644: invokestatic 36	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Z
    //   647: ifeq +38 -> 685
    //   650: aload 21
    //   652: getstatic 53	com/fasterxml/jackson/core/JsonToken:VALUE_TRUE	Lcom/fasterxml/jackson/core/JsonToken;
    //   655: if_acmpne +24 -> 679
    //   658: iconst_1
    //   659: istore 36
    //   661: aload 20
    //   663: aload 4
    //   665: aload 25
    //   667: iload 36
    //   669: invokevirtual 308	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Z)V
    //   672: aload 22
    //   674: astore 28
    //   676: goto -621 -> 55
    //   679: iconst_0
    //   680: istore 36
    //   682: goto -21 -> 661
    //   685: aload 21
    //   687: aload 24
    //   689: invokestatic 318	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonToken;Lcom/facebook/common/json/jsonmirror/types/JMBase;)V
    //   692: aload 22
    //   694: astore 28
    //   696: goto -641 -> 55
    //   699: aload 21
    //   701: getstatic 336	com/fasterxml/jackson/core/JsonToken:START_ARRAY	Lcom/fasterxml/jackson/core/JsonToken;
    //   704: if_acmpeq +11 -> 715
    //   707: aload 21
    //   709: getstatic 339	com/fasterxml/jackson/core/JsonToken:START_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   712: if_acmpne +184 -> 896
    //   715: aload 24
    //   717: ifnonnull +30 -> 747
    //   720: aload 20
    //   722: invokevirtual 316	com/facebook/common/json/jsonmirror/types/JMDict:c	()Z
    //   725: ifne +10 -> 735
    //   728: aload 21
    //   730: aload 24
    //   732: invokestatic 318	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonToken;Lcom/facebook/common/json/jsonmirror/types/JMBase;)V
    //   735: aload_0
    //   736: invokevirtual 244	com/fasterxml/jackson/core/JsonParser:skipChildren	()Lcom/fasterxml/jackson/core/JsonParser;
    //   739: pop
    //   740: aload 22
    //   742: astore 28
    //   744: goto -689 -> 55
    //   747: aload_0
    //   748: aload 24
    //   750: invokestatic 83	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/facebook/common/json/jsonmirror/types/JMBase;)Ljava/lang/Object;
    //   753: astore 37
    //   755: aload 37
    //   757: ifnull +139 -> 896
    //   760: aload 21
    //   762: getstatic 336	com/fasterxml/jackson/core/JsonToken:START_ARRAY	Lcom/fasterxml/jackson/core/JsonToken;
    //   765: if_acmpeq +11 -> 776
    //   768: aload 37
    //   770: getstatic 345	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   773: if_acmpne +32 -> 805
    //   776: aload 37
    //   778: instanceof 220
    //   781: invokestatic 92	com/facebook/debug/Assert:b	(Z)V
    //   784: aload 20
    //   786: aload 4
    //   788: aload 25
    //   790: aload 37
    //   792: checkcast 220	java/util/List
    //   795: invokevirtual 314	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/util/List;)V
    //   798: aload 22
    //   800: astore 28
    //   802: goto -747 -> 55
    //   805: aload 37
    //   807: instanceof 320
    //   810: ifeq +24 -> 834
    //   813: aload 20
    //   815: aload 4
    //   817: aload 25
    //   819: aload 37
    //   821: checkcast 320	com/facebook/common/json/jsonmirror/JMDictDestination
    //   824: invokevirtual 323	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Lcom/facebook/common/json/jsonmirror/JMDictDestination;)V
    //   827: aload 22
    //   829: astore 28
    //   831: goto -776 -> 55
    //   834: aload 37
    //   836: instanceof 327
    //   839: ifeq +24 -> 863
    //   842: aload 20
    //   844: aload 4
    //   846: aload 25
    //   848: aload 37
    //   850: checkcast 327	java/util/Map
    //   853: invokevirtual 330	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/util/Map;)V
    //   856: aload 22
    //   858: astore 28
    //   860: goto -805 -> 55
    //   863: getstatic 11	com/facebook/common/json/jsonmirror/JMParser:a	Ljava/lang/Class;
    //   866: new 175	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 348
    //   876: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 21
    //   881: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   884: ldc_w 353
    //   887: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 197	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;)V
    //   896: aload 22
    //   898: astore 28
    //   900: goto -845 -> 55
    //   903: aload 4
    //   905: instanceof 355
    //   908: ifeq +15 -> 923
    //   911: aload 4
    //   913: checkcast 355	com/facebook/common/json/jsonmirror/JMDictDestination$PostProcessable
    //   916: aload 20
    //   918: invokeinterface 358 2 0
    //   923: aload 4
    //   925: areturn
    //   926: ldc_w 325
    //   929: aload_1
    //   930: invokestatic 47	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Ljava/util/Set;)Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   933: ifnull +261 -> 1194
    //   936: invokestatic 364	com/google/common/collect/ImmutableMap:k	()Lcom/google/common/collect/ImmutableMap$Builder;
    //   939: astore 7
    //   941: aload_0
    //   942: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   945: astore 8
    //   947: aconst_null
    //   948: astore 9
    //   950: aload 8
    //   952: getstatic 253	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   955: if_acmpeq +229 -> 1184
    //   958: aload 8
    //   960: getstatic 256	com/fasterxml/jackson/core/JsonToken:FIELD_NAME	Lcom/fasterxml/jackson/core/JsonToken;
    //   963: if_acmpne +18 -> 981
    //   966: aload_0
    //   967: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   970: astore 9
    //   972: aload_0
    //   973: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   976: astore 8
    //   978: goto -28 -> 950
    //   981: aload 8
    //   983: getstatic 100	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_INT	Lcom/fasterxml/jackson/core/JsonToken;
    //   986: if_acmpne +21 -> 1007
    //   989: aload 7
    //   991: aload 9
    //   993: aload_0
    //   994: invokevirtual 368	com/fasterxml/jackson/core/JsonParser:getLongValue	()J
    //   997: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1000: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1003: pop
    //   1004: goto -32 -> 972
    //   1007: aload 8
    //   1009: getstatic 302	com/fasterxml/jackson/core/JsonToken:VALUE_NUMBER_FLOAT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1012: if_acmpne +21 -> 1033
    //   1015: aload 7
    //   1017: aload 9
    //   1019: aload_0
    //   1020: invokevirtual 377	com/fasterxml/jackson/core/JsonParser:getDoubleValue	()D
    //   1023: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1026: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1029: pop
    //   1030: goto -58 -> 972
    //   1033: aload 8
    //   1035: getstatic 103	com/fasterxml/jackson/core/JsonToken:VALUE_STRING	Lcom/fasterxml/jackson/core/JsonToken;
    //   1038: if_acmpne +64 -> 1102
    //   1041: aload 7
    //   1043: aload 9
    //   1045: aload_0
    //   1046: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   1049: invokestatic 115	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1052: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1055: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1058: pop
    //   1059: goto -87 -> 972
    //   1062: astore 13
    //   1064: aload 7
    //   1066: aload 9
    //   1068: aload_0
    //   1069: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   1072: invokestatic 127	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1075: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1078: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1081: pop
    //   1082: goto -110 -> 972
    //   1085: astore 14
    //   1087: aload 7
    //   1089: aload 9
    //   1091: aload_0
    //   1092: invokevirtual 109	com/fasterxml/jackson/core/JsonParser:getText	()Ljava/lang/String;
    //   1095: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1098: pop
    //   1099: goto -127 -> 972
    //   1102: aload 8
    //   1104: getstatic 53	com/fasterxml/jackson/core/JsonToken:VALUE_TRUE	Lcom/fasterxml/jackson/core/JsonToken;
    //   1107: if_acmpeq +11 -> 1118
    //   1110: aload 8
    //   1112: getstatic 333	com/fasterxml/jackson/core/JsonToken:VALUE_FALSE	Lcom/fasterxml/jackson/core/JsonToken;
    //   1115: if_acmpne +36 -> 1151
    //   1118: aload 8
    //   1120: getstatic 53	com/fasterxml/jackson/core/JsonToken:VALUE_TRUE	Lcom/fasterxml/jackson/core/JsonToken;
    //   1123: if_acmpne +22 -> 1145
    //   1126: iconst_1
    //   1127: istore 10
    //   1129: aload 7
    //   1131: aload 9
    //   1133: iload 10
    //   1135: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1138: invokevirtual 373	com/google/common/collect/ImmutableMap$Builder:b	(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   1141: pop
    //   1142: goto -170 -> 972
    //   1145: iconst_0
    //   1146: istore 10
    //   1148: goto -19 -> 1129
    //   1151: aload 8
    //   1153: getstatic 336	com/fasterxml/jackson/core/JsonToken:START_ARRAY	Lcom/fasterxml/jackson/core/JsonToken;
    //   1156: if_acmpeq +11 -> 1167
    //   1159: aload 8
    //   1161: getstatic 339	com/fasterxml/jackson/core/JsonToken:START_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1164: if_acmpne -192 -> 972
    //   1167: getstatic 11	com/facebook/common/json/jsonmirror/JMParser:a	Ljava/lang/Class;
    //   1170: ldc_w 379
    //   1173: invokestatic 197	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;)V
    //   1176: aload_0
    //   1177: invokevirtual 244	com/fasterxml/jackson/core/JsonParser:skipChildren	()Lcom/fasterxml/jackson/core/JsonParser;
    //   1180: pop
    //   1181: goto -209 -> 972
    //   1184: aload 7
    //   1186: invokevirtual 382	com/google/common/collect/ImmutableMap$Builder:b	()Lcom/google/common/collect/ImmutableMap;
    //   1189: astore 4
    //   1191: goto -268 -> 923
    //   1194: ldc 215
    //   1196: aload_1
    //   1197: invokestatic 47	com/facebook/common/json/jsonmirror/JMParser:a	(Ljava/lang/Class;Ljava/util/Set;)Lcom/facebook/common/json/jsonmirror/types/JMBase;
    //   1200: ifnull +70 -> 1270
    //   1203: aload_0
    //   1204: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   1207: astore 5
    //   1209: aload 5
    //   1211: getstatic 253	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1214: if_acmpne +11 -> 1225
    //   1217: getstatic 345	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   1220: astore 4
    //   1222: goto -299 -> 923
    //   1225: getstatic 339	com/fasterxml/jackson/core/JsonToken:START_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1228: aload_1
    //   1229: invokestatic 61	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonToken;Ljava/util/Set;)V
    //   1232: aload 5
    //   1234: getstatic 253	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1237: if_acmpeq +46 -> 1283
    //   1240: aload 5
    //   1242: getstatic 336	com/fasterxml/jackson/core/JsonToken:START_ARRAY	Lcom/fasterxml/jackson/core/JsonToken;
    //   1245: if_acmpeq +11 -> 1256
    //   1248: aload 5
    //   1250: getstatic 339	com/fasterxml/jackson/core/JsonToken:START_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   1253: if_acmpne +8 -> 1261
    //   1256: aload_0
    //   1257: invokevirtual 244	com/fasterxml/jackson/core/JsonParser:skipChildren	()Lcom/fasterxml/jackson/core/JsonParser;
    //   1260: pop
    //   1261: aload_0
    //   1262: invokestatic 159	com/facebook/common/json/FbJsonChecker:a	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   1265: astore 5
    //   1267: goto -35 -> 1232
    //   1270: aload_0
    //   1271: invokevirtual 43	com/fasterxml/jackson/core/JsonParser:getCurrentToken	()Lcom/fasterxml/jackson/core/JsonToken;
    //   1274: aload_1
    //   1275: invokestatic 61	com/facebook/common/json/jsonmirror/JMParser:a	(Lcom/fasterxml/jackson/core/JsonToken;Ljava/util/Set;)V
    //   1278: aload_0
    //   1279: invokevirtual 244	com/fasterxml/jackson/core/JsonParser:skipChildren	()Lcom/fasterxml/jackson/core/JsonParser;
    //   1282: pop
    //   1283: aconst_null
    //   1284: astore 4
    //   1286: goto -363 -> 923
    //   1289: astore 33
    //   1291: goto -929 -> 362
    //   1294: iload 26
    //   1296: istore 27
    //   1298: goto -841 -> 457
    //   1301: iconst_0
    //   1302: istore 34
    //   1304: goto -992 -> 312
    //   1307: iconst_0
    //   1308: istore 26
    //   1310: goto -1047 -> 263
    //   1313: aconst_null
    //   1314: astore 24
    //   1316: aconst_null
    //   1317: astore 25
    //   1319: goto -1208 -> 111
    //
    // Exception table:
    //   from	to	target	type
    //   244	260	533	java/lang/NumberFormatException
    //   1041	1059	1062	java/lang/NumberFormatException
    //   1064	1082	1085	java/lang/NumberFormatException
    //   343	359	1289	java/lang/NumberFormatException
  }

  public static Object d(JsonParser paramJsonParser, Set<JMBase> paramSet)
  {
    if ((paramJsonParser.getCurrentToken() == null) && (paramJsonParser.getTokenLocation().getCharOffset() == 0L))
      FbJsonChecker.a(paramJsonParser);
    JsonToken localJsonToken1 = paramJsonParser.getCurrentToken();
    Object localObject;
    if ((localJsonToken1 == JsonToken.VALUE_NUMBER_INT) || (localJsonToken1 == JsonToken.VALUE_NUMBER_FLOAT) || (localJsonToken1 == JsonToken.VALUE_STRING))
      localObject = a(localJsonToken1, paramJsonParser, paramSet);
    while (true)
    {
      return localObject;
      if ((localJsonToken1 == JsonToken.VALUE_TRUE) || (localJsonToken1 == JsonToken.VALUE_FALSE))
      {
        localObject = a(paramJsonParser, paramSet);
        continue;
      }
      if (localJsonToken1 == JsonToken.START_ARRAY)
      {
        localObject = b(paramJsonParser, paramSet);
        continue;
      }
      JsonToken localJsonToken2 = JsonToken.START_OBJECT;
      localObject = null;
      if (localJsonToken1 != localJsonToken2)
        continue;
      localObject = c(paramJsonParser, paramSet);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMParser
 * JD-Core Version:    0.6.0
 */