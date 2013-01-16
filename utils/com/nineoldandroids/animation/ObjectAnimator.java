package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator
{
  private static final Map<String, Property> h = new HashMap();
  private Object i;
  private String j;
  private Property k;

  static
  {
    h.put("alpha", PreHoneycombCompat.a);
    h.put("pivotX", PreHoneycombCompat.b);
    h.put("pivotY", PreHoneycombCompat.c);
    h.put("translationX", PreHoneycombCompat.d);
    h.put("translationY", PreHoneycombCompat.e);
    h.put("rotation", PreHoneycombCompat.f);
    h.put("rotationX", PreHoneycombCompat.g);
    h.put("rotationY", PreHoneycombCompat.h);
    h.put("scaleX", PreHoneycombCompat.i);
    h.put("scaleY", PreHoneycombCompat.j);
    h.put("scrollX", PreHoneycombCompat.k);
    h.put("scrollY", PreHoneycombCompat.l);
    h.put("x", PreHoneycombCompat.m);
    h.put("y", PreHoneycombCompat.n);
  }

  public ObjectAnimator()
  {
  }

  private ObjectAnimator(Object paramObject, String paramString)
  {
    this.i = paramObject;
    a(paramString);
  }

  public static ObjectAnimator a(Object paramObject, String paramString, float[] paramArrayOfFloat)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator(paramObject, paramString);
    localObjectAnimator.a(paramArrayOfFloat);
    return localObjectAnimator;
  }

  public static ObjectAnimator a(Object paramObject, PropertyValuesHolder[] paramArrayOfPropertyValuesHolder)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.i = paramObject;
    localObjectAnimator.a(paramArrayOfPropertyValuesHolder);
    return localObjectAnimator;
  }

  public String a()
  {
    return this.j;
  }

  void a(float paramFloat)
  {
    super.a(paramFloat);
    int m = this.f.length;
    for (int n = 0; n < m; n++)
      this.f[n].b(this.i);
  }

  public void a(Property paramProperty)
  {
    if (this.f != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.f[0];
      String str = localPropertyValuesHolder.c();
      localPropertyValuesHolder.a(paramProperty);
      this.g.remove(str);
      this.g.put(this.j, localPropertyValuesHolder);
    }
    if (this.k != null)
      this.j = paramProperty.a();
    this.k = paramProperty;
    this.e = false;
  }

  public void a(Object paramObject)
  {
    if (this.i != paramObject)
    {
      Object localObject = this.i;
      this.i = paramObject;
      if ((localObject == null) || (paramObject == null) || (localObject.getClass() != paramObject.getClass()))
        break label38;
    }
    while (true)
    {
      return;
      label38: this.e = false;
    }
  }

  public void a(String paramString)
  {
    if (this.f != null)
    {
      PropertyValuesHolder localPropertyValuesHolder = this.f[0];
      String str = localPropertyValuesHolder.c();
      localPropertyValuesHolder.a(paramString);
      this.g.remove(str);
      this.g.put(paramString, localPropertyValuesHolder);
    }
    this.j = paramString;
    this.e = false;
  }

  public void a(float[] paramArrayOfFloat)
  {
    if ((this.f == null) || (this.f.length == 0))
      if (this.k != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.a(this.k, paramArrayOfFloat);
        a(arrayOfPropertyValuesHolder2);
      }
    while (true)
    {
      return;
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.a(this.j, paramArrayOfFloat);
      a(arrayOfPropertyValuesHolder1);
      continue;
      super.a(paramArrayOfFloat);
    }
  }

  public void a(int[] paramArrayOfInt)
  {
    if ((this.f == null) || (this.f.length == 0))
      if (this.k != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.a(this.k, paramArrayOfInt);
        a(arrayOfPropertyValuesHolder2);
      }
    while (true)
    {
      return;
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.a(this.j, paramArrayOfInt);
      a(arrayOfPropertyValuesHolder1);
      continue;
      super.a(paramArrayOfInt);
    }
  }

  public void a(Object[] paramArrayOfObject)
  {
    if ((this.f == null) || (this.f.length == 0))
      if (this.k != null)
      {
        PropertyValuesHolder[] arrayOfPropertyValuesHolder2 = new PropertyValuesHolder[1];
        arrayOfPropertyValuesHolder2[0] = PropertyValuesHolder.a(this.k, (TypeEvaluator)null, paramArrayOfObject);
        a(arrayOfPropertyValuesHolder2);
      }
    while (true)
    {
      return;
      PropertyValuesHolder[] arrayOfPropertyValuesHolder1 = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder1[0] = PropertyValuesHolder.a(this.j, (TypeEvaluator)null, paramArrayOfObject);
      a(arrayOfPropertyValuesHolder1);
      continue;
      super.a(paramArrayOfObject);
    }
  }

  public void c()
  {
    super.c();
  }

  void c_()
  {
    if (!this.e)
    {
      if ((this.k == null) && (AnimatorProxy.a) && ((this.i instanceof View)) && (h.containsKey(this.j)))
        a((Property)h.get(this.j));
      int m = this.f.length;
      for (int n = 0; n < m; n++)
        this.f[n].a(this.i);
      super.c_();
    }
  }

  public ObjectAnimator d(long paramLong)
  {
    super.b(paramLong);
    return this;
  }

  public Object h()
  {
    return this.i;
  }

  public ObjectAnimator m()
  {
    return (ObjectAnimator)super.i();
  }

  public String toString()
  {
    String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
    if (this.f != null)
      for (int m = 0; m < this.f.length; m++)
        str = str + "\n    " + this.f[m].toString();
    return str;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.ObjectAnimator
 * JD-Core Version:    0.6.2
 */