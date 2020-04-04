package Utilidades;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class DatosExcel {
	public static Object[][] leerExcel(String ruta, String nombreHoja) throws Exception {
		
		FileInputStream file = new FileInputStream(new File(ruta));
		
		XSSFWorkbook libroExcel = new XSSFWorkbook(file);
		XSSFSheet Hoja = libroExcel.getSheet(nombreHoja);

		System.out.println(nombreHoja);
		XSSFRow fila;

		int filas = Hoja.getPhysicalNumberOfRows();

		System.out.println(filas);
		int columnas = Hoja.getRow(0).getPhysicalNumberOfCells();
		System.out.println(columnas);
		Object cellValue[][] = new Object[filas - 1][columnas];

		for (int r = 1; r < filas; r++) {
			fila = Hoja.getRow(r);
			if (fila == null) {
				break;
			} else {
				System.out.print("Row: " + r + " -> ");
				for (int c = 0; c < columnas; c++) {
					cellValue[r - 1][c] = Hoja.getRow(r).getCell(c).getStringCellValue();
				}
				System.out.println();
			}

		}
		return cellValue;

	}
}
