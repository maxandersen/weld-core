/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.weld.context;

import org.jboss.weld.exceptions.WeldExceptionKeyMessage;
import org.jboss.weld.exceptions.WeldExceptionMessage;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * A localized message version of the
 * {@link javax.enterprise.context.NonexistentConversationException}.
 * 
 * @author David Allen
 */
@SuppressWarnings(value="NM_SAME_SIMPLE_NAME_AS_SUPERCLASS", justification="Workaround for exception classes poor i8ln support")
public class BusyConversationException extends javax.enterprise.context.BusyConversationException
{

   private static final long    serialVersionUID = 2L;

   private WeldExceptionMessage message;

   public BusyConversationException(Throwable throwable)
   {
      super(throwable.getLocalizedMessage(), throwable);
   }

   public <E extends Enum<?>> BusyConversationException(E key, Object... args)
   {
      message = new WeldExceptionKeyMessage(key, args);
   }

   @Override
   public String getLocalizedMessage()
   {
      return getMessage();
   }

   @Override
   public String getMessage()
   {
      return message.getAsString();
   }
}
