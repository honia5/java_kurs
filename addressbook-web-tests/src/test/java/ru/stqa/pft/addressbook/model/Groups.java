package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HoncaRo on 2017-11-21.
 */
public class Groups extends ForwardingSet<GroupDate> {

  private Set<GroupDate> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupDate>(groups.delegate);

  }
  public Groups(){
    this.delegate = new HashSet<GroupDate>();
  }

  @Override
  protected Set<GroupDate> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupDate group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }
  public Groups without(GroupDate group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }
}
