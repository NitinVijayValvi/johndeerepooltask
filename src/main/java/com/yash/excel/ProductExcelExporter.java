package com.yash.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yash.excel.model.Product;


public class ProductExcelExporter {

	private XSSFWorkbook workbook;
	private Sheet sheet;

	private List<Product> listProducts;

	public ProductExcelExporter(List<Product> listProducts) {
		super();
		this.listProducts = listProducts;

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Products");
	}

	private void writeHeaderRow() {

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Product Id");
		cell = row.createCell(1);
		cell.setCellValue("Title");
		cell = row.createCell(2);
		cell.setCellValue("Description");
		cell = row.createCell(3);
		cell.setCellValue("Price");
		cell = row.createCell(4);
		cell.setCellValue("DISCOUNT");
		cell = row.createCell(5);
		cell.setCellValue("Rating");
		cell = row.createCell(6);
		cell.setCellValue("Stock");
		cell = row.createCell(7);
		cell.setCellValue("Brand");
		cell = row.createCell(8);
		cell.setCellValue("Category");
	}

	private void writeDataRows() {

		int rowCount = 1;
		for(Product product : listProducts) {
			Row row = sheet.createRow(rowCount++);
			
			Cell cell = row.createCell(0);
			cell.setCellValue(product.getId());
			
			
			cell = row.createCell(1);
			cell.setCellValue(product.getTitle());
			
			cell = row.createCell(2);
			cell.setCellValue(product.getDescription());
			
			cell = row.createCell(3);
			cell.setCellValue(product.getPrice());
			
			cell = row.createCell(4);
			cell.setCellValue(product.getDiscountPercentage());
			
			cell = row.createCell(5);
			cell.setCellValue(product.getRating());
			
			cell = row.createCell(6);
			cell.setCellValue(product.getStock());
			
			cell = row.createCell(7);
			cell.setCellValue(product.getBrand());
			
			cell = row.createCell(8);
			cell.setCellValue(product.getCategory());
			
		}
	}

	public void export(HttpServletResponse response) throws IOException {

		writeHeaderRow();
		writeDataRows();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
