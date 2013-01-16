package com.facebook.common.json.jsonmirror.types;

import com.facebook.common.json.jsonmirror.JMDictDestination;
import com.facebook.common.util.Tuple;
import java.util.List;
import java.util.Map;

public abstract class JMDict extends JMBase
{
  public abstract Tuple<String, JMBase> a(String paramString);

  public abstract Map<String, Tuple<String, JMBase>> a();

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString, double paramDouble);

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString, long paramLong);

  public abstract void a(JMDictDestination paramJMDictDestination1, String paramString, JMDictDestination paramJMDictDestination2);

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString1, String paramString2);

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString, List<Object> paramList);

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString, Map<String, Object> paramMap);

  public abstract void a(JMDictDestination paramJMDictDestination, String paramString, boolean paramBoolean);

  public abstract JMDictDestination b();

  public abstract boolean c();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.types.JMDict
 * JD-Core Version:    0.6.0
 */