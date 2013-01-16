package com.facebook.common.json.jsonmirror.types;

import java.util.HashMap;
import java.util.Map;

public abstract class JMBase
{
  public static final JMString a = new JMString();
  public static final JMBoolean b = new JMBoolean();
  public static final JMLong c = new JMLong();
  public static final JMDouble d = new JMDouble();
  public static final JMSimpleDict e = new JMSimpleDict();
  protected static Map<Class<?>, JMBase> f = new HashMap();

  // ERROR //
  public static JMBase a(Class<?> paramClass)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 51	com/facebook/common/json/jsonmirror/types/JMBase:f	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 63 2 0
    //   12: checkcast 2	com/facebook/common/json/jsonmirror/types/JMBase
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +28 -> 45
    //   20: aload_0
    //   21: ldc 65
    //   23: if_acmpne +27 -> 50
    //   26: getstatic 26	com/facebook/common/json/jsonmirror/types/JMBase:a	Lcom/facebook/common/json/jsonmirror/types/JMString;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +14 -> 45
    //   34: getstatic 51	com/facebook/common/json/jsonmirror/types/JMBase:f	Ljava/util/Map;
    //   37: aload_0
    //   38: aload_2
    //   39: invokeinterface 69 3 0
    //   44: pop
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: aload_0
    //   51: ldc 71
    //   53: if_acmpeq +10 -> 63
    //   56: aload_0
    //   57: getstatic 75	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   60: if_acmpne +10 -> 70
    //   63: getstatic 31	com/facebook/common/json/jsonmirror/types/JMBase:b	Lcom/facebook/common/json/jsonmirror/types/JMBoolean;
    //   66: astore_2
    //   67: goto -37 -> 30
    //   70: aload_0
    //   71: ldc 77
    //   73: if_acmpeq +23 -> 96
    //   76: aload_0
    //   77: getstatic 78	java/lang/Long:TYPE	Ljava/lang/Class;
    //   80: if_acmpeq +16 -> 96
    //   83: aload_0
    //   84: ldc 80
    //   86: if_acmpeq +10 -> 96
    //   89: aload_0
    //   90: getstatic 81	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   93: if_acmpne +10 -> 103
    //   96: getstatic 36	com/facebook/common/json/jsonmirror/types/JMBase:c	Lcom/facebook/common/json/jsonmirror/types/JMLong;
    //   99: astore_2
    //   100: goto -70 -> 30
    //   103: aload_0
    //   104: ldc 83
    //   106: if_acmpeq +23 -> 129
    //   109: aload_0
    //   110: getstatic 84	java/lang/Double:TYPE	Ljava/lang/Class;
    //   113: if_acmpeq +16 -> 129
    //   116: aload_0
    //   117: ldc 86
    //   119: if_acmpeq +10 -> 129
    //   122: aload_0
    //   123: getstatic 87	java/lang/Float:TYPE	Ljava/lang/Class;
    //   126: if_acmpne +10 -> 136
    //   129: getstatic 41	com/facebook/common/json/jsonmirror/types/JMBase:d	Lcom/facebook/common/json/jsonmirror/types/JMDouble;
    //   132: astore_2
    //   133: goto -103 -> 30
    //   136: ldc 59
    //   138: aload_0
    //   139: invokevirtual 93	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   142: ifeq +10 -> 152
    //   145: getstatic 46	com/facebook/common/json/jsonmirror/types/JMBase:e	Lcom/facebook/common/json/jsonmirror/types/JMSimpleDict;
    //   148: astore_2
    //   149: goto -119 -> 30
    //   152: ldc 2
    //   154: aload_0
    //   155: invokevirtual 93	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   158: istore 4
    //   160: iload 4
    //   162: ifeq -132 -> 30
    //   165: aload_0
    //   166: invokevirtual 97	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   169: checkcast 2	com/facebook/common/json/jsonmirror/types/JMBase
    //   172: astore_2
    //   173: goto -143 -> 30
    //   176: astore 6
    //   178: new 99	com/facebook/common/json/jsonmirror/JMFatalException
    //   181: dup
    //   182: new 101	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   189: ldc 104
    //   191: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: invokevirtual 112	java/lang/Class:getName	()Ljava/lang/String;
    //   198: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokespecial 118	com/facebook/common/json/jsonmirror/JMFatalException:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: astore_1
    //   209: ldc 2
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore 5
    //   216: new 99	com/facebook/common/json/jsonmirror/JMFatalException
    //   219: dup
    //   220: new 101	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   227: ldc 104
    //   229: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_0
    //   233: invokevirtual 112	java/lang/Class:getName	()Ljava/lang/String;
    //   236: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 118	com/facebook/common/json/jsonmirror/JMFatalException:<init>	(Ljava/lang/String;)V
    //   245: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   165	173	176	java/lang/IllegalAccessException
    //   3	45	208	finally
    //   50	160	208	finally
    //   165	173	208	finally
    //   178	208	208	finally
    //   216	246	208	finally
    //   165	173	214	java/lang/InstantiationException
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMBase
 * JD-Core Version:    0.6.0
 */