/*****************************************************************************
 * Source code information
 * -----------------------
 * Original author    Ian Dickinson, HP Labs Bristol
 * Author email       Ian.Dickinson@hp.com
 * Package            Jena 2
 * Web                http://sourceforge.net/projects/jena/
 * Created            10 Feb 2003
 * Filename           $RCSfile: OntResource.java,v $
 * Revision           $Revision: 1.6 $
 * Release status     $State: Exp $
 *
 * Last modified on   $Date: 2003-05-08 14:46:25 $
 *               by   $Author: ian_dickinson $
 *
 * (c) Copyright 2002-2003, Hewlett-Packard Company, all rights reserved. 
 * (see footer for full conditions)
 * ****************************************************************************/

// Package
///////////////
package com.hp.hpl.jena.ontology;


// Imports
///////////////
import com.hp.hpl.jena.ontology.path.PathSet;
import com.hp.hpl.jena.rdf.model.*;

import java.util.Iterator;



/**
 * <p>
 * Provides a common super-type for all of the abstractions in this ontology
 * representation package. 
 * </p>
 *
 * @author Ian Dickinson, HP Labs
 *         (<a  href="mailto:Ian.Dickinson@hp.com" >email</a>)
 * @version CVS $Id: OntResource.java,v 1.6 2003-05-08 14:46:25 ian_dickinson Exp $
 */
public interface OntResource
    extends Resource
{
    // Constants
    //////////////////////////////////



    // External signature methods
    //////////////////////////////////

    /**
     * <p>
     * Answer the ontology language profile that governs the ontology model to which
     * this ontology resource is attached.  
     * </p>
     * 
     * @return The language profile for this ontology resource
     */
    public Profile getProfile();
    
    
    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>sameAs</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * <b>Note:</b> that any ontology resource can be declared to be the same as another. However,
     * in the case of OWL, doing so for class or property resources necessarily implies that
     * OWL Full is being used, since in OWL DL and Lite classes and properties cannot be used
     * as instances.
     * </p>
     * 
     * @return An abstract accessor for identity between individuals
     */
    public PathSet p_sameAs();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>sameIndidualAs</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * A synonym for {@link #p_sameAs sameAs}.
     * </p>
     * 
     * @return An abstract accessor for identity between individuals
     */
    public PathSet p_sameIndividualAs();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>differentFrom</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for asserting non-identity between individuals
     */
    public PathSet p_differentFrom();



    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>versionInfo</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the owl:versionInfo annotation property
     */
    public PathSet p_versionInfo();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>label</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the rdfs:label annotation property
     */
    public PathSet p_label();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>comment</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the rdfs:comment annotation property
     */
    public PathSet p_comment();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>seeAlso</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the rdfs:seeAlso annotation property
     */
    public PathSet p_seeAlso();


    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>isDefinedBy</code>
     * property of any instance. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the rdfs:isDefinedBy annotation property
     */
    public PathSet p_isDefinedBy();
    
    
    /**
     * <p>
     * Answer an {@link PathSet accessor} for the given
     * property of any ontology value. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @param p A property
     * @return An abstract accessor for the property p
     */
    public PathSet accessor( Property p );
    
    
    /**
     * <p>
     * Set the value of the given property of this ontology resource to the given
     * value, encoded as an RDFNode.  Maintains the invariant that there is
     * at most one value of the property for a given resource, so existing
     * property values are first removed.  To add multiple properties, use
     * {@link #addProperty( Property, RDFNode ) addProperty}.
     * </p>
     * 
     * @param property The property to update
     * @param value The new value of the property as an RDFNode, or null to
     *              effectively remove this property.
     */
    public void setPropertyValue( Property property, RDFNode value );


    /**
     * <p>
     * Remove any values for a given property from this resource.
     * </p>
     *
     * @param property The RDF resource that defines the property to be removed
     */
    public void removeAll( Property property );


    /**
     * <p>Set the RDF type property for this node in the underlying model, replacing any
     * existing <code>rdf:type</code> property.  
     * To add a second or subsequent type statement to a resource,
     * use {@link #setRDFType( Resource, boolean ) setRDFType( Resource, false ) }.
     * </p>
     * 
     * @param ontClass The RDF resource denoting the new value for the rdf:type property,
     *                 which will replace any existing type property.
     */
    public void setRDFType( Resource ontClass );


    /**
     * <p>
     * Add an RDF type property for this node in the underlying model. If the replace flag
     * is true, this type will replace any current type property for the node. Otherwise,
     * the type will be in addition to any existing type property.
     * </p>
     * 
     * @param ontClass The RDF resource denoting the class that will be the value 
     * for a new <code>rdf:type</code> property.
     * @param replace  If true, the given class will replace any existing 
     * <code>rdf:type</code> property for this
     *                 value, otherwise it will be added as an extra type statement.
     */
    public void setRDFType( Resource ontClass, boolean replace );


    /**
     * <p>
     * Answer true if this DAML value is a member of the class denoted by the given URI.
     * </p>
     *
     * @param classURI String denoting the URI of the class to test against
     * @return True if it can be shown that this DAML value is a member of the class, via
     *         <code>rdf:type</code>.
     */
    public boolean hasRDFType( String classURI );


    /**
     * <p>
     * Answer true if this ontology value is a member of the class denoted by the
     * given class resource.
     * </p>
     * 
     * @param ontClass Denotes a class to which this value may belong
     * @return True if <code><i>this</i> rdf:type <i>ontClass</i></code> is
     * a valid entailment in the model.
     */
    public boolean hasRDFType( Resource ontClass );


    /**
     * <p>
     * Answer an iterator over all of the RDF types to which this class belongs.
     * </p>
     *
     * @param closed TODO Not used in the current implementation  - fix
     * @return an iterator over the set of this ressource's classes
     */
    public Iterator getRDFTypes( boolean closed );


    // Conversion methods
    
    /** 
     * <p>Answer a view of this resource as an annotation property</p>
     * @return This resource, but viewed as an AnnotationProperty
     * @exception ConversionException if the resource cannot be converted to an annotation property
     */
    public AnnotationProperty asAnnotationProperty();
    
    /** 
     * <p>Answer a view of this resource as a list </p>
     * @return This resource, but viewed as an OntList
     * @exception ConversionException if the resource cannot be converted to a list
     */
    public OntList asList();
    
    /** 
     * <p>Answer a view of this resource as a property</p>
     * @return This resource, but viewed as an OntProperty
     * @exception ConversionException if the resource cannot be converted to a property
     */
    public OntProperty asProperty();
    
    /** 
     * <p>Answer a view of this resource as an individual</p>
     * @return This resource, but viewed as an Individual
     * @exception ConversionException if the resource cannot be converted to an individual
     */
    public Individual asIndividual();
    
    /** 
     * <p>Answer a view of this resource as a class</p>
     * @return This resource, but viewed as an OntClass
     * @exception ConversionException if the resource cannot be converted to a class
     */
    public OntClass asClass();
    
    /** 
     * <p>Answer a view of this resource as an ontology description node</p>
     * @return This resource, but viewed as an Ontology
     * @exception ConversionException if the resource cannot be converted to an ontology description node
     */
    public Ontology asOntology();
    
    /** 
     * <p>Answer a view of this resource as an 'all different' declaration</p>
     * @return This resource, but viewed as an AllDifferent node
     * @exception ConversionException if the resource cannot be converted to an all different declaration
     */
    public AllDifferent asAllDifferent();


}


/*
    (c) Copyright Hewlett-Packard Company 2002-2003
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
