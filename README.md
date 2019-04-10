Шейпфайлът се намира в папка shapefile.

1. Създаваме празна база данни.
2. Отваряме cmd и влизаме с него в папката, където ни е инсталиран Workbench. Пишем командата като сменяме името на базата(goldfinger в случая), username и pass с нашите, ако има нужда и порта, като добавяме пътя до .shp файла. Останалите неща са същите:
ogr2ogr -f MySQL MySQL:goldfinger,host=localhost,port=3306,user=root,password=189189 C:\Users\Acer\Downloads\Bulgaria_shapefile\bg_1km.shp -nln shapes -u
3. Оправяме си данните за базата в application.properties.