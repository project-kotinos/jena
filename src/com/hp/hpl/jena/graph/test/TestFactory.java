/*
  (c) Copyright 2003, Hewlett-Packard Company, all rights reserved.
  [See end of file]
  $Id: TestFactory.java,v 1.3 2003-05-01 15:36:54 chris-dollin Exp $
*/

package com.hp.hpl.jena.graph.test;

/**
 	@author kers
*/

import com.hp.hpl.jena.graph.*;
import com.hp.hpl.jena.db.*;

import junit.framework.*;

public class TestFactory extends GraphTestBase
    {
    public TestFactory( String name )
        { super( name ); };
        
    public static TestSuite suite()
        { return new TestSuite( TestFactory.class ); }   

    public void tearDown()
        {
//        destroy( "xxx" );
//        destroy( "alpha" );
        }
        
    private void destroy( String name )
        {
        try
            {
            GraphRDB g = (GraphRDB) Factory.openPersistentGraph( name );
            if (g != null) { g.remove(); g.close(); }
            }
        catch (Exception e)
            { System.err.println( "oops: " + e ); }
        }
        
    public void testFactory()
        {
        Graph g = Factory.createDefaultGraph();
        }
        
    public void testCreatePersistentGraph()
        {
//        Graph g = Factory.createPersistentGraph( "xxx" );
//        ((GraphRDB) g).remove();
//        g.close();
        }
        
    public void testOpenPersistentGraph()
        {
//        Graph g = Factory.openPersistentGraph( "xxx" );
//        g.close();
        }
        
    public void testPersistent()
        {
//        Graph triples = graphWith( "x R y" );
//        Graph g = Factory.createPersistentGraph( "alpha" );
//        g.getBulkUpdateHandler().add( triples );
//        g.close();
//        Graph g2 = Factory.openPersistentGraph( "alpha" );
//        assertTrue( "should retrieve triples", triples.isIsomorphicWith( g2 ) );
//        ((GraphRDB) g2).remove();
//        g2.close();
        }
    }


/*
    (c) Copyright Hewlett-Packard Company 2003
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
       notice, this list of conditions and the following disclaimer.

    2. Redistributions in binary form must reproduce the above copyright
       notice, this list of conditions and the following disclaimer in the
       documentation and/or other materials provided with the distribution.

    3. The name of the author may not be used to endorse or promote products
       derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/