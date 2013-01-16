package com.facebook.orca.inject;

import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes.ParameterizedTypeImpl;
import java.lang.reflect.Type;
import java.util.Set;
import javax.inject.Provider;

public class MultiBinder<T>
{
  private final FbInjector a;
  private final Key<T> b;
  private final Set<Key<? extends T>> c;

  public MultiBinder(FbInjector paramFbInjector, Key<T> paramKey)
  {
    this.a = paramFbInjector;
    this.b = paramKey;
    this.c = Sets.b();
  }

  Provider<Set<T>> a()
  {
    return new MultiBinder.1(this);
  }

  public void a(Key<? extends T> paramKey)
  {
    this.c.add(paramKey);
  }

  Key<? extends T> b()
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = this.b.a().b();
    MoreTypes.ParameterizedTypeImpl localParameterizedTypeImpl = new MoreTypes.ParameterizedTypeImpl(null, Set.class, arrayOfType);
    Key localKey;
    if (this.b.c() != null)
      localKey = Key.a(localParameterizedTypeImpl, this.b.c());
    while (true)
    {
      return localKey;
      if (this.b.b() != null)
      {
        localKey = Key.a(localParameterizedTypeImpl, this.b.b());
        continue;
      }
      localKey = Key.a(localParameterizedTypeImpl);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.MultiBinder
 * JD-Core Version:    0.6.0
 */