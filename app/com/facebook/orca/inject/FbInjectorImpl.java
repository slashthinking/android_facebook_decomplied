package com.facebook.orca.inject;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;

public class FbInjectorImpl extends AbstractInjector
{
  private final Map<Key, Provider> a = Maps.a();
  private final Map<Key, Provider> b = Maps.a();
  private final Map<Key, MultiBinder> c = Maps.a();
  private final Map<Key, Provider> d = new MapMaker().n();
  private final Set<Key> e = Sets.a();
  private final Set<Key> f = Sets.a();
  private final Set<Key> g = Sets.a();
  private final Multimap<Module, Class<? extends Module>> h = HashMultimap.m();
  private final Set<Module> i = Sets.a();
  private final Set<Class<? extends Module>> j = Sets.a();
  private final FbInjectorImpl.LessEagerUiThreadSingletonInitializer k;
  private final Map<Class<? extends Annotation>, Scope> l = Maps.a();
  private boolean m;

  FbInjectorImpl(List<? extends Module> paramList, boolean paramBoolean)
  {
    Tracer localTracer1 = Tracer.a("FbInjectorImpl.init");
    this.l.put(Singleton.class, SingletonScope.get());
    this.l.put(ThreadLocalScoped.class, ThreadLocalScope.get());
    this.k = new FbInjectorImpl.LessEagerUiThreadSingletonInitializer(this);
    Tracer localTracer2 = Tracer.a("FbInjectorImpl.init#modules");
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
      a((Module)localIterator1.next());
    localTracer2.a();
    c();
    Iterator localIterator2 = this.g.iterator();
    while (localIterator2.hasNext())
    {
      Key localKey2 = (Key)localIterator2.next();
      if (this.b.containsKey(localKey2))
        continue;
      throw new RuntimeException("No binding for required key " + localKey2);
    }
    this.g.clear();
    Iterator localIterator3 = this.h.i().iterator();
    while (localIterator3.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator3.next();
      Module localModule = (Module)localEntry.getKey();
      Class localClass = (Class)localEntry.getValue();
      if (this.j.contains(localClass))
        continue;
      throw new RuntimeException("Module " + localClass + " is required by " + localModule.getClass() + " but was not installed");
    }
    this.h.f();
    this.m = true;
    Iterator localIterator4 = this.i.iterator();
    while (localIterator4.hasNext())
      ((Module)localIterator4.next()).a(this);
    this.i.clear();
    if (paramBoolean)
    {
      Tracer localTracer3 = Tracer.a("FbInjectorImpl.init#eagerSingletons");
      Iterator localIterator5 = this.e.iterator();
      while (localIterator5.hasNext())
      {
        Key localKey1 = (Key)localIterator5.next();
        Tracer localTracer4 = Tracer.a("Key: " + localKey1);
        a(localKey1);
        localTracer4.a();
      }
      this.e.clear();
      localTracer3.a();
    }
    localTracer1.a();
  }

  private void a(Module paramModule)
  {
    BinderImpl localBinderImpl = new BinderImpl();
    paramModule.a(localBinderImpl);
    this.i.add(paramModule);
    this.j.add(paramModule.getClass());
    Iterator localIterator1 = localBinderImpl.f().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      this.l.put(localEntry2.getKey(), localEntry2.getValue());
    }
    Iterator localIterator2 = localBinderImpl.e().iterator();
    while (localIterator2.hasNext())
    {
      Module localModule = (Module)localIterator2.next();
      Tracer localTracer = Tracer.a("Module " + localModule.getClass());
      a(localModule);
      localTracer.a();
    }
    Iterator localIterator3 = localBinderImpl.a().iterator();
    while (localIterator3.hasNext())
    {
      Binding localBinding = (Binding)localIterator3.next();
      Key localKey2 = localBinding.a();
      Provider localProvider = localBinding.b();
      if ((localProvider instanceof ProviderWithInjector))
        ((ProviderWithInjector)localProvider).a(this);
      if (localBinding.c() != null)
        localProvider = e(localBinding.c()).a(localProvider);
      if (localBinding.h())
        this.a.put(localKey2, new ProvisioningDebugStackProvider(localKey2, localProvider));
      while (true)
      {
        if (!localBinding.d())
          break label359;
        this.e.add(localKey2);
        break;
        this.b.put(localKey2, new ProvisioningDebugStackProvider(localKey2, localProvider));
      }
      label359: if (!localBinding.f())
        continue;
      this.f.add(localKey2);
    }
    Iterator localIterator4 = localBinderImpl.b().entrySet().iterator();
    while (localIterator4.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator4.next();
      Key localKey1 = (Key)localEntry1.getKey();
      MultiBinding localMultiBinding = (MultiBinding)localEntry1.getValue();
      MultiBinder localMultiBinder = (MultiBinder)this.c.get(localKey1);
      if (localMultiBinder == null)
      {
        localMultiBinder = new MultiBinder(this, localKey1);
        this.c.put(localKey1, localMultiBinder);
      }
      Iterator localIterator5 = localMultiBinding.a().iterator();
      while (localIterator5.hasNext())
        localMultiBinder.a((Key)localIterator5.next());
    }
    this.g.addAll(localBinderImpl.c());
    this.h.a(paramModule, localBinderImpl.d());
  }

  private void b()
  {
    if (!this.m)
      throw new RuntimeException("Called injector during binding");
  }

  private <T> Provider<T> c(Key<T> paramKey)
  {
    FbInjectorImpl.1 local1;
    if ((paramKey.c() != null) || (paramKey.b() != null))
      local1 = null;
    while (true)
    {
      return local1;
      Type localType = paramKey.a().b();
      if (((localType instanceof GenericArrayType)) || ((localType instanceof ParameterizedType)) || ((localType instanceof WildcardType)) || ((localType instanceof TypeVariable)))
      {
        local1 = null;
        continue;
      }
      Class localClass = paramKey.a().a();
      try
      {
        Constructor localConstructor = localClass.getConstructor(new Class[0]);
        if (localConstructor == null)
          break label132;
        BLog.c("OrcaInjector", "Created just-in-time provider for " + localClass);
        local1 = new FbInjectorImpl.1(this, localConstructor);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        local1 = null;
      }
      continue;
      label132: local1 = null;
    }
  }

  private void c()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      MultiBinder localMultiBinder = (MultiBinder)localIterator.next();
      this.b.put(localMultiBinder.b(), localMultiBinder.a());
    }
  }

  private Scope e(Class<? extends Annotation> paramClass)
  {
    Scope localScope = (Scope)this.l.get(paramClass);
    if (localScope == null)
      throw new ProvisioningException("No scope registered for " + paramClass);
    return localScope;
  }

  public FbInjectorImpl.LessEagerUiThreadSingletonInitializer a()
  {
    return this.k;
  }

  public <T> Provider<T> b(Key<T> paramKey)
  {
    b();
    ProvisioningDebugStack.a(ProvisioningDebugStack.StackType.PROVIDER_GET, paramKey);
    Provider localProvider;
    try
    {
      localProvider = (Provider)this.b.get(paramKey);
      if (localProvider == null)
      {
        localProvider = (Provider)this.a.get(paramKey);
        if (localProvider == null)
        {
          localProvider = (Provider)this.d.get(paramKey);
          if (localProvider == null)
          {
            localProvider = c(paramKey);
            if (localProvider != null)
              this.d.put(paramKey, localProvider);
          }
        }
      }
      if (localProvider == null)
        throw new ProvisioningException("No provider bound for " + paramKey);
    }
    finally
    {
      ProvisioningDebugStack.a();
    }
    ProvisioningDebugStack.a();
    return localProvider;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.FbInjectorImpl
 * JD-Core Version:    0.6.0
 */