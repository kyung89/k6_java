package Chap2_기본자료구조;

import java.util.Random;

class Matrix{

	   int cols,rows;
	   int[] data;
	   
	   public Matrix(int rows, int cols) {
		   this.cols = cols;
		   this.rows = rows;
		   this.data = new int[cols * rows];
	   }

	   public void inputMatrix(){
		   Random rnd = new Random();
		   for(int i = 0; i < cols * rows; i++) data[i] = rnd.nextInt(10);
	   }

	   public void showMatrix() {
		   for(int i = 0; i < rows; i++) {
			   for(int j = 0; j < cols; j++)
				   System.out.print(data[i * cols + j] + "\t");
			   System.out.println();
		   }
		   System.out.println();
	   }
	   
	   public Matrix addMatrix(Matrix m) {
		   if(this.cols != m.cols || this.rows != m.rows) return null;
		   Matrix result = new Matrix(this.rows, this.cols);
		   
		   for(int idx = 0; idx < this.rows * this.cols; idx++)
			   result.data[idx] = this.data[idx] + m.data[idx];
		
		   return result;
	   }
	   
	   public Matrix multiplyMatrix(Matrix m) {
		   Matrix result = new Matrix(this.rows, m.cols);
			
			// i, j, rows, cols
			// idx = i * cols + j
			
			for(int i = 0; i < this.rows; i++)
				for(int j = 0; j < m.cols; j++)
					for(int k = 0; k <this.cols; k++)
						result.data[i * m.cols + j] += this.data[i * this.cols + k] * m.data[k * m.cols + j];
			
			return result;	
	   }
	   
	   public Matrix transposeMatrix() {
		   	Matrix result = new Matrix(this.cols, this.rows); // B[rows = 3][cols = 4] ->  F[cols = 4][rows = 3]
			
	 		for(int idx = 0; idx < this.rows * this.cols; idx++)
	 			result.data[idx] = this.data[cols * (idx % rows) + (idx / rows)];
			
			return result;
	   }
}

public class 고급과제_행렬연산클래스 {
	
		public static void main(String[] args) {
			Matrix A = new Matrix(2,3);
			Matrix B = new Matrix(2,3);
			Matrix C = new Matrix(3,2);

			A.inputMatrix();
			B.inputMatrix();
			C.inputMatrix();
			
			System.out.println("[A 행렬(2,3)]");
			A.showMatrix();
			System.out.println("[B 행렬(2,3)]");
			B.showMatrix();
			System.out.println("[C 행렬(3,2)]");
			C.showMatrix();
			
			// add matrix
			Matrix D = A.addMatrix(B);
			System.out.println("[D 행렬 = A + B]");
			D.showMatrix();
			
			// multiply matrix
			Matrix E = A.multiplyMatrix(C);
			System.out.println("[E 행렬 = A x C]");
			E.showMatrix();
			
			// transpose matrix
			Matrix F = A.transposeMatrix();
			System.out.println("[F 행렬 = A 의 전치행렬]");
			F.showMatrix();

		}
}