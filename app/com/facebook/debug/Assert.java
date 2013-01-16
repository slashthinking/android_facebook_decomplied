package com.facebook.debug;

import com.facebook.base.BuildConstants;

public class Assert
{
  public static void a(int paramInt1, int paramInt2)
  {
    if (a())
      junit.framework.Assert.assertEquals(paramInt1, paramInt2);
  }

  public static void a(long paramLong1, long paramLong2)
  {
    if (a())
      junit.framework.Assert.assertEquals(paramLong1, paramLong2);
  }

  public static void a(Object paramObject)
  {
    if (a())
      junit.framework.Assert.assertNotNull(paramObject);
  }

  public static void a(Object paramObject1, Object paramObject2)
  {
    if (a())
      junit.framework.Assert.assertEquals(paramObject1, paramObject2);
  }

  public static void a(String paramString, Object paramObject)
  {
    if (a())
      junit.framework.Assert.assertNotNull(paramString, paramObject);
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    if (a())
      junit.framework.Assert.assertFalse(paramString, paramBoolean);
  }

  public static void a(boolean paramBoolean)
  {
    if (a())
      junit.framework.Assert.assertFalse(paramBoolean);
  }

  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a())
      junit.framework.Assert.assertEquals(paramBoolean1, paramBoolean2);
  }

  public static boolean a()
  {
    if (BuildConstants.a());
    for (int i = 1; ; i = 0)
      return i;
  }

  public static void b(Object paramObject)
  {
    if (a())
      junit.framework.Assert.assertNull(paramObject);
  }

  public static void b(String paramString, Object paramObject)
  {
    if (a())
      junit.framework.Assert.assertNull(paramString, paramObject);
  }

  public static void b(String paramString, boolean paramBoolean)
  {
    if (a())
      junit.framework.Assert.assertTrue(paramString, paramBoolean);
  }

  public static void b(boolean paramBoolean)
  {
    if (a())
      junit.framework.Assert.assertTrue(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.debug.Assert
 * JD-Core Version:    0.6.0
 */