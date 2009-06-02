//  Gant -- A Groovy way of scripting Ant tasks.
//
//  Copyright © 2006-8 Russel Winder
//
//  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
//  compliance with the License. You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software distributed under the License is
//  distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
//  implied. See the License for the specific language governing permissions and limitations under the
//  License.

package org.codehaus.gant ;

import org.apache.tools.ant.Project ;

/**
 *  A class to hold the global shared state for a run of Gant.  This was originally needed because parts of
 *  Gant are written in Java and parts in Groovy and it was not possible to compile them all at the same
 *  time.  All references to Groovy classes had to be avoided in the Java classes so that the Java could be
 *  compiled and then the Groovy compiled.  This class contains things that should be in the
 *  <code>Gant</code> class but could not be.  All this is no longer true, so the material could go back
 *  into the <code>Gant</code> class.
 *
 *  @author Russel Winder <russel.winder@concertant.com>
 */
public class GantState {

  //  Use the representation of verbosity level from Project to avoid translations later.

  /**
   *  Output no information ever.
   */
  //  We have to know that the constants from Project are integer values starting at 0.
  public static final int SILENT = -1 ;
  /**
   *  Output only information about errors.
   */
  public static final int ERRORS_ONLY = Project.MSG_ERR ;
  /**
   *  Output only the meagrest of information.
   */
  public static final int WARNINGS_ERRORS = Project.MSG_WARN ;
  /**
   *  Output information about which task is executing, and other things.
   */
  public static final int NORMAL = Project.MSG_INFO ;
  /**
   *  Output lots of information about what is going on.
   */
  public static final int VERBOSE = Project.MSG_VERBOSE ;
  /**
   *  Output huge amounts of information about what is going on.
   */
  public static final int DEBUG = Project.MSG_DEBUG ;
  /**
   *  The current state of the verbosity of execution -- default is <code>NORMAL</code>.
   */
  public static int verbosity = NORMAL ;
  /**
   *  Whether this is a dry drun, i.e. no actual execution occur.
   */
  public static boolean dryRun = false ;
  /**
   *  We never want an instance of this class.
   */
  private GantState ( ) { }
}
