package com.echo.javademo.arithmetic;

public class Matrix {
	private final Matrix[] _matrixArray;
	private final int n;
	private int element;
	public Matrix(int n) {
		this.n = n;
		if (n != 1) {
			this._matrixArray = new Matrix[4];
			for (int i = 0; i < 4; i++) {
				this._matrixArray[i] = new Matrix(n / 2);
			}
		} else {
			this._matrixArray = null; 
		}
	}
	private Matrix(int n, boolean needInit) {
		this.n = n;
		if (n != 1) {
			this._matrixArray = new Matrix[4];
		} else {
			this._matrixArray = null; 
		}
	}
	public void set(int i, int j, int a) {
		if (n == 1) {
			element = a;
		} else {
			int size = n / 2;
			this._matrixArray[(i / size) * 2 + (j / size)].set(i % size, j % size, a);
		}
	}
	public Matrix multi(Matrix m) {
		Matrix result = null;
		if (n == 1) {
			result = new Matrix(1);
			result.set(0, 0, (element * m.element));
		} else {
			result = new Matrix(n, false);
			result._matrixArray[0] = P5(m).add(P4(m)).minus(P2(m)).add(P6(m));
			result._matrixArray[1] = P1(m).add(P2(m));
			result._matrixArray[2] = P3(m).add(P4(m));
			result._matrixArray[3] = P5(m).add(P1(m)).minus(P3(m)).minus(P7(m));
		}
		return result;
	}
	public Matrix add(Matrix m) {
		Matrix result = null;
		if (n == 1) {
			result = new Matrix(1);
			result.set(0, 0, (element + m.element));
		} else {
			result = new Matrix(n, false);
			result._matrixArray[0] = this._matrixArray[0].add(m._matrixArray[0]);
			result._matrixArray[1] = this._matrixArray[1].add(m._matrixArray[1]);
			result._matrixArray[2] = this._matrixArray[2].add(m._matrixArray[2]);
			result._matrixArray[3] = this._matrixArray[3].add(m._matrixArray[3]);;
		}
		return result;
	}
	public Matrix minus(Matrix m) {
		Matrix result = null;
		if (n == 1) {
			result = new Matrix(1);
			result.set(0, 0, (element - m.element));
		} else {
			result = new Matrix(n, false);
			result._matrixArray[0] = this._matrixArray[0].minus(m._matrixArray[0]);
			result._matrixArray[1] = this._matrixArray[1].minus(m._matrixArray[1]);
			result._matrixArray[2] = this._matrixArray[2].minus(m._matrixArray[2]);
			result._matrixArray[3] = this._matrixArray[3].minus(m._matrixArray[3]);;
		}
		return result;
	}
	protected Matrix P1(Matrix m) {
		return _matrixArray[0].multi(m._matrixArray[1]).minus(_matrixArray[0].multi(m._matrixArray[3]));
	}
	protected Matrix P2(Matrix m) {
		return _matrixArray[0].multi(m._matrixArray[3]).add(_matrixArray[1].multi(m._matrixArray[3]));
	}
	protected Matrix P3(Matrix m) {
		return _matrixArray[2].multi(m._matrixArray[0]).add(_matrixArray[3].multi(m._matrixArray[0]));
	}
	protected Matrix P4(Matrix m) {
		return _matrixArray[3].multi(m._matrixArray[2]).minus(_matrixArray[3].multi(m._matrixArray[0]));
	}
	protected Matrix P5(Matrix m) {
		return (_matrixArray[0].add(_matrixArray[3])).multi(m._matrixArray[0].add(m._matrixArray[3]));
	}
	protected Matrix P6(Matrix m) {
		return (_matrixArray[1].minus(_matrixArray[3])).multi(m._matrixArray[2].add(m._matrixArray[3]));
	}
	protected Matrix P7(Matrix m) {
		return (_matrixArray[0].minus(_matrixArray[2])).multi(m._matrixArray[0].add(m._matrixArray[1]));
	}
	public int get(int i, int j) {
		if (n == 1) {
			return element;
		} else {
			int size = n / 2;
			return this._matrixArray[(i / size) * 2 + (j / size)].get(i % size, j % size);
		}
	}
	public void display() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(get(i, j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Matrix m = new Matrix(2);
		Matrix n = new Matrix(2);
		m.set(0, 0, 1);
		m.set(0, 1, 3);
		m.set(1, 0, 5);
		m.set(1, 1, 7);
		n.set(0, 0, 8);
		n.set(0, 1, 4);
		n.set(1, 0, 6);
		n.set(1, 1, 2);
		Matrix res = m.multi(n);
		res.display();
	}
 
}