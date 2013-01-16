package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class PropertyValuesHolder$FloatPropertyValuesHolder extends PropertyValuesHolder
{
  FloatKeyframeSet h;
  float i;
  private FloatProperty j;

  public PropertyValuesHolder$FloatPropertyValuesHolder(Property paramProperty, float[] paramArrayOfFloat)
  {
    super(paramProperty, null);
    a(paramArrayOfFloat);
    if ((paramProperty instanceof FloatProperty))
      this.j = ((FloatProperty)this.b);
  }

  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, FloatKeyframeSet paramFloatKeyframeSet)
  {
    super(paramString, null);
    this.d = Float.TYPE;
    this.e = paramFloatKeyframeSet;
    this.h = ((FloatKeyframeSet)this.e);
  }

  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString, null);
    a(paramArrayOfFloat);
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

  public void a(float[] paramArrayOfFloat)
  {
    super.a(paramArrayOfFloat);
    this.h = ((FloatKeyframeSet)this.e);
  }

  void b(Object paramObject)
  {
    if (this.j != null)
      this.j.a(paramObject, this.i);
    while (true)
    {
      return;
      if (this.b != null)
        this.b.a(paramObject, Float.valueOf(this.i));
      else if (this.c != null)
        try
        {
          this.g[0] = Float.valueOf(this.i);
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
    return Float.valueOf(this.i);
  }

  public FloatPropertyValuesHolder e()
  {
    FloatPropertyValuesHolder localFloatPropertyValuesHolder = (FloatPropertyValuesHolder)super.a();
    localFloatPropertyValuesHolder.h = ((FloatKeyframeSet)localFloatPropertyValuesHolder.e);
    return localFloatPropertyValuesHolder;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder
 * JD-Core Version:    0.6.2
 */