package com.google.common.io;

import java.nio.CharBuffer;

public final class CharStreams
{
  public static long a(Readable paramReadable, Appendable paramAppendable)
  {
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramReadable.read(localCharBuffer);
      if (i == -1)
        return l;
      localCharBuffer.flip();
      paramAppendable.append(localCharBuffer, 0, i);
    }
  }

  public static String a(Readable paramReadable)
  {
    return b(paramReadable).toString();
  }

  private static StringBuilder b(Readable paramReadable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramReadable, localStringBuilder);
    return localStringBuilder;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.io.CharStreams
 * JD-Core Version:    0.6.2
 */