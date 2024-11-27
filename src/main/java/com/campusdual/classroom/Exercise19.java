package com.campusdual.classroom;

import java.sql.Array;
import java.util.Arrays;

public class Exercise19 {

  private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

    int rows = intArrayTri[0].length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      sb.append(stringFlatMatrixRow(flatMatrix, i));
      sb.append("   →   ");
      sb.append(stringTriMatrixRow(intArrayTri, i));
      sb.append("\n");
    }
    sb.delete(sb.length() - 1, sb.length());
    return sb.toString();

  }

  private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < intArrayTri.length - 1; i++) {
      sb.append(getUnidimensionalString(intArrayTri[i][row]));
      sb.append("   ");
    }
    sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

    return sb.toString();
  }

  private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
    return getUnidimensionalString(flatMatrix[row]);
  }

  public static String getTridimensionalString(int[][][] intArrayTri) {
    int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
    return getTridimensionalString(intArrayTri, flatMatrix);
  }

  public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
    int[][] flatArray = new int[intArrayTri.length][intArrayTri.length];
    for (int i = 0; i < intArrayTri.length; i++) {
      for (int j = 0; j < intArrayTri[i].length; j++) {
        for (int k = 0; k < intArrayTri[j][i].length; k++) {
          flatArray[j][i] = flatArray[j][i] + intArrayTri[k][j][i];
        }
      }
    }
    return flatArray;
  }

  public static String getBidimensionalString(int[][] intArrayBi) {
    StringBuilder stringBuilderRows = new StringBuilder();
    for (int i = 0; i < intArrayBi.length; i++) {
      StringBuilder stringBuilderColumn = new StringBuilder();

      for (int j = 0; j < intArrayBi[i].length; j++) {
        stringBuilderColumn.append(intArrayBi[i][j]);
        stringBuilderColumn.append(" ");
      }
      stringBuilderRows.append(stringBuilderColumn.toString().trim());
      stringBuilderRows.append("\n");
    }
    return stringBuilderRows.toString().trim();
  }

  public static String getUnidimensionalString(int[] uniArray) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < uniArray.length; i++) {
      stringBuilder.append(uniArray[i]);
      stringBuilder.append(" ");
    }
    return stringBuilder.toString().trim();
  }

  public static int[] createAndPopulateUnidimensionalArray(int columns) {
    int[] array = new int[columns];
    for (int i = 0; i < columns; i++) {
      array[i] = i + 1;
    }
    return array;
  }

  public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
    int[][] array = new int[rows][columns];
    int count = 1;
    for (int j = 0; j < rows; j++) {
      for (int i = 0; i < columns; i++) {
        array[j][i] = count;
        count++;
      }
    }
    return array;
  }

  public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
    int[][][] array = new int[depth][rows][columns];
    int count = 1;

    for (int k = 0; k < depth; k++) {
      for (int j = 0; j < rows; j++) {
        for (int i = 0; i < columns; i++) {
          array[k][j][i] = count;
          count++;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    int[] uniArray = createAndPopulateUnidimensionalArray(5);
    System.out.println(getUnidimensionalString(uniArray));
    System.out.println("===================");
    int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
    System.out.println(getBidimensionalString(intArrayBi));
    System.out.println("===================");
    int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
    System.out.println(getTridimensionalString(intArrayTri));
  }
}
