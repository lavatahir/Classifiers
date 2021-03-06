/*
 * (C) Copyright 2016-2017, by micha and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
package org.jgrapht.experimental.alg;

import java.util.*;

import org.jgrapht.*;

/**
 * 
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 * 
 * @author micha
 * 
 */
public abstract class IntArrayGraphAlgorithm<V, E>
{
    protected final List<V> _vertices;
    protected final int[][] _neighbors;
    protected final Map<V, Integer> _vertexToPos;

    /**
     * Create a new instance.
     * 
     * @param g the input graph
     */
    public IntArrayGraphAlgorithm(final Graph<V, E> g)
    {
        final int numVertices = g.vertexSet().size();
        _vertices = new ArrayList<>(numVertices);
        _neighbors = new int[numVertices][];
        _vertexToPos = new HashMap<>(numVertices);
        for (V vertex : g.vertexSet()) {
            _neighbors[_vertices.size()] = new int[g.edgesOf(vertex).size()];
            _vertexToPos.put(vertex, _vertices.size());
            _vertices.add(vertex);
        }
        for (int i = 0; i < numVertices; i++) {
            int nbIndex = 0;
            final V vertex = _vertices.get(i);
            for (E e : g.edgesOf(vertex)) {
                _neighbors[i][nbIndex++] = _vertexToPos.get(Graphs.getOppositeVertex(g, e, vertex));
            }
        }
    }
}

// End IntArrayGraphAlgorithm.java
