package com.goit.module1;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import static com.goit.module1.Constants.*;

/**
 * Created by ANTON on 22.08.2016.
 */
public class ExcelWriter {

    private FileOutputStream outputStream;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;


    public ExcelWriter() throws FileNotFoundException {
        outputStream = new FileOutputStream(new File(PATH_EXCEL_FILE));
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(SHEET_NAME);
    }

    void prepareTable () {
        HSSFRow headingRow  = sheet.createRow(0);

        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderBottom(CellStyle.BORDER_DOUBLE);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        headingRow.createCell(COLLECTION_NAME).setCellValue(HEADING_COLLECTION_COLUMN);
        headingRow.createCell(OPERATION_ADD).setCellValue(HEADING_OPERATION_ADD);
        headingRow.createCell(OPERATION_GET).setCellValue(HEADING_OPERATION_GET);
        headingRow.createCell(OPERATION_REMOVE).setCellValue(HEADING_OPERATION_REMOVE);
        headingRow.createCell(OPERATION_CONTAINS).setCellValue(HEADING_OPERATION_CONTAINS);
        headingRow.createCell(OPERATION_POPULATE).setCellValue(HEADING_OPERATION_POPULATE);
        headingRow.createCell(OPERATION_ITERATOR_ADD).setCellValue(HEADING_OPERATION_ITERATOR_ADD);
        headingRow.createCell(OPERATION_ITERATOR_REMOVE).setCellValue(HEADING_OPERATION_ITERATOR_REMOVE);

        sheet.createRow(ARRAY_LIST).createCell(COLLECTION_NAME).setCellValue(ARRAY_LIST_NAME);
        sheet.createRow(LINKED_LIST).createCell(COLLECTION_NAME).setCellValue(LINKED_LIST_NAME);
        sheet.createRow(HASH_SET).createCell(COLLECTION_NAME).setCellValue(HASH_SET_NAME);
        sheet.createRow(TREE_SET).createCell(COLLECTION_NAME).setCellValue(TREE_SET_NAME);

        for (int i = 0; i < COLUMN_AMOUNT; i++) {
            headingRow.getCell(i).setCellStyle(cellStyle);
            sheet.autoSizeColumn(i);
        }

    }

    void fillExcelTable(Map<String, Double> map) throws IOException {

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_POPULATE).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_POPULATE));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_POPULATE).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_POPULATE));
        sheet.getRow(HASH_SET).createCell(OPERATION_POPULATE).setCellValue(map.get(HASH_SET_NAME + HEADING_OPERATION_POPULATE));
        sheet.getRow(TREE_SET).createCell(OPERATION_POPULATE).setCellValue(map.get(TREE_SET_NAME + HEADING_OPERATION_POPULATE));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_ADD).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_ADD));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_ADD).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_ADD));
        sheet.getRow(HASH_SET).createCell(OPERATION_ADD).setCellValue(map.get(HASH_SET_NAME + HEADING_OPERATION_ADD));
        sheet.getRow(TREE_SET).createCell(OPERATION_ADD).setCellValue(map.get(TREE_SET_NAME + HEADING_OPERATION_ADD));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_REMOVE).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_REMOVE));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_REMOVE).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_REMOVE));
        sheet.getRow(HASH_SET).createCell(OPERATION_REMOVE).setCellValue(map.get(HASH_SET_NAME + HEADING_OPERATION_REMOVE));
        sheet.getRow(TREE_SET).createCell(OPERATION_REMOVE).setCellValue(map.get(TREE_SET_NAME + HEADING_OPERATION_REMOVE));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_CONTAINS).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_CONTAINS));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_CONTAINS).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_CONTAINS));
        sheet.getRow(HASH_SET).createCell(OPERATION_CONTAINS).setCellValue(map.get(HASH_SET_NAME + HEADING_OPERATION_CONTAINS));
        sheet.getRow(TREE_SET).createCell(OPERATION_CONTAINS).setCellValue(map.get(TREE_SET_NAME + HEADING_OPERATION_CONTAINS));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_GET).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_GET));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_GET).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_GET));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_ITERATOR_ADD).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_ITERATOR_ADD));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_ITERATOR_ADD).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_ITERATOR_ADD));

        sheet.getRow(ARRAY_LIST).createCell(OPERATION_ITERATOR_REMOVE).setCellValue(map.get(ARRAY_LIST_NAME + HEADING_OPERATION_ITERATOR_REMOVE));
        sheet.getRow(LINKED_LIST).createCell(OPERATION_ITERATOR_REMOVE).setCellValue(map.get(LINKED_LIST_NAME + HEADING_OPERATION_ITERATOR_REMOVE));

        workbook.write(outputStream);

        for (int i = 0; i < COLUMN_AMOUNT; i++) {

        }

    }

}
