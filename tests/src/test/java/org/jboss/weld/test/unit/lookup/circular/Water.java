package org.jboss.weld.test.unit.lookup.circular;

import javax.inject.Inject;

class Water
{
   @Inject
   public Water(Fish fish)
   {
   }
   
}