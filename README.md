# groovyTabLib: Biblioteca groovy para dados tabulares em XLS, XLSX, CSV, JSON e etc.

## Inspirada na [tablib][tabliblink] de Kenneth Reitz 
***
groovyTabLib é uma biblioteca para trabalhar com dados tabulares, escrito em groovy. 
Exportação suportadas:
 - XLS
 - XLSX
 - CSV (em breve)
 - JSON (em breve) 
 - outros (em breve)
 ### Visão geral
***
**tablib.DataSet()**
É uma tabela de dados tabulares. Constrói e manipula listas do groovy. Pode ser exportado para XLS, XLSX e em breve será exportado para outros formatos, além de importá-los também.

### Como usar ?
***
```groovy
import com.br.groovyTabLib.DataSet

def dataset = new DataSet(["nome", "idade"], [["Anderson", 27]])
```
Adicionando nova linha
```groovy
dataset.add(["Lanna", 25])
```
### Exportando
***
:D

### XLS
```groovy
new File("test1.xls") << dataset.xls()
```

### XLSX
```groovy
dataset.xlsx(new FileOutputStream("test2.xlsx"))
```
### Instalação
***
Fazer download de groovyTabLib.jar que está no diretório out/artifacts/groovyTabLib_jar e adicionar a path do seu projeto groovy/grails. 
Muito Fácil :D

### Versão
0.1

Licença
----

Copyright 2016 Anderson Marques

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

**Free Software, Hell Yeah!**