/*
 * Copyright (C) 2014 David Verhaak <david@forcez.nl>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.atlas.games;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 * @since 0.2
 */
public class Matrix
{

	/**
	 * @since 0.2
	 */
	public float m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33, m40, m41, m42, m43;

	/**
	 *
	 * @since 0.2
	 */
	public Matrix()
	{
		this(1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
	}

	/**
	 *
	 * @param m10
	 * @param m11
	 * @param m12
	 * @param m13
	 * @param m20
	 * @param m21
	 * @param m22
	 * @param m23
	 * @param m30
	 * @param m31
	 * @param m32
	 * @param m33
	 * @param m40
	 * @param m41
	 * @param m42
	 * @param m43
	 * @since 0.2
	 */
	public Matrix(float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33, float m40, float m41, float m42, float m43)
	{
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		this.m40 = m40;
		this.m41 = m41;
		this.m42 = m42;
		this.m43 = m43;
	}

	/**
	 *
	 * @param matrix
	 * @since 0.2
	 */
	public void load(Matrix matrix)
	{
		this.m10 = matrix.m10;
		this.m11 = matrix.m11;
		this.m12 = matrix.m12;
		this.m13 = matrix.m13;
		this.m20 = matrix.m20;
		this.m21 = matrix.m21;
		this.m22 = matrix.m22;
		this.m23 = matrix.m23;
		this.m30 = matrix.m30;
		this.m31 = matrix.m31;
		this.m32 = matrix.m32;
		this.m33 = matrix.m33;
		this.m40 = matrix.m40;
		this.m41 = matrix.m41;
		this.m42 = matrix.m42;
		this.m43 = matrix.m10;
	}

	/**
	 *
	 * @param other
	 * @since 0.2
	 */
	public void add(Matrix other)
	{
		this.m10 += other.m10;
		this.m11 += other.m11;
		this.m12 += other.m12;
		this.m13 += other.m13;
		this.m20 += other.m20;
		this.m21 += other.m21;
		this.m22 += other.m22;
		this.m23 += other.m23;
		this.m30 += other.m30;
		this.m31 += other.m31;
		this.m32 += other.m32;
		this.m33 += other.m33;
		this.m40 += other.m40;
		this.m41 += other.m41;
		this.m42 += other.m42;
		this.m43 += other.m43;
	}

	/**
	 *
	 * @param other
	 * @since 0.2
	 */
	public void substract(Matrix other)
	{
		this.m10 -= other.m10;
		this.m11 -= other.m11;
		this.m12 -= other.m12;
		this.m13 -= other.m13;
		this.m20 -= other.m20;
		this.m21 -= other.m21;
		this.m22 -= other.m22;
		this.m23 -= other.m23;
		this.m30 -= other.m30;
		this.m31 -= other.m31;
		this.m32 -= other.m32;
		this.m33 -= other.m33;
		this.m40 -= other.m40;
		this.m41 -= other.m41;
		this.m42 -= other.m42;
		this.m43 -= other.m43;
	}

	/**
	 *
	 * @param other
	 * @since 0.2
	 */
	public void multiply(Matrix other)
	{
		float mu10 = this.m10 * other.m10 + this.m20 * other.m11 + this.m30 * other.m12 + this.m40 * other.m13;
		float mu11 = this.m11 * other.m10 + this.m21 * other.m11 + this.m31 * other.m12 + this.m41 * other.m13;
		float mu12 = this.m12 * other.m10 + this.m22 * other.m11 + this.m32 * other.m12 + this.m42 * other.m13;
		float mu13 = this.m13 * other.m10 + this.m23 * other.m11 + this.m33 * other.m12 + this.m43 * other.m13;
		float mu20 = this.m10 * other.m20 + this.m20 * other.m21 + this.m30 * other.m22 + this.m40 * other.m23;
		float mu21 = this.m11 * other.m20 + this.m21 * other.m21 + this.m31 * other.m22 + this.m41 * other.m23;
		float mu22 = this.m12 * other.m20 + this.m22 * other.m21 + this.m32 * other.m22 + this.m42 * other.m23;
		float mu23 = this.m13 * other.m20 + this.m23 * other.m21 + this.m33 * other.m22 + this.m43 * other.m23;
		float mu30 = this.m10 * other.m30 + this.m20 * other.m31 + this.m30 * other.m32 + this.m40 * other.m33;
		float mu31 = this.m11 * other.m30 + this.m21 * other.m31 + this.m31 * other.m32 + this.m41 * other.m33;
		float mu32 = this.m12 * other.m30 + this.m22 * other.m31 + this.m32 * other.m32 + this.m42 * other.m33;
		float mu33 = this.m13 * other.m30 + this.m23 * other.m31 + this.m33 * other.m32 + this.m43 * other.m33;
		float mu40 = this.m10 * other.m41 + this.m20 * other.m41 + this.m30 * other.m42 + this.m40 * other.m43;
		float mu41 = this.m11 * other.m41 + this.m21 * other.m41 + this.m31 * other.m42 + this.m41 * other.m43;
		float mu42 = this.m12 * other.m41 + this.m22 * other.m41 + this.m32 * other.m42 + this.m42 * other.m43;
		float mu43 = this.m13 * other.m41 + this.m23 * other.m41 + this.m33 * other.m42 + this.m43 * other.m43;
		this.load(new Matrix(mu10, mu11, mu12, mu13, mu20, mu21, mu22, mu23, mu30, mu31, mu32, mu33, mu40, mu41, mu42, mu43));
	}

	/**
	 *
	 * @param vector
	 * @since 0.2
	 */
	public void scale(Vector3 vector)
	{
		Matrix matrix = new Matrix();
		matrix.m10 = this.m10 * vector.x;
		matrix.m11 = this.m11 * vector.x;
		matrix.m12 = this.m12 * vector.x;
		matrix.m13 = this.m13 * vector.x;
		matrix.m20 = this.m20 * vector.y;
		matrix.m21 = this.m21 * vector.y;
		matrix.m22 = this.m22 * vector.y;
		matrix.m23 = this.m23 * vector.y;
		matrix.m30 = this.m30 * vector.z;
		matrix.m31 = this.m31 * vector.z;
		matrix.m32 = this.m32 * vector.z;
		matrix.m33 = this.m33 * vector.z;
		this.load(matrix);
	}

	/**
	 *
	 * @param angle
	 * @param axis
	 * @since 0.2
	 */
	public void rotate(float angle, Vector3 axis)
	{
		Matrix matrix = new Matrix();
		float c = (float) Math.cos(angle);
		float s = (float) Math.sin(angle);
		float oneminusc = 1.0f - c;
		float xy = axis.x * axis.y;
		float yz = axis.y * axis.z;
		float xz = axis.x * axis.z;
		float xs = axis.x * s;
		float ys = axis.y * s;
		float zs = axis.z * s;
		float f10 = axis.x * axis.x * oneminusc + c;
		float f11 = xy * oneminusc + zs;
		float f12 = xz * oneminusc - ys;
		float f20 = xy * oneminusc - zs;
		float f21 = axis.y * axis.y * oneminusc + c;
		float f22 = yz * oneminusc + xs;
		float f30 = xz * oneminusc + ys;
		float f31 = yz * oneminusc - xs;
		float f32 = axis.z * axis.z * oneminusc + c;
		matrix.m10 = this.m10 * f10 + this.m20 * f11 + this.m30 * f12;
		matrix.m11 = this.m11 * f10 + this.m21 * f11 + this.m31 * f12;
		matrix.m12 = this.m12 * f10 + this.m22 * f11 + this.m32 * f12;
		matrix.m13 = this.m13 * f10 + this.m23 * f11 + this.m33 * f12;
		matrix.m20 = this.m10 * f20 + this.m20 * f21 + this.m30 * f22;
		matrix.m21 = this.m11 * f20 + this.m21 * f21 + this.m31 * f22;
		matrix.m22 = this.m12 * f20 + this.m22 * f21 + this.m32 * f22;
		matrix.m23 = this.m13 * f20 + this.m23 * f21 + this.m33 * f22;
		matrix.m30 = this.m10 * f30 + this.m20 * f31 + this.m30 * f32;
		matrix.m31 = this.m11 * f30 + this.m21 * f31 + this.m31 * f32;
		matrix.m32 = this.m12 * f30 + this.m22 * f31 + this.m32 * f32;
		matrix.m33 = this.m13 * f30 + this.m23 * f31 + this.m33 * f32;
		this.load(matrix);
	}

	/**
	 *
	 * @param vector
	 * @since 0.2
	 */
	public void translate(Vector3 vector)
	{
		Matrix matrix = new Matrix();
		matrix.m40 += this.m10 * vector.x + this.m20 * vector.y + this.m30 * vector.z;
		matrix.m41 += this.m11 * vector.x + this.m21 * vector.y + this.m31 * vector.z;
		matrix.m42 += this.m12 * vector.x + this.m22 * vector.y + this.m32 * vector.z;
		matrix.m43 += this.m13 * vector.x + this.m23 * vector.y + this.m33 * vector.z;
		this.load(matrix);
	}

	/**
	 *
	 * @param vector
	 * @since 0.2
	 */
	public void translate(Vector2 vector)
	{
		Matrix matrix = new Matrix();
		matrix.m40 += this.m10 * vector.x + this.m20 * vector.y;
		matrix.m41 += this.m11 * vector.x + this.m21 * vector.y;
		matrix.m42 += this.m12 * vector.x + this.m22 * vector.y;
		matrix.m43 += this.m13 * vector.x + this.m23 * vector.y;
		this.load(matrix);
	}

	/**
	 *
	 * @return
	 * @since 0.2
	 */
	public float getDeterminant()
	{
		float f = m10 * ((m21 * m32 * m43 + m22 * m33 * m41 + m23 * m31 * m42) - m23 * m32 * m41 - m21 * m33 * m42 - m22 * m31 * m43);
		f -= m11 * ((m20 * m32 * m43 + m22 * m33 * m40 + m23 * m30 * m42) - m23 * m32 * m40 - m20 * m33 * m42 - m22 * m30 * m43);
		f += m12 * ((m20 * m31 * m43 + m21 * m33 * m40 + m23 * m30 * m41) - m23 * m31 * m40 - m20 * m33 * m41 - m21 * m30 * m43);
		f -= m13 * ((m20 * m31 * m42 + m21 * m32 * m40 + m22 * m30 * m41) - m22 * m31 * m40 - m20 * m32 * m41 - m21 * m30 * m42);
		return f;
	}

	/**
	 *
	 * @since 0.2
	 */
	public void invert()
	{
		float determinant = this.getDeterminant();
		if (determinant != 0)
		{
			Matrix matrix = new Matrix();
			float detInv = 1f / determinant;
			matrix.m10 = det(m21, m22, m23, m31, m32, m33, m41, m42, m43) * detInv;
			matrix.m11 = -det(m20, m22, m23, m30, m32, m33, m40, m42, m43) * detInv;
			matrix.m12 = det(m20, m21, m23, m30, m31, m33, m40, m41, m43) * detInv;
			matrix.m13 = -det(m20, m21, m22, m30, m31, m32, m40, m41, m42) * detInv;
			matrix.m20 = -det(m11, m12, m13, m31, m32, m33, m41, m42, m43) * detInv;
			matrix.m21 = det(m10, m12, m13, m30, m32, m33, m40, m42, m43) * detInv;
			matrix.m22 = -det(m10, m11, m13, m30, m31, m33, m40, m41, m43) * detInv;
			matrix.m23 = det(m10, m11, m12, m30, m31, m32, m40, m41, m42) * detInv;
			matrix.m30 = det(m11, m12, m13, m21, m22, m23, m41, m42, m43) * detInv;
			matrix.m31 = -det(m10, m12, m13, m20, m22, m23, m40, m42, m43) * detInv;
			matrix.m32 = det(m10, m11, m13, m20, m21, m23, m40, m41, m43) * detInv;
			matrix.m33 = -det(m10, m11, m12, m20, m21, m22, m40, m41, m42) * detInv;
			matrix.m40 = -det(m11, m12, m13, m21, m22, m23, m31, m32, m33) * detInv;
			matrix.m41 = det(m10, m12, m13, m20, m22, m23, m30, m32, m33) * detInv;
			matrix.m42 = -det(m10, m11, m13, m20, m21, m23, m30, m31, m33) * detInv;
			matrix.m43 = det(m10, m11, m12, m20, m21, m22, m30, m31, m32) * detInv;
			this.load(matrix);
		}
	}

	/**
	 *
	 * @since 0.2
	 */
	public void negate()
	{
		Matrix matrix = new Matrix();
		matrix.m10 = -m10;
		matrix.m11 = -m11;
		matrix.m12 = -m12;
		matrix.m13 = -m13;
		matrix.m20 = -m20;
		matrix.m21 = -m21;
		matrix.m22 = -m22;
		matrix.m23 = -m23;
		matrix.m30 = -m30;
		matrix.m31 = -m31;
		matrix.m32 = -m32;
		matrix.m33 = -m33;
		matrix.m40 = -m40;
		matrix.m41 = -m41;
		matrix.m42 = -m42;
		matrix.m43 = -m43;
		load(matrix);
	}

	private float det(float t10, float t11, float t12, float t20, float t21, float t22, float t30, float t31, float t32)
	{
		return t10 * (t21 * t32 - t22 * t31) + t11 * (t22 * t30 - t20 * t32) + t12 * (t20 * t31 - t21 * t30);
	}
}
