package com.br.examples

import com.br.groovyTabLib.DataSet

/**
 * Created by anderson on 28/12/16.
 */

def data = []
def range = 0..20

range.each {
    data.add(["Anderson", 22])
}

// Example 1
def dataset1 = new DataSet(["nome", "idade"], data)

// xls file
new File("test1.xls") << dataset1.xls()


// Example 2
def dataset2 = new DataSet(headers: ["nome", "idade"])
range.each {
    dataset2.add(["Lanna", 25])
}

// xls file
new File("test2.xls") << dataset2.xls()


// Example 3
def dataset3 = new DataSet()
dataset3.headers = ["nome", "idade"]
dataset3.rows = [['ada', 76]]

// xls file
new File("test3.xls") << dataset3.xls()


// Example 4
def dataset4 = new DataSet(headers: ["nome", "idade"], rows: [['anderson', 27]])

// xls file
new File("test4.xls") << dataset4.xls()


// Example 5
def dataset5 = new DataSet(headers: ["nome", "sobrenome"], rows: [['anderson', 'marques']])
println(dataset5.width()) // Quantidade de colunas


