package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PropertyValuesHolder$IntPropertyValuesHolder extends PropertyValuesHolder
{
  IntKeyframeSet h;
  int i;
  private IntProperty j;

  public PropertyValuesHolder$IntPropertyValuesHolder(Property paramProperty, int[] paramArrayOfInt)
  {
    super(paramProperty, null);
    a(paramArrayOfInt);
    if ((paramProperty instanceof IntProperty))
      this.j = ((IntProperty)this.b);
  }

  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, IntKeyframeSet paramIntKeyframeSet)
  {
    super(paramString, null);
    this.d = Integer.TYPE;
    this.e = paramIntKeyframeSet;
    this.h = ((IntKeyframeSet)this.e);
  }

  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, int[] paramArrayOfInt)
  {
    super(paramString, null);
    a(paramArrayOfInt);
  }

  void a(float paramFloat)
  {
    this.i = this.h.b(paramFloat);
  }

  void a(Class paramClass)
  {
    if (this.b != null);
    while (true)
    {
      return;
      super.a(paramClass);
    }
  }

  public void a(int[] paramArrayOfInt)
  {
    super.a(paramArrayOfInt);
    this.h = ((IntKeyframeSet)this.e);
  }

  void b(Object paramObject)
  {
    if (this.j != null)
      this.j.a(paramObject, this.i);
    while (true)
    {
      return;
      if (this.b != null)
        this.b.a(paramObject, Integer.valueOf(this.i));
      else if (this.c != null)
        try
        {
          this.g[0] = Integer.valueOf(this.i);
          this.c.invoke(paramObject, this.g);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
        }
    }
  }

  Object d()
  {
    return Integer.valueOf(this.i);
  }

  public IntPropertyValuesHolder e()
  {
    IntPropertyValuesHolder localIntPropertyValuesHolder = (IntPropertyValuesHolder)super.a();
    localIntPropertyValuesHolder.h = ((IntKeyframeSet)localIntPropertyValuesHolder.e);
    return localIntPropertyValuesHolder;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder
 * JD-Core Version:    0.6.2
 */