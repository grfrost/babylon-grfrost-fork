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

public interface mat4 {

    float _00();
    float _01();
    float _02();
    float _03();
    float _10();
    float _11();
    float _12();
    float _13();
    float _20();
    float _21();
    float _22();
    float _23();
    float _30();
    float _31();
    float _32();
    float _33();



    // A mutable variant needed for interface mapping
    interface Field extends mat4 {
        @Reflect
        default void schema(){
            _00();_01();_02();_03();
            _10();_11();_12();_13();
            _20();_21();_22();_23();
            _30();_31();_32();_33();
        }
        void _00(float _00);
        void _01(float _01);
        void _02(float _02);
        void _03(float _03);
        void _10(float _10);
        void _11(float _11);
        void _12(float _12);
        void _13(float _13);
        void _20(float _20);
        void _21(float _21);
        void _22(float _22);
        void _23(float _23);
        void _30(float _30);
        void _31(float _31);
        void _32(float _32);
        void _33(float _33);
    }

    static mat4 mat4(
            float _00, float _01, float _02, float _03,
            float _10, float _11, float _12, float _13,
            float _20, float _21, float _22, float _23,
            float _30, float _31, float _32, float _33
    ) {
        record Impl(
                float _00, float _01, float _02, float _03,
                float _10, float _11, float _12, float _13,
                float _20, float _21, float _22, float _23,
                float _30, float _31, float _32, float _33
                ) implements mat4 { }
        return new Impl(
                _00, _01,_02,_03,
                _10, _11, _12,_13,
                _20, _21, _22,_23,
                _30, _31, _32,_33
                );
    }
    static mat4 mat4(mat4 mat4) {return mat4(
            mat4._00(), mat4._01(), mat4._02(), mat4._03(),
            mat4._10(), mat4._11(), mat4._12(),mat4._13(),
            mat4._20(), mat4._21(), mat4._22(),mat4._23(),
            mat4._30(), mat4._31(), mat4._32(),mat4._33()
    );}
    static mat4 mat4(float scalar) {return mat4(
            scalar,scalar,scalar,scalar,
            scalar,scalar,scalar,scalar,
            scalar,scalar,scalar,scalar,
            scalar,scalar,scalar,scalar
            );}

    static mat4 add(mat4 l, mat4 r) {return mat4(
            l._00()+r._00(),l._01()+r._01(),l._02()+r._02(),l._03()+r._03(),
            l._10()+r._10(),l._11()+r._11(),l._12()+r._12(),l._13()+r._13(),
            l._20()+r._20(),l._21()+r._21(),l._22()+r._22(),l._13()+r._13(),
            l._30()+r._30(),l._31()+r._31(),l._32()+r._32(),l._33()+r._33()
    );}
    static mat4 sub(mat4 l, mat4 r) {return mat4(
            l._00()-r._00(),l._01()-r._01(),l._02()-r._02(),l._03()-r._03(),
            l._10()-r._10(),l._11()-r._11(),l._12()-r._12(),l._13()-r._13(),
            l._20()-r._20(),l._21()-r._21(),l._22()-r._22(),l._13()-r._13(),
            l._30()-r._30(),l._31()-r._31(),l._32()-r._32(),l._33()-r._33()
    );}
    static mat4 mul(mat4 l, mat4 r) {return mat4(
            l._00()*r._00(),l._01()*r._01(),l._02()*r._02(),l._03()*r._03(),
            l._10()*r._10(),l._11()*r._11(),l._12()*r._12(),l._13()*r._13(),
            l._20()*r._20(),l._21()*r._21(),l._22()*r._22(),l._13()*r._13(),
            l._30()*r._30(),l._31()*r._31(),l._32()*r._32(),l._33()*r._33()
    );}

    static mat4 div(mat4 l, mat4 r) {return mat4(
            l._00()/r._00(),l._01()/r._01(),l._02()/r._02(),l._03()/r._03(),
            l._10()/r._10(),l._11()/r._11(),l._12()/r._12(),l._13()/r._13(),
            l._20()/r._20(),l._21()/r._21(),l._22()/r._22(),l._13()/r._13(),
            l._30()/r._30(),l._31()/r._31(),l._32()/r._32(),l._33()/r._33()
    );}

    default mat4 add(mat4 rhs){return add(this,rhs);}
    default mat4 add(float scalar){return add(this,mat4(scalar));}
    default mat4 sub(float scalar) {return sub(this, mat4(scalar));}
    default mat4 sub(mat4 rhs){return sub(this,rhs);}
    default mat4 mul(float scalar) {return mul(this, mat4(scalar));}
    default mat4 mul(mat4 rhs){return mul(this,rhs);}
    default mat4 div(float scalar) {return div(this, mat4(scalar));}
    default mat4 div(mat4 rhs){return div(this,rhs);}

}
