package com.facebook.common.json.jsonmirror.types;

import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMDictDestination;
import com.facebook.common.json.jsonmirror.JMDynamicKeysDictDestination;
import com.facebook.common.util.Tuple;
import com.facebook.debug.Assert;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class JMDynamicKeysDict extends JMDict
{
  private Class<?> g;
  private JMBase h;

  public JMDynamicKeysDict(Class<?> paramClass, boolean paramBoolean)
  {
    this.g = paramClass;
    this.h = JMAutogen.c(paramClass);
    if (paramBoolean)
    {
      this.g = List.class;
      HashSet localHashSet = new HashSet();
      localHashSet.add(this.h);
      this.h = new JMList(localHashSet);
    }
  }

  public Tuple<String, JMBase> a(String paramString)
  {
    return new Tuple(paramString, this.h);
  }

  public Map<String, Tuple<String, JMBase>> a()
  {
    throw new UnsupportedOperationException();
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, double paramDouble)
  {
    Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString, Double.valueOf(paramDouble));
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, long paramLong)
  {
    if (this.g.isInstance(Long.valueOf(paramLong)))
    {
      Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
      ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString, Long.valueOf(paramLong));
    }
  }

  public void a(JMDictDestination paramJMDictDestination1, String paramString, JMDictDestination paramJMDictDestination2)
  {
    Assert.b(paramJMDictDestination1 instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination1).a(paramString, paramJMDictDestination2);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString1, String paramString2)
  {
    Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString1, paramString2);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, List<Object> paramList)
  {
    Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString, paramList);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, Map<String, Object> paramMap)
  {
    Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString, paramMap);
  }

  public void a(JMDictDestination paramJMDictDestination, String paramString, boolean paramBoolean)
  {
    Assert.b(paramJMDictDestination instanceof JMDynamicKeysDictDestination);
    ((JMDynamicKeysDictDestination)paramJMDictDestination).a(paramString, Boolean.valueOf(paramBoolean));
  }

  public JMDictDestination b()
  {
    return new JMDynamicKeysDictDestination(this.g);
  }

  public boolean c()
  {
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMDynamicKeysDict
 * JD-Core Version:    0.6.0
 */