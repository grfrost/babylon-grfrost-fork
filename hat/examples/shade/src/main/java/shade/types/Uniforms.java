/*
 * Copyright (c) 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package shade.types;

import jdk.incubator.code.Reflect;
import optkl.ifacemapper.BoundSchema;
import optkl.ifacemapper.Buffer;
import optkl.ifacemapper.Schema;
import optkl.util.carriers.ArenaAndLookupCarrier;

public interface Uniforms extends Buffer {


    // A mutable form needed for interface mapping.
    interface ivec2Field extends ivec2,Struct {
        @Reflect
        default void schema(){x();y();}
        void x(int x);
        void y(int y);
        default ivec2 of(int x, int y){
            x(x);y(y);
            return this;
        }
        default ivec2 of(ivec2 ivec2){
            return of(ivec2.x(),ivec2.y());
        }
    }


    // A mutable form needed for interface mapping.
    interface vec2Field extends vec2, Struct  {
        @Reflect
        default void schema(){x();y();}
        void x(float x);
        void y(float y);
        default vec2 of(float x, float y){
            x(x);y(y);
            return this;
        }
        default vec2 of(vec2 vec2){
            return of(vec2.x(),vec2.y());
        }
    }


    // A mutable variant needed for interface mapping
    interface vec3Field extends vec3, Struct {
        @Reflect
        default void schema(){x();y();z();}
        void x(float x);
        void y(float y);
        void z(float z);
        default vec3 of(float x, float y, float z){
            x(x);y(y);z(z);
            return this;
        }
        default vec3 of(vec3 vec3){
            return of(vec3.x(),vec3.y(),vec3.z());
        }
    }




    // A mutable variant needed for interface mapping
    interface vec4Field extends vec4, Struct {
        @Reflect
        default void schema(){x();y();z();w();}
        void x(float x);
        void y(float y);
        void z(float z);
        void w(float w);
        default vec4 of(float x, float y, float z, float w){
            x(x);y(y);z(z);w(w);
            return this;
        }
        default vec4 of(vec4 vec4){
            return of(vec4.x(),vec4.y(),vec4.z(),vec4.w());
        }
    }


    vec2Field fragCoord();

    vec4Field fragColor();

    ivec2Field iResolution();

    long iTime();
    void iTime(long iTime);
    ivec2Field iMouse();
    long iFrame();
    void iFrame(long iFrame);
    Schema<Uniforms> schema = Schema.of(Uniforms.class, uniforms -> uniforms
            .field("fragCoord", fragCoord -> fragCoord.fields("x", "y"))
            .field("fragColor", fragColor -> fragColor.fields("x", "y", "z", "w"))
            .field("iResolution", iResolution -> iResolution.fields("x", "y"))
            .field("iMouse", iMouse -> iMouse.fields("x", "y"))
            .field("iTime")
            .field("iFrame")
    );

    static Uniforms create(ArenaAndLookupCarrier arenaAndLookupCarrier) {
        return BoundSchema.of(arenaAndLookupCarrier, schema).allocate();
    }
}
