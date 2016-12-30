package com.br.examples

import com.br.groovyTabLib.DataSet

/**
 * Created by anderson on 28/12/16.
 */

def data = []
def range = 0..20

range.each {
    data.add(["Anderson", "22"])
}

// Example 1
def dataset1 = new DataSet(["nome", "idade"], data)

// xlsx file.  obs: Is needed to send a FileOutputStream
dataset1.xlsx(new FileOutputStream("test1.xlsx"))


// Example 2
def dataset2 = new DataSet(headers: ["nome", "idade"])
range.each {
    dataset2.add(["Lanna", "25"])
}

// xlsx file.  obs: Is needed to send a FileOutputStream
dataset2.xlsx(new FileOutputStream("test2.xlsx"))


// Example 3
def dataset3 = new DataSet()
dataset3.headers = ["nome", "idade"]
dataset3.rows = [['BH', 76]]


// xlsx file.  obs: Is needed to send a FileOutputStream
dataset3.xlsx(new FileOutputStream("test3.xlsx"))


// Example 4
def dataset4 = new DataSet(headers: ["nome", "idade"], rows: [['anderson', 'marques']])

// xlsx file.  obs: Is needed to send a FileOutputStream
dataset4.xlsx(new FileOutputStream("test4.xlsx"))


// Example 5
def dataset5 = new DataSet(headers: ["nome", "idade"], rows: [['anderson', 'marques']])
println(dataset5.width()) // Quantidade de colunas

