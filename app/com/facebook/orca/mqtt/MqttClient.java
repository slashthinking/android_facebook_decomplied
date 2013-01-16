package com.facebook.orca.mqtt;

import com.facebook.base.DNSResolver;
import com.facebook.orca.common.async.AsyncTaskRunner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.mqtt.messages.ConnAckMqttMessage;
import com.facebook.orca.mqtt.messages.ConnAckVariableHeader;
import com.facebook.orca.mqtt.messages.ConnectMqttMessage;
import com.facebook.orca.mqtt.messages.ConnectPayloadBuilder;
import com.facebook.orca.mqtt.messages.ConnectVariableHeaderBuilder;
import com.facebook.orca.mqtt.messages.FixedHeader;
import com.facebook.orca.mqtt.messages.FixedHeaderBuilder;
import com.facebook.orca.mqtt.messages.MessageIdVariableHeader;
import com.facebook.orca.mqtt.messages.MqttMessage;
import com.facebook.orca.mqtt.messages.PublishMqttMessage;
import com.facebook.orca.mqtt.messages.PublishVariableHeader;
import com.facebook.orca.mqtt.messages.SubscribeMqttMessage;
import com.facebook.orca.mqtt.messages.SubscribePayload;
import com.facebook.orca.mqtt.messages.SubscribeTopic;
import com.facebook.orca.mqtt.serialization.MessageDecoder;
import com.facebook.orca.mqtt.serialization.MessageEncoder;
import com.facebook.orca.mqtt.serialization.MessageFactory;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.CountingInputStream;
import com.google.common.io.CountingOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;

public class MqttClient
{
  private static final Class<?> a = MqttClient.class;
  private final MqttSsl b;
  private final MqttParameters c;
  private long d;
  private long e;
  private Socket f;
  private MessageDecoder g;
  private MessageEncoder h;
  private Thread i;
  private AtomicInteger j = new AtomicInteger(1);
  private volatile MqttClient.State k = MqttClient.State.INIT;
  private volatile MqttClientCallback l;
  private CountingInputStream m;
  private CountingOutputStream n;

  public MqttClient(MqttSsl paramMqttSsl, MqttParameters paramMqttParameters)
  {
    this.b = paramMqttSsl;
    this.c = paramMqttParameters;
  }

  private void a(MessageEncoder paramMessageEncoder, MqttParameters paramMqttParameters)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("uid", paramMqttParameters.g());
    localObjectNode.put("agent", paramMqttParameters.i());
    localObjectNode.putAll(paramMqttParameters.j());
    BLog.a(a, "Connecting with %s", new Object[] { localObjectNode });
    paramMessageEncoder.a(new ConnectMqttMessage(FixedHeader.newBuilder().a(1).f(), new ConnectVariableHeaderBuilder().a(3).a(true).b(true).c(paramMqttParameters.e()).e(paramMqttParameters.d()).i(), new ConnectPayloadBuilder().a(paramMqttParameters.f()).d(localObjectNode.toString()).e(paramMqttParameters.h()).f()));
  }

  private void a(MessageEncoder paramMessageEncoder, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramMessageEncoder.a(new PublishMqttMessage(FixedHeader.newBuilder().a(3).b(paramInt1).f(), new PublishVariableHeader(paramString, paramInt2), paramArrayOfByte));
    if (this.l != null)
      this.l.b(paramInt2);
  }

  private void a(MessageEncoder paramMessageEncoder, List<SubscribeTopic> paramList)
  {
    FixedHeader localFixedHeader = FixedHeader.newBuilder().a(8).f();
    int i1 = k();
    paramMessageEncoder.a(new SubscribeMqttMessage(localFixedHeader, new MessageIdVariableHeader(i1), new SubscribePayload(paramList)));
    if (this.l != null)
      this.l.b(i1);
  }

  private void a(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    try
    {
      j();
      if (b())
        a(this.h, paramString, paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (Throwable localThrowable)
    {
      BLog.d(a, "Caught exception trying to publish", localThrowable);
      i();
    }
  }

  private void a(Socket paramSocket, ConnectionFailureReason paramConnectionFailureReason)
  {
    if (paramSocket != null);
    try
    {
      paramSocket.close();
      label8: monitorenter;
      try
      {
        this.f = null;
        this.h = null;
        this.g = null;
        this.e = 0L;
        this.m = null;
        this.d = 0L;
        this.n = null;
        this.k = MqttClient.State.DISCONNECTED;
        notifyAll();
        monitorexit;
        if (this.l != null)
          this.l.a(paramConnectionFailureReason);
        return;
      }
      finally
      {
        monitorexit;
      }
    }
    catch (IOException localIOException)
    {
      break label8;
    }
  }

  private void b(List<SubscribeTopic> paramList)
  {
    try
    {
      j();
      if (b())
        a(this.h, paramList);
    }
    catch (Throwable localThrowable)
    {
      BLog.d(a, "Caught exception trying to subscribe", localThrowable);
      i();
    }
  }

  // ERROR //
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 265	com/facebook/orca/mqtt/MqttClient:h	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 54	com/facebook/orca/mqtt/MqttClient:k	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   10: getstatic 268	com/facebook/orca/mqtt/MqttClient$State:CONNECTED	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   13: if_acmpeq +15 -> 28
    //   16: aload_0
    //   17: monitorexit
    //   18: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   21: ldc_w 270
    //   24: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   27: return
    //   28: aload_0
    //   29: getfield 242	com/facebook/orca/mqtt/MqttClient:g	Lcom/facebook/orca/mqtt/serialization/MessageDecoder;
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: invokevirtual 278	com/facebook/orca/mqtt/serialization/MessageDecoder:a	()Lcom/facebook/orca/mqtt/messages/MqttMessage;
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 282	com/facebook/orca/mqtt/messages/MqttMessage:e	()I
    //   46: bipush 9
    //   48: if_icmpne +48 -> 96
    //   51: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   54: ldc_w 284
    //   57: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   60: goto -56 -> 4
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 54	com/facebook/orca/mqtt/MqttClient:k	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   73: getstatic 253	com/facebook/orca/mqtt/MqttClient$State:DISCONNECTED	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   76: if_acmpeq -58 -> 18
    //   79: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   82: ldc_w 286
    //   85: aload_3
    //   86: invokestatic 228	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: invokespecial 230	com/facebook/orca/mqtt/MqttClient:i	()V
    //   93: goto -75 -> 18
    //   96: aload 4
    //   98: invokevirtual 282	com/facebook/orca/mqtt/messages/MqttMessage:e	()I
    //   101: bipush 12
    //   103: if_icmpne +15 -> 118
    //   106: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   109: ldc_w 288
    //   112: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   115: goto -111 -> 4
    //   118: aload 4
    //   120: invokevirtual 282	com/facebook/orca/mqtt/messages/MqttMessage:e	()I
    //   123: bipush 13
    //   125: if_icmpne +15 -> 140
    //   128: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   131: ldc_w 290
    //   134: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   137: goto -133 -> 4
    //   140: aload 4
    //   142: invokevirtual 282	com/facebook/orca/mqtt/messages/MqttMessage:e	()I
    //   145: iconst_3
    //   146: if_icmpne +69 -> 215
    //   149: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   152: ldc_w 292
    //   155: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   158: aload 4
    //   160: checkcast 181	com/facebook/orca/mqtt/messages/PublishMqttMessage
    //   163: astore 7
    //   165: aload_0
    //   166: getfield 193	com/facebook/orca/mqtt/MqttClient:l	Lcom/facebook/orca/mqtt/MqttClientCallback;
    //   169: astore 8
    //   171: aload 8
    //   173: ifnull -169 -> 4
    //   176: aload 8
    //   178: aload 7
    //   180: invokevirtual 295	com/facebook/orca/mqtt/messages/PublishMqttMessage:a	()Lcom/facebook/orca/mqtt/messages/PublishVariableHeader;
    //   183: invokevirtual 297	com/facebook/orca/mqtt/messages/PublishVariableHeader:a	()Ljava/lang/String;
    //   186: aload 7
    //   188: invokevirtual 300	com/facebook/orca/mqtt/messages/PublishMqttMessage:c	()[B
    //   191: aload 7
    //   193: invokevirtual 301	com/facebook/orca/mqtt/messages/PublishMqttMessage:f	()Lcom/facebook/orca/mqtt/messages/FixedHeader;
    //   196: invokevirtual 303	com/facebook/orca/mqtt/messages/FixedHeader:c	()I
    //   199: aload 7
    //   201: invokevirtual 301	com/facebook/orca/mqtt/messages/PublishMqttMessage:f	()Lcom/facebook/orca/mqtt/messages/FixedHeader;
    //   204: invokevirtual 304	com/facebook/orca/mqtt/messages/FixedHeader:d	()Z
    //   207: invokeinterface 307 5 0
    //   212: goto -208 -> 4
    //   215: aload 4
    //   217: invokevirtual 282	com/facebook/orca/mqtt/messages/MqttMessage:e	()I
    //   220: iconst_4
    //   221: if_icmpne -217 -> 4
    //   224: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   227: ldc_w 309
    //   230: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   233: aload 4
    //   235: checkcast 311	com/facebook/orca/mqtt/messages/PubAckMessage
    //   238: astore 5
    //   240: aload_0
    //   241: getfield 193	com/facebook/orca/mqtt/MqttClient:l	Lcom/facebook/orca/mqtt/MqttClientCallback;
    //   244: astore 6
    //   246: aload 6
    //   248: ifnull -244 -> 4
    //   251: aload 6
    //   253: aload 5
    //   255: invokevirtual 314	com/facebook/orca/mqtt/messages/PubAckMessage:a	()Lcom/facebook/orca/mqtt/messages/MessageIdVariableHeader;
    //   258: invokevirtual 316	com/facebook/orca/mqtt/messages/MessageIdVariableHeader:a	()I
    //   261: invokeinterface 318 2 0
    //   266: goto -262 -> 4
    //
    // Exception table:
    //   from	to	target	type
    //   6	18	63	finally
    //   28	35	63	finally
    //   64	66	63	finally
    //   35	41	68	java/io/IOException
  }

  private void h()
  {
    BLog.c(a, "Connecting");
    Object localObject1 = null;
    try
    {
      boolean bool = this.c.c();
      localObject1 = null;
      if (bool);
      Socket localSocket;
      for (localObject1 = this.b.a().createSocket(); ; localObject1 = localSocket)
      {
        ((Socket)localObject1).connect(new InetSocketAddress(DNSResolver.a(this.c.a(), 30000), this.c.b()), 30000);
        ((Socket)localObject1).setSoTimeout(0);
        ((Socket)localObject1).setKeepAlive(false);
        localMessageDecoder = new MessageDecoder(new MessageFactory());
        localCountingInputStream = new CountingInputStream(((Socket)localObject1).getInputStream());
        localMessageDecoder.a(new DataInputStream(localCountingInputStream));
        localMessageEncoder = new MessageEncoder();
        localCountingOutputStream = new CountingOutputStream(((Socket)localObject1).getOutputStream());
        localMessageEncoder.a(new DataOutputStream(localCountingOutputStream));
        a(localMessageEncoder, this.c);
        localMqttMessage = localMessageDecoder.a();
        if (localMqttMessage.e() == 2)
          break;
        BLog.d(a, "Received unexpected message type " + localMqttMessage.e());
        a((Socket)localObject1, ConnectionFailureReason.MQTT_ERROR);
        return;
        localSocket = new Socket();
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        MessageDecoder localMessageDecoder;
        CountingInputStream localCountingInputStream;
        MessageEncoder localMessageEncoder;
        CountingOutputStream localCountingOutputStream;
        MqttMessage localMqttMessage;
        BLog.d(a, "Failed to connect", localIOException);
        a((Socket)localObject1, ConnectionFailureReason.NETWORK_ERROR);
        continue;
        int i1 = ((ConnAckMqttMessage)localMqttMessage).a().a();
        if (i1 != 0)
        {
          BLog.d(a, "MQTT Connection refused: " + i1);
          a((Socket)localObject1, ConnectionFailureReason.MQTT_ERROR);
          continue;
        }
        monitorenter;
        try
        {
          this.f = ((Socket)localObject1);
          this.h = localMessageEncoder;
          this.g = localMessageDecoder;
          this.e = 0L;
          this.m = localCountingInputStream;
          this.d = 0L;
          this.n = localCountingOutputStream;
          this.k = MqttClient.State.CONNECTED;
          notifyAll();
          monitorexit;
          if (this.l == null)
            continue;
          this.l.a();
          continue;
        }
        finally
        {
          monitorexit;
        }
      }
    }
    throw localObject2;
  }

  // ERROR //
  private void i()
  {
    // Byte code:
    //   0: getstatic 36	com/facebook/orca/mqtt/MqttClient:a	Ljava/lang/Class;
    //   3: ldc_w 441
    //   6: invokestatic 273	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 54	com/facebook/orca/mqtt/MqttClient:k	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   15: getstatic 268	com/facebook/orca/mqtt/MqttClient$State:CONNECTED	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   18: if_acmpeq +18 -> 36
    //   21: aload_0
    //   22: getfield 54	com/facebook/orca/mqtt/MqttClient:k	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   25: getstatic 444	com/facebook/orca/mqtt/MqttClient$State:CONNECTING	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   28: if_acmpeq +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: goto +87 -> 120
    //   36: aload_0
    //   37: getfield 240	com/facebook/orca/mqtt/MqttClient:f	Ljava/net/Socket;
    //   40: astore_2
    //   41: aload_0
    //   42: getfield 193	com/facebook/orca/mqtt/MqttClient:l	Lcom/facebook/orca/mqtt/MqttClientCallback;
    //   45: astore_3
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 240	com/facebook/orca/mqtt/MqttClient:f	Ljava/net/Socket;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 246	com/facebook/orca/mqtt/MqttClient:m	Lcom/google/common/io/CountingInputStream;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 250	com/facebook/orca/mqtt/MqttClient:n	Lcom/google/common/io/CountingOutputStream;
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 446	com/facebook/orca/mqtt/MqttClient:i	Ljava/lang/Thread;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 242	com/facebook/orca/mqtt/MqttClient:g	Lcom/facebook/orca/mqtt/serialization/MessageDecoder;
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 221	com/facebook/orca/mqtt/MqttClient:h	Lcom/facebook/orca/mqtt/serialization/MessageEncoder;
    //   76: aload_0
    //   77: getstatic 253	com/facebook/orca/mqtt/MqttClient$State:DISCONNECTED	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   80: putfield 54	com/facebook/orca/mqtt/MqttClient:k	Lcom/facebook/orca/mqtt/MqttClient$State;
    //   83: aload_0
    //   84: invokevirtual 256	java/lang/Object:notifyAll	()V
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 238	java/net/Socket:close	()V
    //   97: aload_3
    //   98: ifnull +22 -> 120
    //   101: aload_3
    //   102: invokeinterface 448 1 0
    //   107: goto +13 -> 120
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore 4
    //   117: goto -20 -> 97
    //   120: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	89	110	finally
    //   111	113	110	finally
    //   93	97	115	java/lang/Throwable
  }

  private void j()
  {
    monitorenter;
    try
    {
      if (this.k == MqttClient.State.CONNECTING)
        wait();
    }
    finally
    {
      monitorexit;
    }
  }

  private int k()
  {
    return 0xFFFF & this.j.incrementAndGet();
  }

  public int a(String paramString, byte[] paramArrayOfByte, MqttQOSLevel paramMqttQOSLevel, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      if (!b())
        throw new MqttException("Not connected");
    }
    finally
    {
      monitorexit;
    }
    BLog.c(a, "Publishing on topic " + paramString);
    int i1 = k();
    new AsyncTaskRunner(new MqttClient.4(this, paramString, paramArrayOfByte, paramMqttQOSLevel, paramBoolean, i1)).a();
    monitorexit;
    return i1;
  }

  public void a()
  {
    monitorenter;
    try
    {
      if (this.k != MqttClient.State.INIT)
        throw new IllegalStateException("Tried to connect on used client");
    }
    finally
    {
      monitorexit;
    }
    this.k = MqttClient.State.CONNECTING;
    this.i = new Thread(new MqttClient.1(this), "MqttClient Network Thread");
    this.i.start();
    monitorexit;
  }

  public void a(MqttClientCallback paramMqttClientCallback)
  {
    this.l = paramMqttClientCallback;
  }

  public void a(List<SubscribeTopic> paramList)
  {
    monitorenter;
    try
    {
      if (!b())
        throw new MqttException("Not connected");
    }
    finally
    {
      monitorexit;
    }
    new AsyncTaskRunner(new MqttClient.2(this, paramList)).a();
    monitorexit;
  }

  public boolean b()
  {
    monitorenter;
    try
    {
      if (this.k != MqttClient.State.CONNECTING)
      {
        MqttClient.State localState1 = this.k;
        MqttClient.State localState2 = MqttClient.State.CONNECTED;
        if (localState1 != localState2);
      }
      else
      {
        i1 = 1;
        return i1;
      }
      int i1 = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      MqttClient.State localState1 = this.k;
      MqttClient.State localState2 = MqttClient.State.CONNECTED;
      if (localState1 == localState2)
      {
        i1 = 1;
        return i1;
      }
      int i1 = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public void d()
  {
    monitorenter;
    try
    {
      if (b())
        new AsyncTaskRunner(new MqttClient.5(this)).a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public long e()
  {
    long l1;
    if (this.n != null)
    {
      long l2 = this.d;
      this.d = this.n.a();
      l1 = this.d - l2;
    }
    while (true)
    {
      return l1;
      l1 = 0L;
    }
  }

  public long f()
  {
    long l1;
    if (this.m != null)
    {
      long l2 = this.e;
      this.e = this.m.a();
      l1 = this.e - l2;
    }
    while (true)
    {
      return l1;
      l1 = 0L;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MqttClient (");
    localStringBuilder.append(this.c.a());
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.b());
    if (this.c.c())
      localStringBuilder.append(" +ssl");
    localStringBuilder.append(") ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mqtt.MqttClient
 * JD-Core Version:    0.6.0
 */