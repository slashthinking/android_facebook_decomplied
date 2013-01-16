package com.google.common.collect;

final class RegularImmutableMap$NonTerminalEntry<K, V> extends ImmutableEntry<K, V>
  implements RegularImmutableMap.LinkedEntry<K, V>
{
  final RegularImmutableMap.LinkedEntry<K, V> next;

  RegularImmutableMap$NonTerminalEntry(K paramK, V paramV, RegularImmutableMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    super(paramK, paramV);
    this.next = paramLinkedEntry;
  }

  public RegularImmutableMap.LinkedEntry<K, V> a()
  {
    return this.next;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap.NonTerminalEntry
 * JD-Core Version:    0.6.2
 */