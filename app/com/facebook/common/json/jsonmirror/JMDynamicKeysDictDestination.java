package com.facebook.common.json.jsonmirror;

import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JMDynamicKeysDictDestination
  implements JMDictDestination, Serializable, Map<String, Object>
{
  private static final long serialVersionUID = 7808991728060925620L;
  private HashMap<String, Object> mMap = Maps.a();
  private Class<?> mValueType;

  public JMDynamicKeysDictDestination(Class<?> paramClass)
  {
    this.mValueType = paramClass;
  }

  public Object a(String paramString, Object paramObject)
  {
    return this.mMap.put(paramString, paramObject);
  }

  public void clear()
  {
    this.mMap.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.mMap.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.mMap.containsValue(paramObject);
  }

  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.mMap.entrySet();
  }

  public Object get(Object paramObject)
  {
    return this.mMap.get(paramObject);
  }

  public int hashCode()
  {
    return this.mMap.hashCode();
  }

  public boolean isEmpty()
  {
    return this.mMap.isEmpty();
  }

  public Set<String> keySet()
  {
    return this.mMap.keySet();
  }

  public void putAll(Map<? extends String, ?> paramMap)
  {
    this.mMap.putAll(paramMap);
  }

  public Object remove(Object paramObject)
  {
    return this.mMap.remove(paramObject);
  }

  public int size()
  {
    return this.mMap.size();
  }

  public String toString()
  {
    return "JMDynamicKeysDict" + this.mMap.toString();
  }

  public Collection<Object> values()
  {
    return this.mMap.values();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.json.jsonmirror.JMDynamicKeysDictDestination
 * JD-Core Version:    0.6.0
 */