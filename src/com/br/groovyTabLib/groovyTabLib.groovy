package com.br.groovyTabLib

/**
 * Created by anderson on 12/12/16.
 *
 * Quero poder acessar a groovyTabLib da seguinte forma:
 *
 * EX1:
 * def data = new DataSet(["first", "second"], [[1, 2]])
 * data.xlsx(new FileOutputStream("file.xlsx"))
 *
 *
 * EX2:
 * def data = new DataSet(headers=["First Name", "Last Name", "Age"])
 *
 * def pessoas = [["Anderson", "Morais", 27], ["Ilana", "Ribeiro", 21]]
 *
 * pessoas.each{
 *     data.add(pessoa)
 * }
 *
 * new File("students.xls") << data.xls()
 *
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.*

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.br.errors.InvalidDimensions

class DataSet{
    def headers = []
    def rows = []

    DataSet(){}

    DataSet(headers, data){
        if(headers){
            this.headers = headers
        }

        if (data){
            data.each{ row ->
                createRowObject(row)
            }
        }
    }

    def setHeaders(headers){
        if(this.rows){
            if(this.width() != headers.size()){
                throw new InvalidDimensions("headers and data has differents dimensions")
            }
        }

        this.headers = headers
    }

    def setRows(rows){
        validateHeadersDimensions(rows[0])
        rows.each { row ->
            createRowObject(row)
        }

    }

    def add(row){
        /* Adiciona uma nova linha ou Row */
        validateHeadersDimensions(row)
        createRowObject(row)
    }

    def addAll(data){
        validateHeadersDimensions(data)
        data.each{ row ->
            createRowObject(row)
        }
    }

    def validateHeadersDimensions(data){
        if(this.headers){
            if(this.headers.size() != data.size()){
                throw new InvalidDimensions("headers and data has differents dimensions")
            }
        }
    }

    def width(){
        def column_size

        if(this.rows){
            column_size = this.rows[0].size()
        } else{
            column_size = 0
        }

        return column_size
    }

    // Para que eu possa usar o açucar sintático das listas
    def getAt(int index){
        return rows[index]
    }

    def createRowObject(row){
        this.rows.add(new Row(columns: row))
    }

    def xls(){
        /* params: file -> FileOutputStream */

        HSSFWorkbook wb = new HSSFWorkbook()
        def sheetName = "sheet1"
        Sheet sheet = wb.createSheet(sheetName)

        def rows_aux = []

        if(headers) rows_aux.add(new Row(columns: this.headers))
        if(rows) rows_aux.addAll(rows)

        rows_aux.eachWithIndex{ row, i ->
            createSheetRow(row, sheet, i)
        }

        return wb.getBytes()
    }

    def xlsx(file){
        XSSFWorkbook wb = new XSSFWorkbook()
        def sheetName = "sheet1"
        XSSFSheet sheet = wb.createSheet(sheetName)

        def rows_aux = []

        if(headers) rows_aux.add(new Row(columns: this.headers))
        if(rows) rows_aux.addAll(rows)

        rows_aux.eachWithIndex{ row, i ->
            createSheetRow(row, sheet, i)
        }

        return wb.write(file)
    }

    def createSheetRow(row, sheet, i) {
        def line = sheet.createRow(i)
        row.createCells(line)
    }
}

class Row {
    def columns = []

    // Para que eu possa usar o açucar sintático das listas Row[indice]
    def getAt(int index) {
        return columns[index]
    }

    def size(){
        return columns.size()
    }

    def createCells(line){
        columns.eachWithIndex{ column, i ->
            def cell = line.createCell(i)
            cell.setCellValue(column)
        }
    }
}