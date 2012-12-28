/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.riot.system;

import org.apache.jena.atlas.lib.Tuple ;

import com.hp.hpl.jena.graph.Node ;
import com.hp.hpl.jena.graph.Triple ;
import com.hp.hpl.jena.sparql.core.Quad ;

public class SinkRDFWrapper implements SinkRDF
{
    protected final SinkRDF sink ;

    public SinkRDFWrapper(SinkRDF sink) { this.sink = sink ; }
    
    @Override
    public void start()
    { sink.start() ; }

    @Override
    public void triple(Triple triple)
    { sink.triple(triple) ; }

    @Override
    public void quad(Quad quad)
    { sink.quad(quad) ; }

    @Override
    public void tuple(Tuple<Node> tuple)
    { sink.tuple(tuple) ; }

    @Override
    public void base(String base)
    { sink.base(base) ; }

    @Override
    public void prefix(String prefix, String iri)
    { sink.prefix(prefix, iri) ; }

    @Override
    public void finish()
    { sink.finish() ; }
}